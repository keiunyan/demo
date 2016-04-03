package com.yxs.demo.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return INPUT;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 2366717493323756370L;

	public BaseAction(){
		request  = null;
		response = null;
	}
	
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	
	protected static Logger logger = LogManager.getLogger(BaseAction.class.getName());
}
