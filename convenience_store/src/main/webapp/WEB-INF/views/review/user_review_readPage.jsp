<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>

<%@include file="../include/header.jsp" %>

    <!-- Main content -->
    <section class="content">
      <div class="row">
      <!-- left column -->
      <div class="col-md-12">
        <!-- general form elements -->
        <div class="box box-primary">
        <div class="box-header">
          <h3 class="box-title">USER_REVIEW_READ</h3>
        </div><!-- /.box-header -->

    <form role="form" action="user_review_modifyPage" method="get">
    
    <input type="hidden" name="product_id" value ="${userReview.productReview.id}">
    <input type='hidden' name='user_review_id' value ="${userReview.id}">
    <input type='hidden' name='user_id' value ="${userReview.user.id}">
    <input type='hidden' name='grade_id' value ="${userReview.grade.id}">
    <input type="hidden" name="id" value ="${userReview.productReview.id}">
    
 </form>

  
 
  <div class="box-body">
    <div class="form-group">
      <label for="exampleInputEmail1">No</label>
      <input type="text" name='No' class="form-control" 
         value="${userReview.id}" readonly="readonly">
    </div>
    <div class="form-group">
      <label for="exampleInputEmail1">Taste</label>
      <input type="hidden" name='title' class="form-control" 
         value="${userReview.grade.taste}" readonly="readonly">
    </div>
    <div class="form-group">
      <label for="exampleInputEmail1">Cost_ratio</label>
      <input type="text" name='cost_ratio' class="form-control" 
         value="${userReview.grade.cost_ratio}" readonly="readonly">
    </div>
    <div class="form-group">
      <label for="exampleInputEmail1">Calory</label>
      <input type="text" name='calory' class="form-control" 
         value="${userReview.grade.calory}" readonly="readonly">
    </div>
    <div class="form-group">
      <label for="exampleInputEmail1">Total</label>
      <input type="text" name='total' class="form-control" 
         value="${userReview.grade.total}" readonly="readonly">
    </div>
    <div class="form-group">
      <label for="exampleInputPassword1">Content1</label>
      <textarea class="form-control"  name="content1" rows="3" 
      readonly="readonly">${userReview.content1}</textarea>
    </div>
     <div class="form-group">
      <label for="exampleInputPassword1">Content2</label>
      <textarea class="form-control"  name="content2" rows="3" 
      readonly="readonly">${userReview.content2}</textarea>
    </div>
     <div class="form-group">
      <label for="exampleInputPassword1">Content3</label>
      <textarea class="form-control"  name="content3" rows="3" 
      readonly="readonly">${userReview.content3}</textarea>
    </div>
  </div><!-- /.box-body -->

  <div class="box-footer">
    <button type="submit" class="btn btn-warning">Modify</button>
    <button type="submit" class="btn btn-danger">REMOVE</button>
    <button type="submit" class="btn btn-primary">GO LIST </button>
  </div>


<script>
$(document).ready(function(){
	
	var formObj = $("form[role='form']");
	
	console.log(formObj);
	
	$(".btn-warning").on("click", function(){
		formObj.attr("action", "/review/user_review_modifyPage");
		formObj.attr("method", "get");		
		formObj.submit();
	});
	
	$(".btn-danger").on("click", function(){
		formObj.attr("action", "/review/user_review_remove");
		formObj.attr("method", "post");
		formObj.submit();
	});
	
	$(".btn-primary").on("click", function(){
		formObj.attr("method", "get");
		formObj.attr("action", "/review/user_review_list");
		formObj.submit();
	});
	
});
</script>


  
  
        </div><!-- /.box -->
      </div><!--/.col (left) -->
 
      </div>   <!-- /.row -->
    </section><!-- /.content -->
    </div><!-- /.content-wrapper -->
    
<%@include file="../include/footer.jsp" %>
  