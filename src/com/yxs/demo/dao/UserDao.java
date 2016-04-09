package com.yxs.demo.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.TransactionException;
import org.hibernate.cfg.Configuration;  
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.yxs.demo.entity.UserEntity;

public class UserDao extends BaseDao {
	
	public UserDao(){
		
	}
	
	public void add(UserEntity user){
		//读取hibernate.cfg.xml文件  
	    Configuration config = null;
	    //建立SessionFactory  
	    ServiceRegistry serviceRegistry = null;
	    SessionFactory factory = null;
	    
	    //取得session  
	    Session session = null;  
	      
	    try{
			//读取hibernate.cfg.xml文件  
		    config = new Configuration().configure();
		    //建立SessionFactory  
		    serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		    factory = config.buildSessionFactory(serviceRegistry);

	        //开启session  
	        session = factory.openSession();  
	        //开启事务  
	        session.beginTransaction();  
	          
	        //保存User对象  
	        session.save(user);  
	          
	        //提交事务  
	        session.getTransaction().commit();  
	          
	    }catch(HibernateException e){
	    	logger.error(e.getMessage());
	    	try{
	    		session.getTransaction().rollback();
	    	}catch(Exception ex){
		        //e.printStackTrace();
		    	logger.error(ex.getMessage());
	    	}
	    }catch(Exception e){
	        //e.printStackTrace();
	    	logger.error(e.getMessage());
	        //回滚事务 
	    	try{
	    		session.getTransaction().rollback();
	    	}catch(Exception ex){
		        //e.printStackTrace();
		    	logger.error(ex.getMessage());
	    	}
	    }finally{  
	        if(session != null){
	        	logger.debug(session.toString());
	        	try{
		            if(session.isOpen()){  
		                //关闭session  
		                session.close();  
		            }
	            }catch(Exception ex){
			        //e.printStackTrace();
			    	logger.error(ex.getMessage());
		    	}
	        } 
	    }
	}
}
