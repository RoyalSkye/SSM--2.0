package com.neusoft.mapper;

import java.util.List;

import com.neusoft.po.Swiper;

public interface SwiperMapper {
	public List<Swiper> findSwiperByQid(int qid) throws Exception;
	public int saveSwiper(Swiper swiper) throws Exception;
	public int updateSwiper(Swiper swiper) throws Exception;
}
