/**
 * 
 */
package com.yxs.demo.action;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.struts2.ServletActionContext;

import com.yxs.demo.dao.UserDao;
import com.yxs.demo.entity.UserEntity;

/**
 * @author YXS
 *
 */
public class UserAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5877580421469262301L;
	
	public String loginValidate() {
		request = ServletActionContext.getRequest();
//		String userid = request.getParameter("userid");
//		String password = request.getParameter("password");
		
		if("600743".equals(request.getSession().getAttribute("uesrname"))){
			return SUCCESS;
		}
			
		
		logger.debug("  userid = [{}]",userId);
		logger.debug("password = [{}]","********");
		if("600743".equals(userId)){
			request.getSession().setAttribute("uesrname", userId);
			return SUCCESS;
		}else{
			return "fail";
		}	
	}
	
	public String logout(){
		request = ServletActionContext.getRequest();
		request.getSession().setAttribute("uesrname", null);
		return INPUT;
	}
	
	/**
	 * 验证用户名是否存在
	 */
	public void vu() {
		response = ServletActionContext.getResponse();
		//response.setCharacterEncoding("UTF-8");
		logger.debug("  userid = [{}]",userId);
		try{
			PrintWriter out = response.getWriter();

			if(!"600743".equals(userId)){
				out.write("{\"code\":\"1001\",\"msg\":\"用户名不存在\"}");
			}else{
				out.write("{\"code\":\"0000\",\"msg\":\"\"}");
			}
			out.close();
		}catch(IOException e){
			logger.error(e.getMessage());
		}
	}
	
	/**
	 * 验证用户登录
	 */
	public void vl(){
		
	}
	
	public void chPwd(){
		response = ServletActionContext.getResponse();
		//response.setCharacterEncoding("UTF-8");
		logger.debug("   oldPwd = [{}]",oldPwd);
		logger.debug("   newPwd = [{}]",newPwd);
		logger.debug("  rNewPwd = [{}]",rNewPwd);
		
		try{
			PrintWriter out = response.getWriter();
			if(!"111111".equals(oldPwd)){
				out.write("{\"statusCode\":\"300\",\"message\":\"旧密码不正确\"}");
				out.close();
			}else if(!newPwd.equals(rNewPwd)){
				out.write("{\"statusCode\":\"300\",\"message\":\"两次输入密码不相同\"}");
				out.close();	
			}else{
				out.write("{\"statusCode\":\"200\",\"message\":\"密码修改成功\",\"callbackType\":\"closeCurrent\"}");
				out.close();

			}
			
		}catch(IOException e){
			logger.error(e.getMessage());
		}

	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

	public void setRNewPwd(String rNewPwd) {
		this.rNewPwd = rNewPwd;
	}
	
	private String userId   = "";
	private String password = "";
	
	private String oldPwd   = "";
	private String newPwd   = "";
	private String rNewPwd  = "";
	
	//private static Logger logger = LogManager.getLogger(UserAction.class.getName());

}
