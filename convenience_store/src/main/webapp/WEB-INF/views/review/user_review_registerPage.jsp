<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../include/header.jsp"%>

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">REGISTER User_Review</h3>
				</div>
				<!-- /.box-header -->

<form role="form" action="user_review_register" method="post">

<input type='hidden' name='productReview.id' value ="${product_review_id}">
<input type='hidden' name='regdate' value ="">
<input type='hidden' name='user.id' value ="1">

	<div class="box-body">
		<div class="form-group">
			<label for="exampleInputEmail1">Taste</label> 
			<input type="text"
				name='taste' class="form-control" placeholder="Enter Taste">
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">Cost_ratio</label> 
			<input type="text"
				name='cost_ratio' class="form-control" placeholder="Enter Cost_Ratio">
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">Calory</label> 
			<input type="text"
				name='calory' class="form-control" placeholder="Enter Calory">
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">Total</label> 
			<input type="text" name='total' class="form-control" readonly="readonly">
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Content1</label>
			<textarea class="form-control" name="content1" rows="3"
				placeholder="Enter ..."></textarea>
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Content2</label>
			<textarea class="form-control" name="content2" rows="3"
				placeholder="Enter ..."></textarea>
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Content3</label>
			<textarea class="form-control" name="content3" rows="3"
				placeholder="Enter ..."></textarea>
		</div>
	</div>
	<!-- /.box-body -->
</form>
	<div class="box-footer">
		<button type="submit" class="btn-primary">Submit</button>
	</div>



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


	<script type="text/javascript">
				$("input").on("input", function() {
					var taste = document.getElementsByName("taste")[0].value;
					var cost_ratio = document.getElementsByName("cost_ratio")[0].value;
					var calory = document.getElementsByName("calory")[0].value;
					
					var total = document.getElementsByName("total")[0];
					
					taste = Number(taste);
					cost_ratio = Number(cost_ratio);
					calory = Number(calory);
					
					total.value = ((taste + cost_ratio + calory) / 3).toFixed(1);
				});
				
	</script>
	<script>
		$(document)
			.ready(
				function() {
					var formObj = $("form[role='form']");
						console.log(formObj);
							$(".btn-primary").on("click",function() {
									formObj.attr("action", "/review/user_review_register");
									formObj.attr("method", "post");
									formObj.submit();
									
							});

						});
	</script>
	<script>
		var product_review_id = document.getElementsByName("productReview.id")[0];
		var today = new Date();
		var dd = today.getDate();
		var mm = today.getMonth()+1; //January is 0!
		var yyyy = today.getFullYear();
		var regdate = document.getElementsByName("regdate")[0];
		
		product_review_id.value = Number(product_review_id.value);
		if(dd<10) {
		    dd='0'+dd
		} 
		if(mm<10) {
		    mm='0'+mm
		} 
		today = yyyy+'/' + mm+'/'+dd;
		regdate.value = today;
	</script>
<%@include file="../include/footer.jsp"%>
