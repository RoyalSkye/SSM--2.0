package com.neusoft.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.neusoft.mapper.FreelistenMapper;
import com.neusoft.po.Freelisten;
import com.neusoft.po.Lesson;
import com.neusoft.po.Swiper;
import com.neusoft.service.FreelistenService;
import com.neusoft.tools.Page;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class FreelistenServiceBean implements FreelistenService {

	@Autowired
	private FreelistenMapper mapper;
	@Autowired
	private JedisPool jedisPool;
	
	@Override
	public List<Freelisten> findAllFreelisten(Page page) throws Exception {
		return mapper.findAllFreelisten(page);
	}

	@Override
	public Freelisten findFreelistenById(int fid) throws Exception {
		return mapper.findFreelistenById(fid);
	}

	@Override
	public boolean deleteFreelistenById(int fid) throws Exception {
		boolean isok=false;
		int result=mapper.deleteFreelistenById(fid);
		if(result>0){
			Jedis jedis=jedisPool.getResource();
			jedis.del("freelisten");
			jedis.close();
			isok=true;
		}else{
			isok=false;
		}
		return isok;
	}

	@Override
	public boolean saveFreelisten(Freelisten freelisten) throws Exception {
		boolean isok=false;
		int result=mapper.saveFreelisten(freelisten);
		if(result>0){
			Jedis jedis=jedisPool.getResource();
			jedis.del("freelisten");
			jedis.close();
			isok=true;
		}else{
			isok=false;
		}
		return isok;
	}

	@Override
	public boolean updateFreelisten(Freelisten freelisten) throws Exception {
		boolean isok=false;
		int result=mapper.updateFreelisten(freelisten);
		if(result>0){
			Jedis jedis=jedisPool.getResource();
			jedis.del("freelisten");
			jedis.close();
			isok=true;
		}else{
			isok=false;
		}
		return isok;
	}

	@Override
	public List<Freelisten> findFreelistenByBid(Page page) throws Exception {
		return mapper.findFreelistenByBid(page);
	}

	@Override
	public int findCount(int qid) throws Exception {
		return mapper.findCount(qid);
	}
	
	@Override
	public int findCountByBid(int bid) throws Exception {
		return mapper.findCountByBid(bid);
	}

	@Override
	public List<Freelisten> findOnlineFreelisten(int qid) throws Exception {
		Gson g=new Gson();
		Jedis jedis=jedisPool.getResource();
		Long freelisten=jedis.hlen("freelisten");
		if(freelisten==0){
			List<Freelisten> s=mapper.findOnlineFreelisten(qid);
			for(int i=0;i<s.size();i++){
				String jsonstr=g.toJson(s.get(i));
				jedis.hset("freelisten", String.valueOf(s.get(i).getFid()), jsonstr);
			}
			jedis.close();
			return s;
		}else{
			List<String> s1=jedis.hvals("freelisten");
			List<Freelisten> s = new ArrayList();
			for(int i=0;i<s1.size();i++){
				s.add(g.fromJson(s1.get(i), Freelisten.class));
			}
			jedis.close();
			return s;
		}
	}

}
