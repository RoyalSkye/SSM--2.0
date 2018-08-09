<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="com.baidu.ueditor.ActionEnter"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%

    /*request.setCharacterEncoding( "utf-8" );
	response.setHeader("Content-Type" , "text/html");
	String saveRootPath="/usr/local/nginx";
	String rootPath = application.getRealPath( "/" );
	out.write( new ActionEnter( request, saveRootPath,rootPath ).exec() );*/
	
	request.setCharacterEncoding( "utf-8" );
	response.setHeader("Content-Type" , "text/html");
	String rootPath = application.getRealPath( "/" );
	out.write( new ActionEnter( request, rootPath ).exec() );
	
	/*request.setCharacterEncoding("utf-8");
    response.setHeader("Content-Type", "text/html");
    response.setHeader("Access-Control-Allow-Origin", "http://101.201.70.204:8080");
    response.setHeader("Access-Control-Allow-Headers", "X-Requested-With,X_Requested_With");
    String rootPath = application.getRealPath("/");
    out.write(new ActionEnter(request, rootPath).exec());*/
	
%>


    
	
