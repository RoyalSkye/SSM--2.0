package com.neusoft.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.neusoft.mapper.EnterpriseMapper;
import com.neusoft.po.Enterprise;
import com.neusoft.service.EnterpriseService;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class EnterpriseServiceBean implements EnterpriseService {

	@Autowired
	private EnterpriseMapper mapper;
	@Autowired
	private JedisPool jedisPool;

	@Override
	public Boolean updateEnterprise(Enterprise e) throws Exception{
		boolean isok=false;
		int result=mapper.updateEnterprise(e);
		//删除redis中的内容
		Jedis jedis=jedisPool.getResource();
		String enterprise="enterprise"+e.getQid();
		//System.out.println("enterprise="+enterprise);
		jedis.del(enterprise);
		//jedis.set("test", "test");
		jedis.close();
		if(result>0){
			isok=true;
		}else{
			isok=false;
		}
		return isok;
	}

	@Override
	public Enterprise findEnterpriseById(int qid) throws Exception {
		/*Jedis jedis1=jedisPool.getResource();
		String sessionid=jedis1.get("120CA8290352F329EE8FCD8ACE1DD03C");
		System.out.println("sessionid="+sessionid);
		jedis1.close();*/
		Gson g=new Gson();
		//key: enterprise{qid} value:[json]
		//Jedis jedis=RedisConnection.getJedis();
		Jedis jedis=jedisPool.getResource();
		String enterprise=jedis.get("enterprise"+qid);
		if(enterprise==null){  //redis中没有，从数据库中查，并写入redis
			Enterprise e=mapper.findEnterpriseById(qid);
			String jsonstr=g.toJson(e);
			//System.out.println("jsonstr="+jsonstr);
			jedis.set("enterprise"+qid, jsonstr);
			jedis.close();
			return e;
		}else{  //get data from redis
			//System.out.println("enterprise="+enterprise);
			//System.out.println("redis");
			Enterprise e=g.fromJson(enterprise, Enterprise.class);
			jedis.close();
			return e;
		}
		//return mapper.findEnterpriseById(qid);
	}

}
