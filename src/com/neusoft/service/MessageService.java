package com.neusoft.service;

import java.util.List;

import com.neusoft.po.Message;
import com.neusoft.po.Messagelike;
import com.neusoft.po.Messagereply;
import com.neusoft.po.Swiper;
import com.neusoft.tools.Page;

public interface MessageService {

	
	public List<Message> findAllMessage(int qid) throws Exception;
	public Message findMessageById(int mid) throws Exception;
	public boolean updateMessage(Message message,String imgurl) throws Exception;
	public boolean saveMessage(Message message,String imgurl) throws Exception;
	public boolean deleteMessage(int mid) throws Exception;
	public List<Messagereply> findMessagereplyById(Page page) throws Exception;
	public boolean deleteMessagereply(int mrid) throws Exception;
	public Swiper findimgurl(int qid) throws Exception;
	public int findMessageCount(int qid) throws Exception;
	public boolean saveMessagereply(Messagereply m) throws Exception;
	public boolean saveMessagelike(Messagelike m) throws Exception;
	public List<Messagelike> findAllMessagelike(String mlnickname) throws Exception;
}
