<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	

<div class="modal fade bs-example-modal-lg" id="addReplyModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="exampleModalLabel">${collaboReview.id}에 글쓰기 </h4>
        <span id="reply_register_nick"></span>
      </div>
      <div class="modal-body">
        <form>
          <!-- <div class="form-group">
            <label for="recipient-name" class="control-label">Recipient:</label>
            <input type="text" class="form-control" id="recipient-name">
          </div> -->
          <div id="www">
          	<div id="wrapper_grade" class="form-group"><input type="text"  id='reply_taste' name='re_taste' class="form-control" placeholder="taste"></div>
          	<div id="wrapper_grade" class="form-group"><input type="text"  id='reply_cost_ratio' name='re_cost_ratio' class="form-control" placeholder="ratio"></div>
          	<div id="wrapper_grade" class="form-group"><input type="text"  id='reply_calory' name='re_calory' class="form-control" placeholder="calory"></div>
          	<div id="wrapper_grade" class="form-group"><input type="text"  id='reply_total' name='re_total' readonly="true" class="form-control" placeholder="total"></div>
		</div>
		<br>
          <div class="form-group">
            <label for="content1" class="control-label">추천이유</label>
            <textarea class="form-control" id="content1"></textarea>
          </div>
          <div class="form-group">
            <label for="content2" class="control-label">아쉬운점</label>
            <textarea class="form-control" id="content2"></textarea>
          </div>
          <div class="form-group">
            <label for="content3" class="control-label">하고싶은말</label>
            <textarea class="form-control" id="content3"></textarea>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" id="modalClose">Close</button>
        <button type="button" class="btn btn-primary" id="replyAddBtn">Register</button>
      </div>
    </div>
  </div>
</div>



<div class="modal fade bs-example-modal-lg" id="modReplyModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="exampleModalLabel">${collaboReview.id}에 글쓰기 </h4>
        <span id="reply_register_nick"></span>
      </div>
      <div class="modal-body">
        <form>
          <!-- <div class="form-group">
            <label for="recipient-name" class="control-label">Recipient:</label>
            <input type="text" class="form-control" id="recipient-name">
          </div> -->
          <div id="www">
          	<div id="wrapper_grade" class="form-group"><input type="text"  id='mod_reply_taste' name='mod_re_taste' class="form-control" placeholder="taste"></div>
          	<div id="wrapper_grade" class="form-group"><input type="text"  id='mod_reply_cost_ratio' name='mod_re_cost_ratio' class="form-control" placeholder="ratio"></div>
          	<div id="wrapper_grade" class="form-group"><input type="text"  id='mod_reply_calory' name='mod_re_calory' class="form-control" placeholder="calory"></div>
          	<div id="wrapper_grade" class="form-group"><input type="text"  id='mod_reply_total' name='mod_re_total' readonly="true" class="form-control" placeholder="total"></div>
		</div>
		<br>
          <div class="form-group">
            <label for="content1" class="control-label">추천이유</label>
            <textarea class="form-control" id="mod_content1"></textarea>
          </div>
          <div class="form-group">
            <label for="content2" class="control-label">아쉬운점</label>
            <textarea class="form-control" id="mod_content2"></textarea>
          </div>
          <div class="form-group">
            <label for="content3" class="control-label">하고싶은말</label>
            <textarea class="form-control" id="mod_content3"></textarea>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" id="mod_modalClose">Close</button>
        <button type="button" class="btn btn-primary" id="mod_replyModBtn">Modify</button>
      </div>
    </div>
  </div>
</div>
