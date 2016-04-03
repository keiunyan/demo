package com.yxs.demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CharacterEncodingFilter implements Filter {

	private String encoding = null;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		encoding = null;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		if(null != encoding){
			//logger.info("encoding = [{}]",encoding);
			request.setCharacterEncoding(encoding);
			response.setCharacterEncoding(encoding);
			
		}
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		if (encoding == null) {
			encoding = config.getInitParameter("encoding");
		}
	}
	
	private static Logger logger = LogManager.getLogger(CharacterEncodingFilter.class.getName());

}
