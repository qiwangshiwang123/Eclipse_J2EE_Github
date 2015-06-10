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
import com.gzucm.volunteer.util.CommonUtil;
import com.gzucm.volunteer.vo.Version;

/**
 * 处理版本请求的servlet
 * @author 万允山
 */
@WebServlet("/VersionServlet")
public class VersionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String TAG = "VersionServlet";
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("versionServlet doget");
		Version version = new Version(false, "1.1", false, Constant.APK_URL);
		Map<String, Object> outMap = new HashMap<String, Object>();
		outMap.put(Constant.RESPONSE, TAG);
		outMap.put("version", version);
		CommonUtil.renderJson(response, outMap);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
