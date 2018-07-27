package com.neusoft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.mapper.TeacherMapper;
import com.neusoft.po.Swiper;
import com.neusoft.po.Teacher;
import com.neusoft.service.TeacherService;
import com.neusoft.tools.Page;

@Service
public class TeacherServiceBean implements TeacherService {

	@Autowired
	private TeacherMapper mapper;
	
	@Override
	public List<Teacher> findAllTeacher(int qid) throws Exception{
		return mapper.findAllTeacher(qid);
	}
	
	@Override
	public int findCount(int qid)throws Exception {
		return mapper.findCount(qid);
	}

	@Override
	public Teacher findTeacherById(int tid) throws Exception{
		return mapper.findTeacherById(tid);
	}


	@Override
	public boolean deleteTeacherById(int tid) throws Exception{
		boolean isok=false;
		int result=mapper.deleteTeacherById(tid);
		if(result>0){
			isok=true;
		}else{
			isok=false;
		}
		return isok;
	}

	@Override
	public boolean updateTeacher(Teacher t) throws Exception{
		boolean isok=false;
		int result=mapper.updateTeacher(t);
		if(result>0){
			isok=true;
		}else{
			isok=false;
		}
		return isok;
	}

	@Override
	public boolean saveTeacher(Teacher t) throws Exception{
		boolean isok=false;
		int result=mapper.saveTeacher(t);
		if(result>0){
			isok=true;
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
	public List<Teacher> findAllTeacherByPage(Page page) throws Exception {
		return mapper.findAllTeacherByPage(page);
	}

}
