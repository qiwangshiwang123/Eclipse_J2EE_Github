package com.gzucm.volunteer.servicecenter.servlet;

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
import com.gzucm.volunteer.domain.Activity;
import com.gzucm.volunteer.service.IRecruitService;
import com.gzucm.volunteer.util.AddressUtil;
import com.gzucm.volunteer.util.CommonUtil;
import com.gzucm.volunteer.util.DateUtil;
import com.gzucm.volunteer.util.PageInfo;
import com.gzucm.volunteer.util.UploadUtil;
import com.gzucm.volunteer.vo.Enlist;
import com.gzucm.volunteer.vo.RecruitDetailInfo;

/**
 * Servlet implementation class RecruitServlet
 */
@WebServlet(description = "招募", urlPatterns = { "/Recruit_publish" })
public class Recruit_publish extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IRecruitService RecruitService = (IRecruitService) ServiceProvider.getService(IRecruitService.SERVICE_NAME); 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取从客户端传来的参数
		UploadUtil uploadUtil=new UploadUtil(request);
		Map<String,Object> params=uploadUtil.upload();
		Activity activity=new Activity();
		if(params!=null){
			activity=convertToActivity(params);
			RecruitService.publish(activity);
		}
		response.sendRedirect("/VolunteerServer/index.jsp");
	}
    private Activity convertToActivity(Map<String,Object> params){
    	Activity activity =new Activity();
    	activity.setTitle((String)params.get("title"));
    	activity.setActivityType((String)params.get("activityType"));
    	activity.setRecruitPeopleNum(Integer.parseInt((String) params.get("recruitPeopleNum")));
    	activity.setStartTime(DateUtil.StringToDate((String)params.get("startTime")));
    	activity.setEndTime(DateUtil.StringToDate((String)params.get("endTime")));
    	String addressparams[]={(String)params.get("province"),(String)params.get("city"),(String)params.get("area"),(String)params.get("detailAddress")};
    	String activityAddress=AddressUtil.PackString(addressparams);
    	activity.setActivityAddress(activityAddress);
    	activity.setActivityContactName((String)params.get("activityContactName"));
    	activity.setActivityTelPhone((String)params.get("activityTelPhone"));
    	activity.setActivityEmail((String)params.get("activityEmail")+(String)params.get("emailSuffix"));
    	activity.setActivityIntroduce((String)params.get("activityIntroduce"));
    	activity.setImgPath((String)params.get("fileName"));
    	return activity;
    }
}
