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

@WebServlet(description = "处理注册模块", urlPatterns = { "/RegisterServlet" })
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IUserService userService = (IUserService) ServiceProvider.getService(IUserService.SERVICE_NAME);  
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("registerServlet doget");
	}

	/**
	 * 1、验证验证码是否正确
	 * 2、查询该手机号是否被注册过
	 * 2、保存注册信息
	 */	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("registerServlet dopost");
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
				if (validateUser(telephone, response)) {
					register(telephone, password, request, response);
				};			
				break;
			default:
				type = status;
				break;
			}
			Map<String, Object> outMap = new HashMap<String, Object>();
			outMap.put(Constant.RESPONSE, "RegisterServlet");
			outMap.put("type", type); //代表注册成功
			CommonUtil.renderJson(response, outMap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 验证该手机号是否注册过
	 * @param telephone
	 * @param response
	 * @return true  表示未被注册
	 */
	public boolean validateUser(String telephone,HttpServletResponse response){
		User user = userService.findUserByTelephone(telephone);
		if (user != null ) {
			System.out.println("该用户已经注册");
			Map<String, Object> outMap = new HashMap<String, Object>();
			outMap.put(Constant.RESPONSE, "RegisterServlet");
			outMap.put("type", 1); //代表该手机号已经被注册
			CommonUtil.renderJson(response, outMap);
			return false;
		}
		return true;
	};
	
	/**
	 * 进行注册操作
	 * @param telephone
	 * @param password
	 * @param request
	 * @param response
	 */
	public void register(String telephone,String password,HttpServletRequest request,HttpServletResponse response){
		
		User user = new User();
		user.setAccount(telephone);
		user.setPassword(password);
		user.setTelPhone(telephone);
		userService.save(user);
		request.getSession().setAttribute("user", user);
		Map<String, Object> outMap = new HashMap<String, Object>();
		outMap.put(Constant.RESPONSE, "RegisterServlet");
		outMap.put("userId", user.getUserID());
		outMap.put("type", 2); //代表注册成功
		CommonUtil.renderJson(response, outMap);
	}

}
