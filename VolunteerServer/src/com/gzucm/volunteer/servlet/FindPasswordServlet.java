package com.gzucm.volunteer.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.gzucm.volunteer.config.Constant;
import com.gzucm.volunteer.container.ServiceProvider;
import com.gzucm.volunteer.domain.User;
import com.gzucm.volunteer.service.IUserService;
import com.gzucm.volunteer.util.CommonUtil;
import com.gzucm.volunteer.util.SmsVerifyKit;

/**
 * 忘记密码
 * @author 万允山
 */
@WebServlet(description = "找回密码的处理类", urlPatterns = { "/FindPasswordServlet" })
public class FindPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String TAG = "FindPasswordServlet";
	IUserService userService = (IUserService) ServiceProvider.getService(IUserService.SERVICE_NAME);  
	  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * 1、验证验证码是否正确
	 * 2、查询该手机号是否被存在
	 * 2、修改密码
	 */	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String telephone = request.getParameter("telephone");
		String password = request.getParameter("password");
		String verificationCode = request.getParameter("verificationCode");
		try {
			String result = new SmsVerifyKit(telephone, verificationCode).go();
		    JSONObject jsonObject = JSONObject.fromObject(result);
		    if (jsonObject == null) {
		    	System.out.println("mod服务器返回结果为空");
				return ;
			}
		    int status = jsonObject.getInt("status");
			System.out.println(status);
			int type = -1;
			switch (status) {
			case 200:    //发送短信成功
				User user = userService.findUserByTelephone(telephone);
				if (validateUser(user, response)) {
					modifyPwd(user, password, request, response);
				};			
				break;
			default:
				type = status;
				break;
			}
			Map<String, Object> outMap = new HashMap<String, Object>();
			outMap.put(Constant.RESPONSE, TAG);
			outMap.put("type", type); //代表注册成功
			CommonUtil.renderJson(response, outMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 验证该手机号是否注册过
	 * @param user
	 * @param response
	 * @return true  表示未被注册
	 */
	public boolean validateUser(User user,HttpServletResponse response){
		
		if (user == null ) {
			System.out.println("该用户未注册");
			Map<String, Object> outMap = new HashMap<String, Object>();
			outMap.put(Constant.RESPONSE, TAG);
			outMap.put("type", 1); //代表该手机号没注册过
			CommonUtil.renderJson(response, outMap);
			return false;
		}
		return true;
	};
	
	/**
	 * 进行修改密码操作
	 * @param user
	 * @param password
	 * @param request
	 * @param response
	 */
	public void modifyPwd(User user,String password,HttpServletRequest request,HttpServletResponse response){
		
		user.setPassword(password);
		userService.update(user);
		request.getSession().setAttribute("user", user);
		Map<String, Object> outMap = new HashMap<String, Object>();
		outMap.put(Constant.RESPONSE, TAG);
		outMap.put("type", 2); //代表修改密码成功
		CommonUtil.renderJson(response, outMap);
	}
}
