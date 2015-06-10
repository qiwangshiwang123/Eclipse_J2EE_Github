package com.gzucm.volunteer.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gzucm.volunteer.config.Constant;
import com.gzucm.volunteer.container.ServiceProvider;
import com.gzucm.volunteer.domain.User;
import com.gzucm.volunteer.service.IUserService;
import com.gzucm.volunteer.util.CommonUtil;

@WebServlet(description = "登陆处理类", urlPatterns = { "/LoginServlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IUserService userService = (IUserService) ServiceProvider.getService(IUserService.SERVICE_NAME);  
	  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginServlet dopost");
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String userPwd = request.getParameter("password");
		System.out.println(username +"  "+userPwd);
		User user = userService.findUserByAccount(username);
		Map<String, Object> outMap = new HashMap<String, Object>();
		outMap.put(Constant.RESPONSE, "LoginServlet");
		if (user == null) {
			System.out.println("该用户不存在");
			outMap.put("type", "1"); //代表该用户不存在
			CommonUtil.renderJson(response, outMap);
			return ;
		}
		
		if (!userPwd.equals(user.getPassword())) {
			System.out.println("密码错误");
			outMap.put("type", "2"); //代表密码错误
			CommonUtil.renderJson(response, outMap);
			return ;
		}
		
		System.out.println("登陆成功");
		request.getSession().setAttribute("userID", user.getUserID());
		outMap.put("userId", user.getUserID());
		outMap.put("type", "3"); //代表登陆成功
		CommonUtil.renderJson(response, outMap);
		
	}

}
