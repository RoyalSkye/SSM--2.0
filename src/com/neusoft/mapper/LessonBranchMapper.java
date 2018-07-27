package com.neusoft.mapper;

import java.util.List;
import java.util.Map;

import com.neusoft.po.LessonBranch;

public interface LessonBranchMapper {

	public int saveLessonbranch(LessonBranch lessonbranch) throws Exception;
	public int deleteLessonBranchByLid(LessonBranch lessonbranch)throws Exception;
}
	

