<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="../include/header.jsp" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style type="text/css">
	button {
		margin-left : 30px;
	}
</style>


<h1>Collabo Review 전체보기</h1>



<section class="content">
	<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">Collabo Review All</h3> 
					<a href='/collabo/register'><button class="btn btn-primary">Register</button></a>
				</div>
				<div class="box-body">
					<ul>
					  	<c:forEach items="${listall}" var="collaboReview">
					      <li><a href='/collabo/read?id=${collaboReview.id}'>
					      번호 : ${collaboReview.id}  제목 : ${collaboReview.title} 총액:      ${collaboReview.total_price}  
					      날짜 : <fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${collaboReview.regdate}"/> 
					      좋아요 수 : ${collaboReview.like_count }</a></li>
					   	</c:forEach>
					</ul>

					
				</div>
				<!-- /.box-body -->
</div>


<%-- <form action="read.jsp" method=post>
	<input type="hidden" name="c_id" value="${collaboReview.id}">
</form> --%>


</section>

<script>
	var result = '${msg}';
	
	if(result==success) {
		alert("처리가 완료됐어!!");
	}
</script>




<%@ include file="../include/footer.jsp" %>