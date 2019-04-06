package com.formapp.userservice;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.formapp.error.InvalidFileException;
import com.formapp.model.Appendice;
import com.formapp.model.mysql.User;
import com.formapp.userdao.ApendiceDAO;
import com.formapp.userdao.UserDAO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDao;
	@Autowired
	private ApendiceDAO apendiceDao;
	
	@Value("${upload.file.extensions}")
	private String validExtensions;

	@Override
	public <S extends User> S save(S user) {
		
		return userDao.save(user);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	@Override
	public void deleteUser(String userId) {
		// TODO Auto-generated method stub
		userDao.deleteUser(userId);
	}

	@Override
	public <S extends User> S updateUser(S user) {
		// TODO Auto-generated method stub
		return userDao.updateUser(user);
	}
	@Override
	public File uploadFile(MultipartFile file, String uploadDirectory) throws InvalidFileException, IOException {
		String fileName = handleFileName(file.getOriginalFilename(), uploadDirectory);
		Path path = Paths.get(uploadDirectory, fileName);
		/*Files.deleteIfExists(path);*/
		Files.copy(file.getInputStream(), path);
		HSSFWorkbook my_xls_workbook = new HSSFWorkbook(file.getInputStream()); //Read the Excel Workbook in a instance object    
	      
        HSSFSheet my_worksheet = my_xls_workbook.getSheetAt(0); //This will read the sheet for us into another object
       
        int cellCount = my_worksheet.getRow(0).getLastCellNum();
        System.out.println("cellCount"+cellCount);
        Appendice app = new Appendice();
        ArrayList<String> colName = new ArrayList<String>();
        for (int i = 0; i <cellCount; i++) {
        	colName.add(my_worksheet.getRow(0).getCell(i).getStringCellValue());
			
		}
  
        
        System.out.println(fileName+ " 	colName "+my_worksheet.getRow(0).getCell(0).getStringCellValue());
       
        String extension = getFileExtension(fileName);
		String fileBaseName = fileName.substring(0, fileName.length() - extension.length() - 1);
		
		app.setAppendiceName(fileBaseName);
		app.setColumnsCount(cellCount);
		app.setColumnsName(colName);
		apendiceDao.save(app);
		return null;
	}
	

	private String getFileExtension(String fileName) {
		int dotIndex = fileName.lastIndexOf(".");
		if (dotIndex < 0) {
			return null;
		}
		return fileName.substring(dotIndex + 1);
	}

	private String handleFileName(String fileName, String uploadDirectory) throws InvalidFileException, IOException {
		String cleanFileName = fileName.replaceAll("[^A-Za-z0-9.()]", "");
		String extension = getFileExtension(cleanFileName);

		if (!isValidExtension(cleanFileName)) {
			throw new InvalidFileException("Invalid File Extension");
		}
		;
		if (Files.exists(Paths.get(uploadDirectory, cleanFileName)))
		{
				System.out.println("file exist");
				Files.delete(Paths.get(uploadDirectory, cleanFileName));
		}
		
	
		String base = cleanFileName.substring(0, cleanFileName.length() - extension.length() - 1);

		int openParIndex = getOpenParenthesisIndex(base);

		/*if (openParIndex > 0) {
			base = base.substring(0, openParIndex);
			cleanFileName = base + "." + extension;
		}
*/
		/*if (Files.exists(Paths.get(uploadDirectory, cleanFileName))) {
			
		
			//cleanFileName = base + "(1)." + extension;
		}

		if (Files.exists(Paths.get(uploadDirectory, cleanFileName))) {
			
			cleanFileName = base + "(1)." + extension;
		}

		while (Files.exists(Paths.get(uploadDirectory, cleanFileName))) {
			
			String nString = cleanFileName.substring(base.length() + 1,
					cleanFileName.length() - extension.length() - 2);
			int n = Integer.parseInt(nString) + 1;
			cleanFileName = base + "(" + n + ")." + extension;
		}*/

		return cleanFileName;
	}

	private int getOpenParenthesisIndex(String baseFileName) {
		int openParIndex = baseFileName.lastIndexOf("(");
		int closeParIndex = baseFileName.lastIndexOf(")");
		boolean isParenthesis = openParIndex > 0 && closeParIndex == baseFileName.length() - 1;

		if (isParenthesis && baseFileName.substring(openParIndex + 1, closeParIndex).matches("[1-9][0-9]*")) {
			return openParIndex;
		} else {
			return -1;
		}
	}

	private boolean isValidExtension(String cleanFileName) throws InvalidFileException {
		String fileExtension = getFileExtension(cleanFileName);

		if (fileExtension == null) {
			throw new InvalidFileException("no file Extension");
		}
		fileExtension = fileExtension.toLowerCase();

		for (String validExtension : validExtensions.split(",")) {
			if (fileExtension.equals(validExtension)) {
				return true;
			}
		}
		return false;
	}
	
}

