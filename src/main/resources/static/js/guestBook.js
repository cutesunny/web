$(function(){
	//留言
	$('#loginBtn').click(function(){
		var content = $('content').val();
		$.ajax({
				url:baseUrl+'/api/guestBook',
				method:'post',
				data:{
					content:content
				},
				dataType:'json',
				success:function(response){
					if(response.status == 200){
						isLogin = true;
						Layer.msg('登陆成功', {icon:1});
						window.reload();
					}else{
						Layer.alert(response.errMsg, {icon:2});
					}
				},
				error:function(){
					Layer.alert("登陆失败", {icon:2});
				}
		});
	});
});