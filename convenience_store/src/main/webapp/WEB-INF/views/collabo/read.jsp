<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="../include/header.jsp" %>

<h1>test</h1>

<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">LIST PAGING</h3>
				</div>
				<div class="box-body">
					<table class="table table-bordered">
						<tr>
							<th>id</th>
							<th>userid</th>
							<th>gradeid</th>	
							<th>title</th>
							<th>total_price</th>
							<th>recipe</th>
							<th>tips</th>
							<th>like_count</th>
							<th>grade_total_count</th>
							<th>view_cnt</th>
							<th>ispenalty</th>
							<th>regdate</th>
							<th>updatedate</th>
						</tr>

						<tr>
							<td>${collaboReview.id}</td>
							<td>${collaboReview.user_id}</td>
							<td>${collaboReview.grade_id}</td>
							<td>${collaboReview.title}</td>
							<td>${collaboReview.total_price}</td>
							<td>${collaboReview.recipe}</td>
							<td>${collaboReview.tips}</td>
							<td>${collaboReview.like_count}</td>
							<td>${collaboReview.grade_total_count}</td>
							<td>${collaboReview.view_cnt}</td>
							<td>${collaboReview.ispenalty}</td>
							<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
									value="${collaboReview.regdate}" /></td>
							<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
									value="${collaboReview.updatedate}" /></td>
						</tr>

					</table>
				</div>
				<!-- /.box-body -->
</div>





<%@ include file="../include/footer.jsp" %>