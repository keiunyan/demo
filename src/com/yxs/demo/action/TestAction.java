package com.yxs.demo.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;

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

}
