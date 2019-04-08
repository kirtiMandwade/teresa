package com.formapp.userdao;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.formapp.model.FormData;
import com.formapp.model.FormFields;
import com.formapp.model.mysql.AuditBase;
import com.formapp.model.mysql.Identificadores;
import com.formapp.model.mysql.Pedimento;

@Repository
@Transactional
public class Genericdao {
	@Value("${package.path}")
	private String pckgpath;
	
	
	@Value("${db.name}")
	private String dnName;
	

    @PersistenceContext
    private EntityManager em;
    
	
	
	 
	/* public void create( Object entity ){
	      em.persist(entity);
	      
	      
	   }*/

		public Object create( Object entity ){
		
		em.persist(em.contains(entity) ? entity : em.merge(entity));
		em.flush();
		return entity;
		
		}
		
		public Object delete( Object entity ){
			em.remove(em.contains(entity) ? entity : em.merge(entity));

			
			em.flush();
			return null;
			
			}
		public List<AuditBase> getPedimentoByUniqueId(String code, long id) {
			String queryString ="Select * from `"+code +"` where Número_de_Pedimento =:rowId";
			Query query= em.createNativeQuery(queryString,Pedimento.class);

			query.setParameter("rowId",id);
			List<AuditBase> rowList = query.getResultList();
			return rowList;
			}
		
	 public List<Object []> getAllDataForMfilw( FormData formData ,long número_de_Pedimento ){
		 List<FormFields> ffList = formData.getFields();
		 String coloumnNames = "id ,";
		 for (FormFields formFields : ffList) {
				if(formData.getCode().equals("510")|| formData.getCode().equals("557")) 
			 	{
					if(formFields.isShow())
					{
						coloumnNames = coloumnNames +formFields.getName() +", ";
					}
			 	}
				else
				{
					coloumnNames = coloumnNames +formFields.getName() +", ";

				}
				
			 
		}
		 coloumnNames = coloumnNames.substring(0, coloumnNames.length()-2);
		 System.out.println("coloumnNames " +coloumnNames);
		 String queryString = "select "+coloumnNames+" from `"+formData.getCode()+"` where clave_formulario_principal=:id ";
		 
		 System.out.println("queryString " +queryString);
	      
		 Query query= em.createNativeQuery(queryString);
		 query.setParameter("id", número_de_Pedimento);
		 List<Object []> resultList = query.getResultList();
	      	return resultList;
	   }
	 
	 
	
	 public List<Object []> getAll( FormData formData ){
		 List<FormFields> ffList = formData.getFields();
		 String coloumnNames = "id ,";
		 for (FormFields formFields : ffList) {
			 
			 if(formFields.isShow())
			 {
				 
				 		coloumnNames = coloumnNames +formFields.getName() +", ";

				 	}
		}
		 coloumnNames = coloumnNames.substring(0, coloumnNames.length()-2);
		 System.out.println("coloumnNames " +coloumnNames);
		 String queryString = "select "+coloumnNames+" from `"+formData.getCode()+"`";
		 
		 System.out.println("queryString " +queryString);
	      
		 Query query= em.createNativeQuery(queryString);
		 List<Object []> resultList = query.getResultList();
	      	return resultList;
	   }
	 
	 public List<Object []> getgenerlasData( FormData formData ){
		 List<FormFields> ffList = formData.getFields();
		 String coloumnNames = "id , clave_del_Tipo_de_Registro , patente_o_autorización , número_de_pedimento ,aduana_sección_de_Despacho ";
		/* for (FormFields formFields : ffList) {
			 
			 if(formFields.isShow())
			 {
				 	
				 coloumnNames = coloumnNames +formFields.getName() +", ";
			 }
		}*/
		 //coloumnNames = coloumnNames.substring(0, coloumnNames.length()-2);
		 System.out.println("coloumnNames " +coloumnNames);
		 
		 String queryString = "select "+coloumnNames+" from `"+formData.getCode()+"`";
		 
		 System.out.println("queryString " +queryString);
	      
		 Query query= em.createNativeQuery(queryString);
		 List<Object []> resultList = query.getResultList();
	      	return resultList;
	   }
	 
	 public  List<Object []> getParentId( FormData formData ,long número_de_pedimento ){
		System.out.println("in generic parentid function" +formData);
		 List<FormFields> ffList = formData.getFields();
		 String coloumnNames = "id ,";
		 for (FormFields formFields : ffList) {
				if(formData.getCode().equals("510")|| formData.getCode().equals("557")) 
			 	{
					if(formFields.isShow())
					{
						coloumnNames = coloumnNames +formFields.getName() +", ";
					}
			 	}
				else
				{
					coloumnNames = coloumnNames +formFields.getName() +", ";

				}
				
			 
		}
		 coloumnNames = coloumnNames.substring(0, coloumnNames.length()-2);
		 String queryString = "select "+coloumnNames+" from `"+formData.getCode()+"` where número_de_pedimento =:ndp";
		System.out.println("queryString "+queryString);
		 Query query= em.createNativeQuery(queryString);
		 query.setParameter("ndp", número_de_pedimento);
		 List<Object []> resultlist =   query.getResultList();
	 System.out.println("requst list "+ resultlist);
		return	resultlist ;
	   }
	 
	 

	 public List<String> getAllColumName( FormData formData ){
		 
		 String queryString =" SELECT `COLUMN_NAME`  FROM `INFORMATION_SCHEMA`.`COLUMNS` WHERE `TABLE_SCHEMA`=:db AND `TABLE_NAME`=:yourtablename";
	      Query query= em.createNativeQuery(queryString);
	      query.setParameter("db",dnName);
	      query.setParameter("yourtablename", formData.getCode());
		System.out.println("em.getMetamodel() "+query.getResultList());

	      	return query.getResultList();
	   }

	public List<AuditBase> getRowData(String code, String id,Class mappingClass) {
		 int rowId = Integer.parseInt(id);
		 String queryString ="Select * from `"+code +"` where id =:rowId";
		 Query query= em.createNativeQuery(queryString,mappingClass);
		
	      query.setParameter("rowId",rowId);
	      List<AuditBase> rowList = query.getResultList();
	      return rowList;
	}
	
	public List<AuditBase> getData(String code,Class mappingClass,int id) {
		 String queryString ="Select * from `"+code +"` where número_de_pedimento=:id ";
		 Query query= em.createNativeQuery(queryString,mappingClass);
	      query.setParameter("id",id);

	      List<AuditBase> rowList = query.getResultList();

	      return rowList;
	}

	public int deleteRowData(String code, String id) {
		 int rowId = Integer.parseInt(id);
		 String queryString ="delete from `"+code +"` where id =:rowId";
		 Query query= em.createNativeQuery(queryString);
		
	      query.setParameter("rowId",rowId);
	     int status = query.executeUpdate();
		return status;
	}
	
	
	public List<String> getpedimentoTable( FormData formData ){
		 
		 String queryString =" SELECT `COLUMN_NAME`  FROM `INFORMATION_SCHEMA`.`COLUMNS` WHERE `TABLE_SCHEMA`=:db AND `TABLE_NAME`=:yourtablename";
	      Query query= em.createNativeQuery(queryString);
	      query.setParameter("db",dnName);
	      query.setParameter("yourtablename", formData.getCode());
			 System.out.println("em.getMetamodel() "+query.getResultList());

	      	return query.getResultList();
	   }

	public List<? extends AuditBase> getPedimentoData(String code,Class mappingClass) {
		 String queryString ="Select * from `"+code +"`";
		 Query query= em.createNativeQuery(queryString,mappingClass);
		
	      List<AuditBase> rowList = query.getResultList();
	      return rowList;
	}
	
}
