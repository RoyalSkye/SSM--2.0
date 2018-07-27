package com.neusoft.mapper;

import java.util.List;

import com.neusoft.po.Message;
import com.neusoft.po.Messageimg;
import com.neusoft.po.Messagelike;
import com.neusoft.po.Messagereply;
import com.neusoft.po.Swiper;
import com.neusoft.tools.Page;

public interface MessageMapper {
	
	public List<Message> findAllMessage(int qid) throws Exception;
	public Message findMessageById(int mid) throws Exception;
	public int updateMessage(Message message) throws Exception;
	public int deleteMessage(int mid) throws Exception;
	public int saveMessage(Message message) throws Exception;
	public List<Messagereply> findMessagereplyById(Page page) throws Exception;
	public int deleteMessageimg(int miid) throws Exception;
	public int saveMessageimg(Messageimg messageimg) throws Exception;
	public int deleteMessagereply(int mrid) throws Exception;
	public Swiper findimgurl(int qid) throws Exception;
	public int selectLAST_INSERT_ID() throws Exception;
	public int findMessageCount(int qid) throws Exception;
	public Messagelike findMessagelike(Messagelike m) throws Exception;
	public int saveMessagereply(Messagereply m) throws Exception;
	public int saveMessagelike(Messagelike m) throws Exception;
	public int deleteMessagelike(Messagelike m) throws Exception;
	public List<Messagelike> findAllMessagelike(String mlnickname) throws Exception;
}
