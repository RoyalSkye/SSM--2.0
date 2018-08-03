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
		ReturnUploadImage rui = null;//�����UEditor��Ҫ�ķ���ֵ���ݣ�UEditorҪ�ķ���ֵ��Ҫ��װ��Json��ʽ
		// ת��ΪMultipartHttpRequest��
		MultipartHttpServletRequest multipartRequest=(MultipartHttpServletRequest) request;
		// ����ļ���
		MultipartFile file =multipartRequest.getFile("upfile"); //UEditor������̨�������upfile���������ļ��ϴ���Ӧ��Ҳ������������ûȥ�о����ϵ�һ�¾�֪����
		String url=FileTools.saveimg(file,request);
		rui = new ReturnUploadImage();
		rui.setState("SUCCESS");
		rui.setTitle(url);//������Ҫ�����ļ������磺xxx.jpg
		rui.setOriginal(url);//������Ҫ�����ļ������磺xxx.jpg
		rui.setUrl(url);//���������÷��ظ�UEditor��ͼƬ��ַ
		String result = JSON.toJSONString(rui);//��߾���Ϊ�˷��ظ�UEditor���ĸ�ʽת��
		response.getWriter().write(result);
		return result;
		
		/*// д���ļ�
		UUID uuid =UUID.randomUUID();   
        //String str = uuid.toString();
		File imageFile =new File("/"+uuid.toString()+".jpg");
		file.transferTo(imageFile);
		//���ڻ�ȡ��File������Ҫ�ϴ���OSS��
		if(imageFile!=null){
			rui = new ReturnUploadImage();
			rui.setTitle(imageFile.getName());//������Ҫ�����ļ������磺xxx.jpg
			rui.setOriginal(imageFile.getName());//������Ҫ�����ļ������磺xxx.jpg
			// �ж��ļ��Ƿ�ΪͼƬ�ļ�
			//String r =ImageUtils.fileDetermine(imageFile, 3 * 1024);
			//if (!StringUtils.isNotEmpty(r)) {
				// �ϴ��ļ�(�����ļ����ͣ�Ҫ����ʵ���ϴ�������ȥ������ʱ��ֱ��������.jpg�������ȱ��浽���̣������Դ��̱Ƚ��ˣ�ÿ���ϴ���Ҫ�ȱ��浽���̣�Ȼ����ɾ��)
				//ResultInfo resultInfo = OSSObjTools.uploadObject(imageFile,"subWebPublicNotice");//�������Լ���װ��OSS���ϴ���OSS����
				// �ж�������ؽ����Ϊ�ղ���MD5����ֵ�ȽϽ����ȷ���������ļ�·�����浽���ݿ�
				if (resultInfo != null && resultInfo.geteTag().equalsIgnoreCase(MD5Tools.file2MD5(imageFile))) {
					rui.setState("SUCCESS");//�����ϴ��ɹ��Ļ�һ��Ҫ���ô�д�� SUCCESS��ʧ�ܻ�û���ԣ���Ӧ����FAIL����ͷ��ȥ��������
					rui.setUrl(CommonTools.catchUrlPath(PubParam.BUCKET_NAME,PubParam.Mark_ShenZhen) +resultInfo.getFilePath());//���������÷��ظ�UEditor��ͼƬ��ַ
				}
			//}
			// �ж���ʱ��ŵ��ļ��Ƿ����
			if (imageFile.exists()) {
			// ɾ����ʱ��ŵ��ļ�
			imageFile.delete();
			}	
		}*/
	}
}  
