package com.neusoft.mapper;

import java.util.List;
import java.util.Map;

import com.neusoft.po.Branch;
import com.neusoft.po.Lesson;
import com.neusoft.po.LessonBranch;
import com.neusoft.po.Swiper;
import com.neusoft.tools.Page;

public interface LessonMapper {

	public List<Lesson> findAllLesson(int qid) throws Exception;
	public List<Lesson> findAllLessonByPage(Page page) throws Exception;
	public Lesson findLessonById(int lid)throws Exception;
	public List<Lesson> findLessonByBid(Page page) throws Exception;
	public int deleteLessonById(int lid)throws Exception;
	public int updateLesson(Lesson lesson)throws Exception;
	public Swiper findimgurl(int qid) throws Exception;
	public int saveLesson(Lesson lesson)throws Exception;
	public List<String> selectCategory() throws Exception;
	public int findCount(int qid) throws Exception;
	public int findCountByBid(int bid) throws Exception;
	public int selectLAST_INSERT_ID() throws Exception;
	public List<Branch> findBranchByLesson(int lid) throws Exception;
}
	

