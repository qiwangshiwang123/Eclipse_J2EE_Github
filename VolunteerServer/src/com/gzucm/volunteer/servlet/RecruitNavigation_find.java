package com.gzucm.volunteer.servlet;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;

import com.gzucm.volunteer.config.Constant;
import com.gzucm.volunteer.container.ServiceProvider;
import com.gzucm.volunteer.service.IRecruitService;
import com.gzucm.volunteer.service.IUserService;
import com.gzucm.volunteer.util.DateUtil;
import com.gzucm.volunteer.util.CommonUtil;
import com.gzucm.volunteer.util.PageInfo;
import com.gzucm.volunteer.vo.Enlist;
import com.gzucm.volunteer.vo.RecruitDetailInfo;

/**
 * Servlet implementation class RecruitServlet
 */
@WebServlet(description = "招募导航按分类查询", urlPatterns = { "/RecruitNavigation_find" })
public class RecruitNavigation_find extends HttpServlet {
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
		PageInfo pageInfo = new PageInfo(request);
		String activityType =  URLDecoder.decode(request.getParameter("activityType"));
		String timeBucket = URLDecoder.decode( request.getParameter("timeBucket"));
		System.out.println("活动类型："+activityType);
		Map<String,String> condition=new HashMap<String,String>();
		if(!activityType.equalsIgnoreCase("")){
			condition.put("o.activityType", activityType);
		}		
		List<Enlist> enlistList=new ArrayList<Enlist>();
		if(!timeBucket.equalsIgnoreCase("")){
			enlistList = RecruitService
				.findWithPage(condition, timeBucket, pageInfo);
		}else{
			enlistList = RecruitService
				.findWithPage(condition, pageInfo);
		}
		Map<String, Object> outMap = new HashMap<String, Object>();
		outMap.put(Constant.RESPONSE, "RecruitNavigation_find");
		if(enlistList==null){
			Enlist enlist=new Enlist();
			enlist.setReturnType("-1");
			enlistList.add(enlist);
			System.out.println("暂没招募信息");
		}
		if(pageInfo.isNoMore()){
			enlistList.get(0).setReturnType("0");
			System.out.println("亲，到底了");
		}else{
			enlistList.get(0).setReturnType("1");
			System.out.println("加载成功");	
		}			
		outMap.put("enlist_list", enlistList);
		CommonUtil.renderJson(response, outMap);
	}

}
