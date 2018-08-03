package com.neusoft.mapper;

import java.util.List;

import com.neusoft.po.Checkin;

public interface CheckinMapper {
	public int findCheckin(Checkin c) throws Exception;
	public int saveCheckin(Checkin c) throws Exception;
	public List<String> findAllCheckin(Checkin c) throws Exception;
}
