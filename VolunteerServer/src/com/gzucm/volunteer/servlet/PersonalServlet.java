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
 * 个人中心
 *
 */
@WebServlet("/PersonalServlet")
public class PersonalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String TAG = "PersonalServlet";
	IUserService userService = (IUserService) ServiceProvider.getService(IUserService.SERVICE_NAME);  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println(TAG+"进入");
		String userID = request.getParameter("userID");
		User user = userService.findUserById(userID);
		Map<String, Object> outMap = new HashMap<String, Object>();
		outMap.put(Constant.RESPONSE, TAG);
		if (user != null) {
			if (user.getUserName()==null) {
				outMap.put("type", 1);
			}else {
				outMap.put("type", 2);
			}
			outMap.put("user", user);  //我的资料数据查询成功
		}else {
			outMap.put("type", 3);//   用户资料不存在
		}
		CommonUtil.renderJson(response, outMap);
	}

}
