<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../include/header.jsp"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">Product_Review</h3>
				</div>
				<!-- /.box-header -->
<table class="table table-bordered">
	<tr>
		<th style="width: 10px">name</th>
		<th>price</th>
		<th>photoURL</th>
		<th>like_count</th>
	</tr>
	<tr>
		<td>${productReview.product.name}</td>
		<td>${productReview.product.price}</td>
		<td><img width="100px" height = "100px" src="${pageContext.request.contextPath}${productReview.product.photo}"></td>
		<td>${productReview.like_count}</td>
	</tr>
</table>
<table class="table table-bordered">
	<tr>
		<th style="width: 10px">Grade_total</th>
		<th>taste</th>
		<th>cost_ratio</th>
		<th>calory</th>
	</tr>
	<tr>
		<td>${productReview.grade.total}</td>
		<td>${productReview.grade.taste}</td>
		<td>${productReview.grade.cost_ratio}</td>
		<td>${productReview.grade.calory}</td>
	</tr>
</table>

	
	<c:forEach items="${list}" var="ur">
	<table class="table table-bordered">
	<tr>
		<th style="width: 10px">nickname</th>
		<th>regdate</th>
		<th>taste</th>
		<th>cost_ratio</th>
		<th>calory</th>
	</tr>

	<tr>
		<td>${ur.user.nickname}</td>
		<td>${ur.regdate}</td>
		<td>${ur.grade.taste}</td>
		<td>${ur.grade.cost_ratio}</td>
		<td>${ur.grade.calory}</td>
	</tr>
	<tr>
		<th>user_img</th>
		<th>total</th>
		<th>content1</th>
		<th>content2</th>
		<th>content3</th>
	</tr>
	<tr>
		<td><img width="50px" height = "50px" src="${pageContext.request.contextPath}${ur.user.photo}"></td>
		<td>${ur.grade.total}</td>
		<td>${ur.content1}</td>
		<td>${ur.content2}</td>
		<td>${ur.content3}</td>
	</tr>
</table>
<br><br>
</c:forEach>



		</div>
		<!-- /.box -->
	</div>
	<!--/.col (left) -->

</div>
<!-- /.row -->
</section>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<%@include file="../include/footer.jsp"%>
