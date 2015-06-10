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
@WebServlet(description = "招募导航_我的申请", urlPatterns = { "/PersonalCenter_myapply" })
public class PersonalCenter_myapply extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IRecruitService RecruitService = (IRecruitService) ServiceProvider.getService(IRecruitService.SERVICE_NAME); 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取从客户端传来的参数
		String userID=request.getParameter("userID");
		PageInfo pageInfo = new PageInfo(request);
		List<Enlist> enlistList=new ArrayList<Enlist>();
		Map<String, String> condition=new HashMap<String, String>();
		condition.put("aa.userID", userID);
		enlistList = RecruitService
				.findMyApply(condition, pageInfo);
		Map<String, Object> outMap = new HashMap<String, Object>();
		outMap.put(Constant.RESPONSE, "PersonalCenter_myapply");
		if(enlistList==null){
			enlistList=new ArrayList<Enlist>();
			Enlist enlist=new Enlist();
			enlist.setReturnType("-1");
			enlistList.add(enlist);
			System.out.println("暂没招募信息");
		}
		else if(pageInfo.isNoMore()){
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
