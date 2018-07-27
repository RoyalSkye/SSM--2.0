package com.neusoft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.mapper.SwiperMapper;
import com.neusoft.po.Swiper;
import com.neusoft.service.SwiperService;

@Service
public class SwiperServiceBean implements SwiperService {

	@Autowired
	private SwiperMapper mapper;
	
	@Override
	public boolean saveSwiper(Swiper swiper) throws Exception {
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
	public boolean updateSwiper(Swiper swiper) throws Exception {
		boolean isok=false;
		int result=mapper.updateSwiper(swiper);
		if(result>0){
			isok=true;
		}else{
			isok=false;
		}
		return isok;
	}

	@Override
	public List<Swiper> findSwiperByQid(int qid) throws Exception {
		return mapper.findSwiperByQid(qid);
	}

}
