package com.neusoft.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.neusoft.mapper.SwiperMapper;
import com.neusoft.po.Enterprise;
import com.neusoft.po.Swiper;
import com.neusoft.service.SwiperService;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class SwiperServiceBean implements SwiperService {

	@Autowired
	private SwiperMapper mapper;
	@Autowired
	private JedisPool jedisPool;
	
	@Override
	public boolean saveSwiper(Swiper swiper) throws Exception {  //û���õ�
		boolean isok=false;
		int result=mapper.saveSwiper(swiper);
		if(result>0){
			isok=true;
		}else{
			isok=false;
		}
		return isok;
	}

	@Override
	public boolean updateSwiper(Swiper swiper) throws Exception {  //���ں�̨index.html��ѯ��ҵ��Ϣ��ʱ��ʹ�õ���enterprise left join swiper ���Ը���ÿ��swiper��ʱ����Ҫdel enterprise1 ������Ȼmysql���ݿ������ ����redisû�и��£���ôindex.html���������κα仯
		boolean isok=false;
		int result=mapper.updateSwiper(swiper);
		if(result>0){
			Jedis jedis=jedisPool.getResource();
			jedis.del("swiper");
			String enterprise="enterprise"+swiper.getQid();
			jedis.del(enterprise);
			jedis.close();
			isok=true;
		}else{
			isok=false;
		}
		return isok;
	}

	@Override
	public List<Swiper> findSwiperByQid(int qid) throws Exception {
		Gson g=new Gson();
		Jedis jedis=jedisPool.getResource();
		//String swiper=jedis.hget("swpier", "A");  //������� ��del swiper
		Long swiper=jedis.hlen("swiper");
		System.out.println("swiper len="+swiper);
		if(swiper==0){
			//System.out.println("swiper is null");
			List<Swiper> s=mapper.findSwiperByQid(qid);
			for(int i=0;i<s.size();i++){
				String jsonstr=g.toJson(s.get(i));
				jedis.hset("swiper", s.get(i).getCategory(), jsonstr);
			}
			jedis.close();
			return s;
		}else{
			List<String> s1=jedis.hvals("swiper");
			//System.out.println(s1);
			List<Swiper> s = new ArrayList();
			for(int i=0;i<s1.size();i++){
				s.add(g.fromJson(s1.get(i), Swiper.class));
			}
			//List<Swiper> s=g.fromJson(jedis.hvals("swiper"),new TypeToken<Swiper>(){}.getType());
			/*List<Swiper> s2 = g.fromJson("swiper", new TypeToken<List<Swiper>>(){}.getType());
			for (Swiper stu : s2) {
				System.out.println(stu);
			}*/
			jedis.close();
			return s;
		}
	}

}
