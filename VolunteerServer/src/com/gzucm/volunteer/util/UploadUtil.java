package com.gzucm.volunteer.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.google.gson.Gson;
import com.gzucm.volunteer.config.Constant;
import com.gzucm.volunteer.vo.Resume;

public class UploadUtil {
	Map<String,Object> params;
	public Map<String, Object> getParams() {
		return params;
	}
	public void setParams(Map<String, Object> params) {
		this.params = params;
	}
	HttpServletRequest request;
	public UploadUtil() {
		super();
		params=new HashMap<String, Object>();
		// TODO Auto-generated constructor stub
	}
	public UploadUtil(HttpServletRequest request) {
		super();
		params=new HashMap<String, Object>();
		this.request=request;
		// TODO Auto-generated constructor stub
	}
	
	public Map<String,Object> upload(){
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		List items = null;
		try {
			items=upload.parseRequest(request);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FileItem item=null;
		if(items!=null){}
		Iterator iter = items.iterator();
		while (iter.hasNext()) {
			item= (FileItem) iter.next();
			if (item.isFormField()) {
				// 普通文本信息处理
				String paramName = item.getFieldName();
				String paramValue = item.getString();
				try {
					paramValue = new String(paramValue.getBytes("ISO-8859-1"), "UTF-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				params.put(paramName, paramValue);
			} 
			else{
				// 上传文件信息处理
				String fileName = item.getName();
				if(fileName.indexOf(".")!=-1){
					String extension = fileName.substring(fileName.indexOf("."));
					fileName = CharacterUtils.getRandomString2(20) + extension;
					params.put("fileName", fileName);
				}
				byte[] data = item.get();
				@SuppressWarnings("deprecation")
				String filePath = request.getRealPath(Constant.UPLOAD_ACTIVITY_IMG
						+ fileName);
				FileOutputStream fos;
				try {
					fos = new FileOutputStream(filePath);
					fos.write(data);
					fos.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		return params;
	}
	
	
	
}
