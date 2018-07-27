package com.neusoft.service;

import java.util.List;

import com.neusoft.po.Swiper;
import com.neusoft.po.Teacher;
import com.neusoft.tools.Page;

public interface TeacherService {
	public List<Teacher> findAllTeacher(int qid) throws Exception;
	public List<Teacher> findAllTeacherByPage(Page page) throws Exception;
	public Teacher findTeacherById(int tid) throws Exception;
	public boolean deleteTeacherById(int tid) throws Exception;
	public boolean updateTeacher(Teacher t) throws Exception;
	public boolean saveTeacher(Teacher t) throws Exception;
	public Swiper findimgurl(int qid) throws Exception;
	public int findCount(int qid) throws Exception;
}
