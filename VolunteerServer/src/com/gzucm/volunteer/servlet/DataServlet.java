package com.gzucm.volunteer.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
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
import com.gzucm.volunteer.service.IUserService;
import com.gzucm.volunteer.util.CharacterUtils;
import com.gzucm.volunteer.util.CommonUtil;
import com.gzucm.volunteer.vo.Data;

@WebServlet("/DataServlet")
public class DataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String TAG = "DataServlet";
	private Data userData = null;

	IUserService userService = (IUserService) ServiceProvider.getService(IUserService.SERVICE_NAME);

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Map<String, Object> outMap = new HashMap<String, Object>();
		outMap.put(Constant.RESPONSE, TAG);
		List<String> zylx = new ArrayList<String>();
		zylx.add("便民");
		zylx.add("娱乐");
		zylx.add("公益");
		outMap.put("type", 1);
		outMap.put("zylx", zylx);
		CommonUtil.renderJson(response, outMap);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
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
				Data data = new Data();
				data.setUserID(user.getUserID());
				if (user.getUserName()==null) {
					outMap.put("type", 6);
				}else {
					data.setName(user.getUserName());
					data.setSex(user.getSex());
					data.setPhone(user.getTelPhone());
					data.setEmail(user.getEmail());
					data.setAddress(user.getAddress());
					data.setVolunteerType(user.getVolunteerType());
					data.setContent(user.getExperience());
					data.setImageUri(user.getPortrait());
					outMap.put("type", 5);
				}
				outMap.put("Data", data);  //我的资料数据查询成功
				
			}else {
				outMap.put("type", 4);//   用户资料不存在
			}
			CommonUtil.renderJson(response, outMap);
		}
	}

	@SuppressWarnings({ "rawtypes", "deprecation" })
	private void upload(HttpServletRequest request, HttpServletResponse response) {
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
					if ("data".equals(paramName)) {
						paramValue = new String(
								paramValue.getBytes("ISO8859-1"), "UTF-8");
						userData = new Gson().fromJson(paramValue, Data.class);
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
					userData.setImageUri(fileName);
				}
			}
			if (saveData(request)) { // 修改成功
				Map<String, Object> outMap = new HashMap<String, Object>();
				outMap.put(Constant.RESPONSE, TAG);
				outMap.put("type", 2);
				outMap.put("img", userData.getImageUri());
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
	private boolean saveData(HttpServletRequest request) {
		User user = userService.findUserById(userData.getUserID());
		if (user != null) {
			String path = user.getPortrait();
			user.setUserName(userData.getName());
			user.setSex(userData.getSex());
			user.setAddress(userData.getAddress());
			user.setPortrait(userData.getImageUri());
			user.setTelPhone(userData.getPhone());
			user.setEmail(userData.getEmail());
			user.setExperience(userData.getContent());
			user.setVolunteerType(userData.getVolunteerType());
			userService.update(user);
			File f = new File(request.getRealPath(Constant.UPLOAD_IMG + path));
			if (f.exists()) {
				f.delete();
			}
			return true;
		}
		return false;
	}
}
