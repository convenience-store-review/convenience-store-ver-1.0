<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="../include/header.jsp" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Collabo Review 상세보기</h1>

<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">Collabo Review</h3>
				</div>
				<div class="box-body">
					<table class="table table-bordered">
						<tr>
							<th>id</th>
							<th>title</th>
							<th>email</th>
							<th>user.nickname</th>
							<th>total_price</th>
							<th>like_count</th>
							<th>grade_total_count</th>
							<th>view_count</th>
							<th>regdate</th>
							<th>updatedate</th>
						</tr>

						<tr>
							<td>${collaboReview.id}</td>
							<td>${collaboReview.title}</td>
							<td>${collaboReview.user.email}</td>
							<td>${collaboReview.user.nickname}</td>
							<td>${collaboReview.total_price}</td>
							<td>${collaboReview.like_count}</td>
							<td>${collaboReview.grade_total_count}</td>
							<td>${collaboReview.view_count}</td>
							<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
									value="${collaboReview.regdate}" /></td>
							<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
									value="${collaboReview.updatedate}" /></td>
						</tr>

					</table>
					<br>
					<br>
					
					<table class="table table-bordered">
						<tr>
							<th>맛</th>
							<th>가성비</th>
							<th>칼로리</th>
						</tr>

						<tr>
							<td>${collaboReview.grade.id}</td>
							<td>${collaboReview.grade.cost_ratio}</td>
							<td>${collaboReview.grade.calory}</td>
						</tr>

					</table>
					
					<br>
					<br>
					
					
					<table class="table table-bordered" width="70%">
						<tr>
							<th>사진</th>
							<th>날짜</th>
							<th>아이디</th>
						</tr>
				
						<c:forEach items="${list}" var="attachPhoto">
							<tr>
								<td><img width="100px" height = "100px" src="${pageContext.request.contextPath}${attachPhoto.attach_photo_fullname}"></td>
								<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
									value="${attachPhoto.regdate}" /></td>
								<td>${attachPhoto.collabo_review_id.id}</td>
								
							</tr>
						</c:forEach>
					</table>
					
					
					<br>
					<br>
					<table class="table table-bordered">
						<tr>
							<th>recipe</th>
							<th>tips</th>
							<th>ispenalty</th>
						</tr>

						<tr>
							<td>${collaboReview.recipe}</td>
							<td>${collaboReview.tips}</td>
							<td>${collaboReview.ispenalty}</td>
						</tr>

					</table>
					
					
				</div>
				<!-- /.box-body -->
</div>





<%@ include file="../include/footer.jsp" %>