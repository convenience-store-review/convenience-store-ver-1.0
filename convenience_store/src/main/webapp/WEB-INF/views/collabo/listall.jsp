<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="../include/header.jsp" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<h1>Collabo Review 전체보기</h1>



<section class="content">
	<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">Collabo Review All</h3>
				</div>
				<div class="box-body">
					<ul>
					  	<c:forEach items="${listall}" var="collaboReview">
					      <li>제목 : ${collaboReview.title} 총액:      ${collaboReview.total_price}</li>
					   	</c:forEach>
					</ul>

					
				</div>
				<!-- /.box-body -->
</div>


<%-- <form action="read.jsp" method=post>
	<input type="hidden" name="c_id" value="${collaboReview.id}">
</form> --%>


</section>






<%@ include file="../include/footer.jsp" %>