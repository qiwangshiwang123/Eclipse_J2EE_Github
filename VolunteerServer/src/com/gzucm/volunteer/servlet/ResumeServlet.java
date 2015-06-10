package com.gzucm.volunteer.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.google.gson.Gson;
import com.gzucm.volunteer.config.Constant;
import com.gzucm.volunteer.container.ServiceProvider;
import com.gzucm.volunteer.domain.User;
import com.gzucm.volunteer.service.ISystemDDLService;
import com.gzucm.volunteer.service.IUserService;
import com.gzucm.volunteer.util.AddressUtil;
import com.gzucm.volunteer.util.CharacterUtils;
import com.gzucm.volunteer.util.CommonUtil;
import com.gzucm.volunteer.vo.Resume;

@WebServlet(description = "我的简历处理类", urlPatterns = { "/ResumeServlet" })
public class ResumeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String TAG = "ResumeServlet";
	private Resume userResume = null;
	
	ISystemDDLService systemDDLService = (ISystemDDLService) ServiceProvider.getService(ISystemDDLService.SERVICE_NAME);
	IUserService userService = (IUserService) ServiceProvider.getService(IUserService.SERVICE_NAME);

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> list = systemDDLService.findBykeyword("服务意向");
		Map<String, Object> outMap = new HashMap<String, Object>();
		outMap.put(Constant.RESPONSE, TAG);
		outMap.put("type", 1);
		outMap.put("yx", list);
		CommonUtil.renderJson(response, outMap);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {
			upload(request, response);
		}else {
			String userID = request.getParameter("userID");
			User user = userService.findUserById(userID);
			Map<String, Object> outMap = new HashMap<String, Object>();
			outMap.put(Constant.RESPONSE, TAG);
			if (user != null) {
				Resume resume = new Resume();
				resume.setUserID(user.getUserID());
				if (user.getUserName()==null) {
					outMap.put("type", 4);
				}else {
					String[] params = AddressUtil.UnpackString(user.getAddress());
					resume.setName(user.getUserName());
					resume.setSex(user.getSex());
					resume.setCantonese(user.getIsCantonese());
					resume.setExperience(user.getExperience());
					resume.setIntention(user.getVolunteerType());
					resume.setTelephone(user.getTelPhone());
					resume.setEmail(user.getEmail());
					resume.setProvince(params[0]);
					resume.setCity(params[1]);
					resume.setArea(params[2]);
					resume.setCollege(params[3]);
					resume.setImageUri(user.getPortrait());
					
					outMap.put("type", 5);
				}
				outMap.put("Resume", resume);  //我的资料数据查询成功
			}else {
				outMap.put("type", 6);//   用户资料不存在
			}
			CommonUtil.renderJson(response, outMap);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "deprecation" })
	private void upload(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("dddddddd");
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List items = upload.parseRequest(request);
			Iterator iter = items.iterator();
			while (iter.hasNext()) {
				FileItem item = (FileItem) iter.next();
				if (item.isFormField()) {
					// 普通文本信息处理
					String paramName = item.getFieldName();
					String paramValue = item.getString();
					if ("resume".equals(paramName)) {
						paramValue = new String(
								paramValue.getBytes("ISO8859-1"), "UTF-8");
						userResume = new Gson().fromJson(paramValue, Resume.class);
					}
				} else {
					// 上传文件信息处理
					String fileName = item.getName();
					String extension = fileName
							.substring(fileName.indexOf("."));
					fileName = CharacterUtils.getRandomString2(20) + extension;
					byte[] data = item.get();
					String filePath = request.getRealPath(Constant.UPLOAD_IMG
							+ fileName);
					FileOutputStream fos = new FileOutputStream(filePath);
					fos.write(data);
					fos.close();
					userResume.setImageUri(fileName);
				}
			}
			if (saveResume(request)) { // 修改成功,返回图片名
				Map<String, Object> outMap = new HashMap<String, Object>();
				outMap.put(Constant.RESPONSE, TAG);
				outMap.put("type", 2);
				outMap.put("img", userResume.getImageUri());
				CommonUtil.renderJson(response, outMap);
			} else { // 程序错误，该id的用户不存在
				Map<String, Object> outMap = new HashMap<String, Object>();
				outMap.put(Constant.RESPONSE, TAG);
				outMap.put("type", 3);
				CommonUtil.renderJson(response, outMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("deprecation")
	private boolean saveResume(HttpServletRequest request) {
		User user = userService.findUserById(userResume.getUserID());
		if (user != null) {
			String[] params = {userResume.getProvince(),userResume.getCity(),userResume.getArea(),userResume.getCollege()};
			String address = AddressUtil.PackString(params);
			String path = user.getPortrait();
			user.setPortrait(userResume.getImageUri());
			user.setUserName(userResume.getName());
			user.setSex(userResume.getSex());
			user.setIsCantonese(userResume.getCantonese());
			user.setExperience(userResume.getExperience());
			user.setVolunteerType(userResume.getIntention());
			user.setTelPhone(userResume.getTelephone());
			user.setEmail(userResume.getEmail());
			user.setAddress(address);
			userService.update(user);
			File f = new File(request.getRealPath(Constant.UPLOAD_IMG + path));
			if (f.exists()) {//删除之前的头像
				f.delete();
			}
			return true;
		}
		return false;
	}

}
