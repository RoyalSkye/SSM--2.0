package com.neusoft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.mapper.MessageMapper;
import com.neusoft.po.Message;
import com.neusoft.po.Messageimg;
import com.neusoft.po.Messagelike;
import com.neusoft.po.Messagereply;
import com.neusoft.po.Swiper;
import com.neusoft.service.MessageService;
import com.neusoft.tools.Page;

@Service
public class MessageServiceBean implements MessageService {

	@Autowired
	private MessageMapper mapper;
	
	@Override
	public List<Message> findAllMessage(int qid) throws Exception {
		return mapper.findAllMessage(qid);
	}

	@Override
	public Message findMessageById(int mid) throws Exception {
		return mapper.findMessageById(mid);
	}

	@Override
	public boolean updateMessage(Message message,String img) throws Exception {
		boolean isok=false;
		int result=mapper.updateMessage(message);
		if(result>0){
			isok=true;
			int mid=message.getMid();
			if(mapper.deleteMessageimg(mid)<=0) isok=false;
			String[] splitimgurl=img.split(",");
			for(int i=0;i<splitimgurl.length;i++){
				String imgurl=splitimgurl[i];
				System.out.println("imgurl="+imgurl);
				Messageimg m=new Messageimg();
				m.setImgurl(imgurl);
				m.setMid(mid);
				if(mapper.saveMessageimg(m)<=0) isok=false;
			}
		}else{
			isok=false;
		}
		return isok;
	}

	@Override
	public boolean saveMessage(Message message,String img) throws Exception {
		boolean isok=false;
		int result=mapper.saveMessage(message);
		if(result>0){
			isok=true;
			int mid=mapper.selectLAST_INSERT_ID();
			String[] splitimgurl=img.split(",");
			for(int i=0;i<splitimgurl.length;i++){
				String imgurl=splitimgurl[i];
				System.out.println("imgurl="+imgurl);
				Messageimg m=new Messageimg();
				m.setImgurl(imgurl);
				m.setMid(mid);
				if(mapper.saveMessageimg(m)<=0) isok=false;
			}
		}else{
			isok=false;
		}
		return isok;
	}
	
	
	@Override
	public boolean deleteMessage(int mid) throws Exception {
		boolean isok=false;
		int result=mapper.deleteMessage(mid);
		if(result>0){
			isok=true;
		}else{
			isok=false;
		}
		return isok;
	}

	@Override
	public List<Messagereply> findMessagereplyById(Page page) throws Exception {
		return mapper.findMessagereplyById(page);
	}

	@Override
	public boolean deleteMessagereply(int mrid) throws Exception {
		boolean isok=false;
		int result=mapper.deleteMessagereply(mrid);
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
	public int findMessageCount(int qid)throws Exception{
		return mapper.findMessageCount(qid);
	}

	@Override
	public boolean saveMessagereply(Messagereply m) throws Exception {
		boolean isok=false;
		int result=mapper.saveMessagereply(m);
		if(result>0){
			isok=true;
		}else{
			isok=false;
		}
		return isok;
	}

	@Override
	public boolean saveMessagelike(Messagelike m) throws Exception {
		boolean isok=false;
		Messagelike ml=mapper.findMessagelike(m);
		if(ml==null){  //点赞
			int result=mapper.saveMessagelike(m);
			if(result>0){
				isok=true;
			}else{
				isok=false;
			}
		}else{  //取消点赞
			int result=mapper.deleteMessagelike(ml);
			if(result>0){
				isok=true;
			}else{
				isok=false;
			}
		}
		return isok;
	}

	@Override
	public List<Messagelike> findAllMessagelike(String mlnickname) throws Exception {
		return mapper.findAllMessagelike(mlnickname);
	}

}
