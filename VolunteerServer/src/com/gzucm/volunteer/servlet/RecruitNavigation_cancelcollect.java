package com.gzucm.volunteer.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.gzucm.volunteer.config.Constant;
import com.gzucm.volunteer.container.ServiceProvider;
import com.gzucm.volunteer.service.IRecruitService;
import com.gzucm.volunteer.util.CommonUtil;
import com.gzucm.volunteer.util.PageInfo;
import com.gzucm.volunteer.vo.Enlist;
import com.gzucm.volunteer.vo.RecruitDetailInfo;

/**
 * Servlet implementation class RecruitServlet
 */
@WebServlet(description = "招募导航_取消收藏", urlPatterns = { "/RecruitNavigation_cancelcollect" })
public class RecruitNavigation_cancelcollect extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IRecruitService RecruitService = (IRecruitService) ServiceProvider.getService(IRecruitService.SERVICE_NAME); 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	
	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取从客户端传来的参数
		String userID=request.getParameter("userID");
		String activityID=request.getParameter("activityID");
		String message="";//报名状态
		message=RecruitService.cancelCollect(userID,activityID);
		Map<String, Object> outMap = new HashMap<String, Object>();
		outMap.put(Constant.RESPONSE, "RecruitNavigation_cancelcollect");
		outMap.put("message", message);
		CommonUtil.renderJson(response, outMap);
	}

}
