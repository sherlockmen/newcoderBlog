$(function(){
	$("form").submit(check_data);
	$("input").focus(clear_error);
});

function check_data() {

	//发送AJAX请求之前，将CSRF令牌设置到请求的消息头中
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	$(document).ajaxSend(function (e, xhr, options) {
		xhr.setRequestHeader(header,token)
	});

	var pwd1 = $("#password").val();
	var pwd2 = $("#confirm-password").val();
	if(pwd1 != pwd2) {
		$("#confirm-password").addClass("is-invalid");
		return false;
	}
	return true;
}

function clear_error() {
	$(this).removeClass("is-invalid");
}