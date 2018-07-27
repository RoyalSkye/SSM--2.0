package com.neusoft.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neusoft.po.Branch;
import com.neusoft.service.BranchService;
import com.neusoft.tools.FileTools;
import com.neusoft.tools.Page;

@Controller
public class BranchHandler {

	@Autowired
	private BranchService branchService;
	
	@RequestMapping(value="/test/BranchHandler_findAllBranch",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String findAllBranch(HttpServletRequest request) throws Exception{
		HttpSession session=request.getSession();
		int qid;
		if(session.getAttribute("qid")==null){
			qid=1;
		}else{
			qid=(int)session.getAttribute("qid");
		}
		Page page=new Page();
		page.setTotalPage(branchService.findCount(qid));
		return FileTools.addHeader(branchService.findAllBranch(qid),page.getTotalPage());
	}
	
	@RequestMapping(value="/test/BranchHandler_findAllBranchByPage",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String findAllBranchByPage(HttpServletRequest request) throws Exception{
		int limit = Integer.parseInt(request.getParameter("limit"));
		int pages = Integer.parseInt(request.getParameter("page"));
		HttpSession session=request.getSession();
		int qid;
		if(session.getAttribute("qid")==null){
			qid=1;
		}else{
			qid=(int)session.getAttribute("qid");
		}
		Page page = new Page(limit,pages,qid);
		page.setTotalPage(branchService.findCount(page.getId()));
		return FileTools.addHeader(branchService.findAllBranchByPage(page),page.getTotalPage());
	}
	
	@RequestMapping(value="/test/BranchHandler_findBranchById")
	@ResponseBody
	public Branch findBranchById(int bid) throws Exception{
		return branchService.findBranchById(bid);
	}
	
	@RequestMapping(value="/test/BranchHandler_deleteBranchById")
	@ResponseBody
	public String deleteBranchById(int bid) throws Exception{
		if(branchService.deleteBranchById(bid)){
			return "{\"result\":true}";
		}else{
			return "{\"result\":false}";
		}
	}
	
	@RequestMapping(value="/test/BranchHandler_findCount")
	@ResponseBody
	public int findCount(HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		int qid;
		if(session.getAttribute("qid")==null){
			qid=1;
		}else{
			qid=(int)session.getAttribute("qid");
		}
		return branchService.findCount(qid);
	}
	
	@RequestMapping(value="/test/BranchHandler_updateBranch")
	@ResponseBody
	public String updateBranch(Branch b,HttpServletRequest request) throws Exception{
		HttpSession session=request.getSession();
		int qid;
		if(session.getAttribute("qid")==null){
			qid=1;
		}else{
			qid=(int)session.getAttribute("qid");
		}
		b.setQid(qid);
		if(branchService.updateBranch(b)){
			return "{\"result\":true}";
		}else{
			return "{\"result\":false}";
		}
		//return to the findallbranch html
	}
	
	@RequestMapping(value="/test/BranchHandler_saveBranch")
	@ResponseBody
	public String saveBranch(Branch b,HttpServletRequest request) throws Exception{
		HttpSession session=request.getSession();
		int qid;
		if(session.getAttribute("qid")==null){
			qid=1;
		}else{
			qid=(int)session.getAttribute("qid");
		}
		b.setQid(qid);
		if(branchService.saveBranch(b)){
			return "{\"result\":true}";
		}else{
			return "{\"result\":false}";
		}
	}
	
}
