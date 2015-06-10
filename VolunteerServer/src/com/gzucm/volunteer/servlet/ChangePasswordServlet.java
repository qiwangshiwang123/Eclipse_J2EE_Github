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
/**
 * 修改密码
 * @author 万允山
 */
@WebServlet(description = "修改密码", urlPatterns = { "/ChangePasswordServlet" })
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String TAG = "ChangePasswordServlet";
	IUserService userService = (IUserService) ServiceProvider.getService(IUserService.SERVICE_NAME);  
	    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * 1.验证密码是否正确
	 * 2.修改密码
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String oldpassword = request.getParameter("oldpassword");
		String password = request.getParameter("password");
		User user = userService.findUserById(userId);
		if (user != null) {
			Map<String, Object> outMap = new HashMap<String, Object>();
			outMap.put(Constant.RESPONSE, TAG);
			if (validatePassword(user,oldpassword)) {
				user.setPassword(password);
				userService.update(user);
				request.getSession().setAttribute("user", user);
				System.out.println("修改密码成功");
				outMap.put("type", 1); //代表密码修改成功
			}else {
				System.out.println("密码错误");
				outMap.put("type", 2);  //代表密码错误
			}
			CommonUtil.renderJson(response, outMap);
			return ;
		}
	}
	
	/**
	 * 验证旧密码是否正确
	 * @param user
	 * @param password 旧密码
	 * @return true 密码正确
	 */
	public boolean validatePassword(User user,String password){
		String nowpassword = user.getPassword();
		if (nowpassword.equals(password) || nowpassword == password) {
			return true;
		}
		return false;
	}

}
