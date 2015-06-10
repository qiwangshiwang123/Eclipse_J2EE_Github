package com.gzucm.volunteer.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gzucm.volunteer.container.ServiceProvider;
import com.gzucm.volunteer.domain.UserInfo;
import com.gzucm.volunteer.service.ITestService;
import com.gzucm.volunteer.util.CommonUtil;

/**
 * 测试
 * @author 万允山
 *
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String RESPONSE = "response";
	
	ITestService testService = (ITestService) ServiceProvider.getService(ITestService.SERVICE_NAME);
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("deget");
		request.getRequestDispatcher("/success.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("dopost");
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String userPwd = request.getParameter("password");
      /*  String user = request.getParameter("user");
        Gson gson = new Gson();
        User userinfo = gson.fromJson(user, User.class);*/
        System.out.println(username +"  "+userPwd);
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId("1");
        userInfo.setCustName(username);
        userInfo.setCustPwd(userPwd);
        userInfo.setCustLevel("1");
        userInfo.setUsersession("1111111");
        userInfo.setCustBonus("22222");
        
        Map<String, Object> outMap = new HashMap<String, Object>();
		outMap.put(RESPONSE, "login");
		outMap.put("userinfo", userInfo);
		CommonUtil.renderJson(response, outMap);
       
        
     //   String s = URLEncoder.encode(userInfo2,"UTF-8");
	}

}
