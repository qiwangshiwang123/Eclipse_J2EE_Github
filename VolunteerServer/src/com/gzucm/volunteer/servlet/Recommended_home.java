package com.gzucm.volunteer.servlet;

import java.io.IOException;
import java.net.URLDecoder;
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
import com.gzucm.volunteer.domain.Activity;
import com.gzucm.volunteer.service.IRecommendedService;
import com.gzucm.volunteer.service.IRecruitService;
import com.gzucm.volunteer.util.CommonUtil;
import com.gzucm.volunteer.util.DateUtil;
import com.gzucm.volunteer.util.PageInfo;
import com.gzucm.volunteer.vo.Enlist;
import com.gzucm.volunteer.vo.RecruitDetailInfo;

/**
 * Servlet implementation class RecruitServlet
 */
@WebServlet(description = "招募导航首页", urlPatterns = { "/Recommended_home" })
public class Recommended_home extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IRecommendedService RecommendedService = (IRecommendedService) ServiceProvider.getService(IRecommendedService.SERVICE_NAME); 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取从客户端传来的参数
		PageInfo pageInfo = new PageInfo(request);
		String userID=  (String) request.getParameter("userID");
		List<Enlist> enlistList=new ArrayList<Enlist>();
		enlistList=convertToEnlist(RecommendedService.recommended(pageInfo, userID),request);
		Map<String, Object> outMap = new HashMap<String, Object>();
		outMap.put(Constant.RESPONSE, "Recommended_home");
		if(enlistList==null){
			enlistList=new ArrayList<Enlist>();
			Enlist enlist=new Enlist();
			enlist.setReturnType("-1");
			enlistList.add(enlist);
			System.out.println("暂没推荐信息哦");
		}else if(pageInfo.isNoMore()){
			enlistList.get(0).setReturnType("0");
			System.out.println("亲，到底了");
		}else{
			enlistList.get(0).setReturnType("1");
			System.out.println("加载成功");	
		}			
		outMap.put("enlist_list", enlistList);
		CommonUtil.renderJson(response, outMap);
		
	}
	private List<Enlist> convertToEnlist(List<Activity> activityList,HttpServletRequest request){
		Enlist enlist=null;
		List<Enlist> enlistList=new ArrayList<Enlist>();
		if(activityList.size()==0){return null;}
		for(Activity activity:activityList){
			enlist=new Enlist();
			enlist.setActivityID(activity.getActivityID());
			enlist.setTitle(activity.getTitle());
			enlist.setActivityType(activity.getActivityType());
			enlist.setArea(activity.getActivityAddress());
			enlist.setReleaseTime(DateUtil.getStringDate(activity.getStartTime()));
			enlist.setViewAcount(activity.getViewAcount());
			enlist.setImgPath(Constant.SERVICE+Constant.UPLOAD_ACTIVITY_IMG+activity.getImgPath());
			//System.out.println("EnlistImgPath:"+enlist.getImgPath());
			enlist.setIsRecommended(activity.getIsRecommended());
			enlistList.add(enlist);
		}
		return enlistList;		
	}
}
