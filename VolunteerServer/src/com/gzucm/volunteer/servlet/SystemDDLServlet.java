package com.gzucm.volunteer.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gzucm.volunteer.container.ServiceProvider;
import com.gzucm.volunteer.domain.SystemDDL;
import com.gzucm.volunteer.service.ISystemDDLService;
import com.gzucm.volunteer.util.CharacterUtils;

@WebServlet(description = "数据字典操作", urlPatterns = { "/SystemDDLServlet" })
public class SystemDDLServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private String TAG = "SystemDDLServlet";
	ISystemDDLService systemDDLService = (ISystemDDLService) ServiceProvider.getService(ISystemDDLService.SERVICE_NAME);
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) {
		save();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) {

	}
	
	public void save(){
		SystemDDL systemDDL = new SystemDDL();
		systemDDL.setKeyword("服务意向");
		systemDDL.setDdlCode(CharacterUtils.getRandomString2(4));
		systemDDL.setDdlName("敬老");
		systemDDLService.save(systemDDL);
	}
}
