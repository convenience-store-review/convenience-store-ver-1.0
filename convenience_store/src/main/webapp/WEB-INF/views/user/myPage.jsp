<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>


<%@include file="../include/cvs-header.jsp" %>

    <!-- Main content -->
    <section class="content">
      <div class="row">
      <!-- left column -->
      <div class="col-md-12">
        <!-- general form elements -->

        <div class="box">
            <div class="box-header with-border">
              <h3 class="box-title">USER HOME PAGE</h3>
            </div>
			<div class="box-body">
			 <div class="myPage-left-article">
			     <article>
			         <div class="myPage-photo">
			             <c:if test="${empty loginUser.photo}">
					        <img class="profile-user-img img-responsive img-circle" src="/resources/image/blank-profile-640x640.png" alt="User profile picture">
			             </c:if>
			             <c:if test="${not empty loginUser.photo}">
					        <img class="profile-user-img img-responsive img-circle" src="/resources/dist/img/user4-128x128.jpg" alt="User profile picture">
			             </c:if>
				    </div>
				
				    <h3 class="profile-username text-center">${loginUser.nickname}</h3>
				
				    <p class="text-muted text-center">${loginUser.email}</p>
				
				    <ul class="list-group list-group-unbordered">
				    <li class="list-group-item">
				      <b>Followers</b> <a class="pull-right">1,322</a>
				    </li>
				    <li class="list-group-item">
				      <b>Following</b> <a class="pull-right">543</a>
				    </li>
				    <li class="list-group-item">
				      <b>Friends</b> <a class="pull-right">13,287</a>
				    </li>
				    </ul>
				
				    <a href="#" class="btn btn-primary btn-block"><b>Follow</b></a>
			     </article>
			 </div> <!-- /.left-article -->
			 
             <div class="myPage-right-article">
                 <article>
				  <div class="tab-pane active" id="settings">
				    <form class="form-horizontal">
				      <div class="form-group">
				        <label for="inputEmail" class="col-sm-2 control-label">Email</label>
				        <div class="col-sm-10">
				          <input class="form-control" id="inputEmail" name="email" 
				          placeholder="Email" type="email" value="${loginUser.email}" readonly="readonly">
				        </div>
				      </div>
				      <div class="form-group">
				        <label for="inputNickname" class="col-sm-2 control-label">Nickname</label>
				        <div class="col-sm-10">
				          <input class="form-control" id="inputNickname" name="nickname" 
				          placeholder="Nickname" type="text" value="${loginUser.nickname}">
				        </div>
				      </div>
				      <div class="form-group">
				        <label for="inputPassword" class="col-sm-2 control-label">Password</label>
				        <div class="col-sm-10">
				          <input class="form-control" id="inputPassword" name="password" 
				          placeholder="Password" type="password" >
				        </div>
				      </div>
				      <div class="form-group">
				        <label for="inputConfirmPassword" class="col-sm-2 control-label">Password</label>
				        <div class="col-sm-10">
				          <input class="form-control" id="inputConfirmPassword" name="confirmPassword" 
				          placeholder="Confirm password" type="password" >
				        </div>
				      </div>
				      <div class="form-group">
				        <label for="inputSkills" class="col-sm-2 control-label">Photo</label>
				
				        <div class="col-sm-10">
				          <input class="form-control" id="inputPhoto" name="photo" 
				          placeholder="Photo" type="text" readonly="readonly"
				          value="${loginUser.photo}">
				        </div>
				      </div>
				      <div class="form-group">
				        <div class="col-sm-offset-2 col-sm-10">
				          <button type="submit" class="btn btn-default bg-green">수정</button>
				          <button type="submit" class="btn btn-danger bg-red">탈퇴</button>
				        </div>
				      </div>
				    </form>
				  </div>
				</article>
			  </div> <!-- /.right-article -->
			  <!-- /.tab-pane -->
			</div>
        </div>
      </div><!--/.col (left) -->
      </div>   <!-- /.row -->
    </section><!-- /.content -->

<script type="text/javascript">
// 1. DOM 생성 후
$(function(){
//	console.log('${ loginUser }');
});

// 2. 이미지 로딩 후
$(window).load(function(){
    //alert('haha');
});
</script>
    
<%@include file="../include/cvs-footer.jsp" %>
 