<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body ul{
 margin:0px auto;
}
li{
list-style:none;
}
</style>
 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <form id="searchForm" action="http://v.qq.com/x/search/" method="get" target="_blank">
         
                
                        <input type="text" name="q" id="keywords" class="search_input" placeholder="" autocomplete="off">
                 
                     
                    <input type="hidden" name="stag">
                    <input type="hidden" name="smartbox_ab">
                    <button class="search_btn" type="submit" _stat="new_vs_header:search"><span class="btn_inner">全网搜</span></button>
                    
</form>
</body>
</html>