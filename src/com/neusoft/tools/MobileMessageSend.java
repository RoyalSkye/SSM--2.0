package com.neusoft.tools;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//短信发送工具类
public class MobileMessageSend {
	private static final String SERVER_URL="https://api.netease.im/sms/sendcode.action";//发送验证码的请求路径URL
    private static final String APP_KEY="c1841ce6b4a956c8adf15b3cdf82c70a";//网易云信分配的账号
    private static final String APP_SECRET="5d0c9f4f5211";//网易云信分配的密钥
    private static final String NONCE="123456";//随机数

    public static String sendMsg(String phone) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost post = new HttpPost(SERVER_URL);

        String curTime=String.valueOf((new Date().getTime()/1000L));
        String checkSum=CheckSumBuilder.getCheckSum(APP_SECRET,NONCE,curTime);

        //设置请求的header
        post.addHeader("AppKey",APP_KEY);
        post.addHeader("Nonce",NONCE);
        post.addHeader("CurTime",curTime);
        post.addHeader("CheckSum",checkSum);
        post.addHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");

        //设置请求参数
        List<NameValuePair> nameValuePairs =new ArrayList<>();
        nameValuePairs.add(new BasicNameValuePair("mobile",phone));
        //nameValuePairs.add(new BasicNameValuePair("templateid", "3913124"));

        post.setEntity(new UrlEncodedFormEntity(nameValuePairs,"utf-8"));

        //执行请求
        HttpResponse response=httpclient.execute(post);
        String responseEntity= EntityUtils.toString(response.getEntity(),"utf-8");

        //判断是否发送成功，发送成功返回true
        String code= JSON.parseObject(responseEntity).getString("code");
        if (code.equals("200")){
            return "success";
        }
        return "error";
    }
    
    /*
    public static void main(String[] args) {
        String mobileNumber = "13504019086";//接收验证码的手机号码
        try {
            String str = MobileMessageSend.sendMsg(mobileNumber);
            if("success".equals(str)){
                System.out.println("发送成功！");
            }else{
                System.out.println("发送失败！");
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }*/
    
}
