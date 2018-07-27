package com.neusoft.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.neusoft.po.Enterprise;

public interface EnterpriseService {
	public Enterprise findEnterpriseById(int qid) throws Exception;
	public Boolean updateEnterprise(Enterprise e) throws Exception;
}
