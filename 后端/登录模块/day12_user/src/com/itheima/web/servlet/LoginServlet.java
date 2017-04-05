package com.itheima.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dsna.util.images.ValidateCode;
import org.apache.commons.beanutils.BeanUtils;

import com.itheima.domain.User;
import com.itheima.exception.UsersException;
import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		//登录验证码
//		ValidateCode vc = new ValidateCode(110, 25, 4, 9);
//		//向session中保存验证码
//		request.getSession().setAttribute("scode", vc.getCode());
//		vc.write(response.getOutputStream());
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html;charset=UTF-8");
		//验证验证码
		String code=request.getParameter("code");
		String scode=(String) request.getSession().getAttribute("scode");
		if(!code.equalsIgnoreCase(scode)){
			String error=new String("验证码有误无".getBytes(),"UTF-8");
			request.setAttribute("msg",error);
			request.setAttribute("username",null);
			request.setAttribute("password",null);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}


		User user = new User();

		
			try {
				BeanUtils.populate(user, request.getParameterMap());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			UserService us = new UserServiceImpl();
			
			User u;
			try {
				u = us.login(user);
			
				//�ַ�ת��
				if(u!=null){
					request.getSession().setAttribute("u", user);//�����¼�ɹ����Ͱ�user����ŵ�session���� ��
					request.getRequestDispatcher("/index.jsp").forward(request, response);
				}else{
					
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				}
			} catch (UsersException e) {
				e.printStackTrace();
			}
		
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
