package com.neusoft.service;

import java.util.List;

import com.neusoft.po.Swiper;

public interface SwiperService {
	public List<Swiper> findSwiperByQid(int qid) throws Exception;
	public boolean saveSwiper(Swiper swiper) throws Exception;
	public boolean updateSwiper(Swiper swiper) throws Exception;
}
