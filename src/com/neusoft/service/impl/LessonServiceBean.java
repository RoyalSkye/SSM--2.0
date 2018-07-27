package com.neusoft.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.mapper.BranchMapper;
import com.neusoft.mapper.FreelistenMapper;
import com.neusoft.mapper.LessonBranchMapper;
import com.neusoft.mapper.LessonMapper;
import com.neusoft.po.Branch;
import com.neusoft.po.Lesson;
import com.neusoft.po.LessonBranch;
import com.neusoft.po.Swiper;
import com.neusoft.service.LessonService;
import com.neusoft.tools.Page;

@Service
public class LessonServiceBean implements LessonService {

	@Autowired
	private LessonMapper mapper;
	@Autowired
	private LessonBranchMapper lessonbranchmapper;
	
	@Override
	public List<Lesson> findAllLesson(int qid) throws Exception {
		return mapper.findAllLesson(qid);
	}

	@Override
	public Lesson findLessonById(int lid) throws Exception {
		return mapper.findLessonById(lid);
	}

	@Override
	public boolean deleteLessonById(int lid) throws Exception {
		boolean isok=false;
		int result=mapper.deleteLessonById(lid);
		if(result>0){
			isok=true;
		}else{
			isok=false;
		}
		return isok;
	}

	@Override
	public boolean saveLesson(Lesson lesson,String bid1) throws Exception {  //同时向lessonbranch表中插入数据
		boolean isok=false;
		int result=mapper.saveLesson(lesson);
		int lid=mapper.selectLAST_INSERT_ID();
		if(result>0){
			isok=true;
			String[] splitbid=bid1.split(",");
			for(int i=0;i<splitbid.length;i++){
				int bid=Integer.parseInt(splitbid[i]);
				//System.out.println(bid);
				LessonBranch lessonbranch=new LessonBranch();
				lessonbranch.setBid(bid);
				lessonbranch.setLid(lid);
				if(lessonbranchmapper.saveLessonbranch(lessonbranch)<=0){
					isok=false;
				}
			}
		}else{
			isok=false;
		}
		return isok;
	}

	@Override
	public boolean updateLesson(Lesson lesson,String bid1) throws Exception {
		int lid=lesson.getLid();
		boolean isok=false;
		int result=mapper.updateLesson(lesson);
		if(result>0){
			isok=true;
			LessonBranch lessonbranch=new LessonBranch();
			lessonbranch.setLid(lid);
			if(lessonbranchmapper.deleteLessonBranchByLid(lessonbranch)<=0) isok=false;
			String[] splitbid=bid1.split(",");
			for(int i=0;i<splitbid.length;i++){
				int bid=Integer.parseInt(splitbid[i]);
				System.out.println("bid="+bid);
				LessonBranch lb=new LessonBranch();
				lb.setBid(bid);
				lb.setLid(lid);
				if(lessonbranchmapper.saveLessonbranch(lb)<=0) isok=false;
			}
		}else{
			isok=false;
		}
		return isok;
	}

	@Override
	public Swiper findimgurl(int qid) throws Exception {
		return mapper.findimgurl(qid);
	}

	@Override
	public List<String> selectCategory() throws Exception {
		return mapper.selectCategory();
	}
	
	@Override
	public int findCount(int qid) throws Exception {
		return mapper.findCount(qid);
	}

	@Override
	public List<Lesson> findAllLessonByPage(Page page) throws Exception {
		return mapper.findAllLessonByPage(page);
	}

	@Override
	public List<Lesson> findLessonByBid(Page page) throws Exception {
		return mapper.findLessonByBid(page);
	}

	@Override
	public int findCountByBid(int bid) throws Exception {
		return mapper.findCountByBid(bid);
	}

	@Override
	public List<Branch> findBranchByLesson(int lid) throws Exception {
		return mapper.findBranchByLesson(lid);
	}

}
