package com.neusoft.tools;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileTools {
	
	public static String saveimg(MultipartFile upload,HttpServletRequest request){
		String url=null;
		//1.文件上传
		//1.1 重命名 时间戳+文件名/UUID+文件名  时间戳:当前系统时间距离1970年时间原点总的毫秒数
		String OriginalFilename=upload.getOriginalFilename().trim();  //去掉字符串首尾的空格
		String type="";
		int dot = OriginalFilename.lastIndexOf('.'); //.jpg 防止.被替换成ZH
		System.out.println("dot="+dot);
		if ((dot >-1) && (dot < (OriginalFilename.length()))) { 
			type=OriginalFilename.substring(dot + 1); 
			OriginalFilename = OriginalFilename.substring(0, dot); 
        }
		OriginalFilename=OriginalFilename.replaceAll("[^x00-xff]", "ZH");
		String filename=System.currentTimeMillis()+OriginalFilename+"."+type;
		//1.2 文件传到当前工程的同级目录下
		String path=request.getServletContext().getRealPath("/");
		File f =new File(path);
		String ppath=f.getParent();
		//1.3 临时文件拷贝到目标地址上 '/'任何操作系统都认识
		File dest=new File(ppath+"/upload",filename);
		try {
			upload.transferTo(dest);
			url="../upload/"+filename;
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return url;
	}
	
	public static String addHeader(Object obj,int count) {
		Gson gson = new Gson();
		String str = " {\"code\":0,\"msg\":\"\",\"count\":"+count+",\"data\":"+(gson.toJson(obj))+"}";
		System.out.println("str:"+str);
		return str;
	}
	
}