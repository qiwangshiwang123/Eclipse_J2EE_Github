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

import org.omg.CORBA.PRIVATE_MEMBER;

import com.gzucm.volunteer.config.Constant;
import com.gzucm.volunteer.container.ServiceProvider;
import com.gzucm.volunteer.domain.Information;
import com.gzucm.volunteer.service.IInformationService;
import com.gzucm.volunteer.util.CommonUtil;
import com.gzucm.volunteer.util.DateUtil;
import com.gzucm.volunteer.util.PageInfo;
import com.gzucm.volunteer.vo.Info;

/**
 * 资讯处理类
 */
@WebServlet("/InformationServlet")
public class InformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private String TAG = "InformationServlet";
    
	private IInformationService informationService = (IInformationService) ServiceProvider.getService(IInformationService.SERVICE_NAME);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		Map<String, Object> outMap = new HashMap<String, Object>();
		outMap.put(Constant.RESPONSE, TAG);
		if ("1".equals(type)) {
			PageInfo pageInfo = new PageInfo(request);
			List<Information> list = informationService.findWithPage(null,pageInfo);
			if(pageInfo.isNoMore()){
				outMap.put("list", "0");
			}
			else{	
			List<Info> infos = ConvertToInfo(list);
				outMap.put("list", infos);
			}
		}else {
			String infoID = request.getParameter("infoID");
			Information information = informationService.findById(infoID);
			HashMap<String, Object> map = getHashMap(information);
			outMap.put("job", map);
		}
	    CommonUtil.renderJson(response, outMap);
	}

	private HashMap<String, Object> getHashMap(Information information){
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("nid", information.getInformationID());
		hashMap.put("title", information.getTitle());
		
		HashMap<String, Object> hashMap2 = new HashMap<String, Object>();
		hashMap2.put("index", 0);
		hashMap2.put("type", "image");
		hashMap2.put("value", Constant.SERVICE+Constant.UPLOAD_IMG+information.getImgPath());
		list.add(hashMap2);
		
		hashMap2 = new HashMap<String, Object>();
		hashMap2.put("index", 1);
		hashMap2.put("type", "text");
		hashMap2.put("value", information.getDigest());
		list.add(hashMap2);
		
		hashMap.put("num", information.getNum());
		hashMap.put("body", list);
		return hashMap;
	}
	
	private List<Info> ConvertToInfo(List<Information> list){
		List<Info> infos = new ArrayList<Info>();
		for (Information information : list) {
			Info info = new Info();
			info.setInformationID(information.getInformationID());
			info.setTitle(information.getTitle());
			info.setNum(information.getNum());
			info.setImgPath(information.getImgPath());
			info.setDigest(information.getDigest());
			info.setUploadTime(DateUtil.getStringDate(information.getUploadTime()));
			infos.add(info);
		}
		return infos;
	}
}
