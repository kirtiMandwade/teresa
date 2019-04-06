package com.formapp.userdao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.formapp.model.Appendice;
import com.formapp.repository.Appendice1Repository;

@Repository
@Transactional
public  class ApendiceDAOImpl implements ApendiceDAO {

	
	@Autowired
	private Appendice1Repository apendiceRepository;

	@Override
	public void save(Appendice app) {

		Appendice apendice= apendiceRepository.findByAppendiceName(app.getAppendiceName());
		
		if(apendice!= null)
		{
	
			apendice.setColumnsCount(app.getColumnsCount());
			apendice.setColumnsName(app.getColumnsName());
			apendiceRepository.save(apendice);
		}
		else
		{
			apendiceRepository.save(app);
		}
	}
	
}
