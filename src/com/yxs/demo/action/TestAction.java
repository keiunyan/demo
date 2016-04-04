package com.yxs.demo.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.yxs.demo.dao.UserDao;
import com.yxs.demo.entity.UserEntity;

public class TestAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6371517936683568302L;
	
	public void t() {
		response = ServletActionContext.getResponse();
		Gson gson = new Gson();
		Map<String,String> m = new LinkedHashMap<String,String>();
		m.put("code", "0000");
		m.put("msg", "消息测试成功");
		m.put("time", new Date().toString());
		try{
			logger.debug(gson.toJson(m));
			PrintWriter out = response.getWriter();
			out.write(gson.toJson(m));
			out.close();
		}catch(IOException e){
			logger.error(e.getMessage());
		}
	}
	
	public void t2() {
		response = ServletActionContext.getResponse();
		Gson gson = new Gson();
		List<UserEntity> list = new ArrayList<UserEntity>();
		list.add(new UserEntity("yxs",123,true));
		list.add(new UserEntity("张三",456,false));
		list.add(new UserEntity("zh{ang}san",123,true));
		list.add(new UserEntity("\"李四\"",456,false));
		list.add(new UserEntity("{yxs:good}",123,true));
		list.add(new UserEntity("李\"四\"",456,false));

		try{
			logger.debug(gson.toJson(list));
			PrintWriter out = response.getWriter();
			out.write(gson.toJson(list));
			out.close();
		}catch(IOException e){
			logger.error(e.getMessage());
		}
	}
	
	public void add() throws IOException{
		HttpServletRequest req = ServletActionContext.getRequest();
		Gson gson = new Gson();
		logger.debug("user = [{}]",req.getParameter("user"));
		UserEntity user = gson.fromJson(req.getParameter("user"), UserEntity.class) ;
		UserDao userDao = new UserDao();
//		UserEntity user = new UserEntity("五王一",234,false);
		logger.debug(user.toString());
		userDao.add(user);
		HttpServletResponse rsp = ServletActionContext.getResponse();
		PrintWriter out = rsp.getWriter();
		Map<String,String> m = new LinkedHashMap<String,String>();
		m.put("code", "0000");
		m.put("msg", "用户添加成功");
		m.put("time", new Date().toString());

		out.write(gson.toJson(m));
		out.close();
	}
	

}

