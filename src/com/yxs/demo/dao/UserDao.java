package com.yxs.demo.dao;

import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.cfg.Configuration;  
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.yxs.demo.entity.UserEntity;

public class UserDao extends BaseDao {
	
	public UserDao(){
		
	}
	
	public void add(UserEntity user){
		//读取hibernate.cfg.xml文件  
	    Configuration config = new Configuration().configure();
	    //建立SessionFactory  
	    ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
	    SessionFactory factory = config.buildSessionFactory(serviceRegistry);
	    
	    //取得session  
	    Session session = null;  
	      
	    try{  
	        //开启session  
	        session = factory.openSession();  
	        //开启事务  
	        session.beginTransaction();  
	          
	        //保存User对象  
	        session.save(user);  
	          
	        //提交事务  
	        session.getTransaction().commit();  
	          
	    }catch(Exception e){  
	        e.printStackTrace();  
	        //回滚事务  
	        session.getTransaction().rollback();  
	    }finally{  
	        if(session != null){  
	            if(session.isOpen()){  
	                //关闭session  
	                session.close();  
	            }  
	        } 
	    }
	}
}
