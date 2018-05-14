$(function(){
	//登陆
	$('#loginBtn').click(function(){
		var username = $('#username').val();
		var password = $('#password').val();
		$.ajax({
				url:baseUrl+'/api/session',
				method:'post',
				data:{
					username:username,
					password:password
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
	//注册
	$('#registBtn').click(function(){
		var username = $('#username').val();
		var password = $('#password').val();
		$.ajax({
				url:baseUrl+'/user',
				method:'post',
				data:{
					username:username,
					password:password
				},
				dataType:'json',
				success:function(response){
					if(response.status == 200){
						Layer.msg('注册成功', {icon:1});
						window.reload();
					}else{
						Layer.alert(response.errMsg, {icon:2});
					}
				},
				error:function(){
					Layer.alert("注册失败", {icon:2});
				}
		});
	});
});