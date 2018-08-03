package com.neusoft.control;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.neusoft.po.ReturnUploadImage;
import com.neusoft.tools.FileTools;

 
@Controller  
public class UeditorController {  

	@RequestMapping(value="/test/upload",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String uploadImage(HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException{
		response.setContentType("text/html;charset=UTF-8");
		ReturnUploadImage rui = null;//这个是UEditor需要的返回值内容，UEditor要的返回值需要封装成Json格式
		// 转型为MultipartHttpRequest：
		MultipartHttpServletRequest multipartRequest=(MultipartHttpServletRequest) request;
		// 获得文件：
		MultipartFile file =multipartRequest.getFile("upfile"); //UEditor传到后台的是这个upfile，其他的文件上传，应该也差不多是这个，还没去研究，断点一下就知道了
		String url=FileTools.saveimg(file,request);
		rui = new ReturnUploadImage();
		rui.setState("SUCCESS");
		rui.setTitle(url);//这里需要设置文件名称如：xxx.jpg
		rui.setOriginal(url);//这里需要设置文件名称如：xxx.jpg
		rui.setUrl(url);//这里是设置返回给UEditor的图片地址
		String result = JSON.toJSONString(rui);//这边就是为了返回给UEditor做的格式转换
		response.getWriter().write(result);
		return result;
		
		/*// 写入文件
		UUID uuid =UUID.randomUUID();   
        //String str = uuid.toString();
		File imageFile =new File("/"+uuid.toString()+".jpg");
		file.transferTo(imageFile);
		//现在获取了File接下来要上传到OSS上
		if(imageFile!=null){
			rui = new ReturnUploadImage();
			rui.setTitle(imageFile.getName());//这里需要设置文件名称如：xxx.jpg
			rui.setOriginal(imageFile.getName());//这里需要设置文件名称如：xxx.jpg
			// 判断文件是否为图片文件
			//String r =ImageUtils.fileDetermine(imageFile, 3 * 1024);
			//if (!StringUtils.isNotEmpty(r)) {
				// 上传文件(这里文件类型，要根据实际上传的类型去做，暂时是直接设置了.jpg，并且先保存到磁盘，这样对磁盘比较伤，每次上传都要先保存到磁盘，然后再删除)
				//ResultInfo resultInfo = OSSObjTools.uploadObject(imageFile,"subWebPublicNotice");//这里是自己封装的OSS，上传到OSS上面
				// 判断如果返回结果不为空并且MD5返回值比较结果正确，就设置文件路径保存到数据库
				if (resultInfo != null && resultInfo.geteTag().equalsIgnoreCase(MD5Tools.file2MD5(imageFile))) {
					rui.setState("SUCCESS");//这里上传成功的话一定要设置大写的 SUCCESS，失败还没测试，猜应该是FAIL，回头再去官网找找
					rui.setUrl(CommonTools.catchUrlPath(PubParam.BUCKET_NAME,PubParam.Mark_ShenZhen) +resultInfo.getFilePath());//这里是设置返回给UEditor的图片地址
				}
			//}
			// 判断临时存放的文件是否存在
			if (imageFile.exists()) {
			// 删除临时存放的文件
			imageFile.delete();
			}	
		}*/
	}
}  
