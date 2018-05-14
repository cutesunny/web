
//获取新闻数据
function initNewsList(){
	$.ajax({
		url:baseUrl+'/news?offset=0&limit=15',
		dataType:'json',
		type:'get',
		success:function(response){
			if(response.status == 200){
				setNewsListData(response.data);
			}else{
				Layer.alert(response.errMsg, {icon:2});
			}
		},
		error:function(){
			Layer.alert("获取新闻失败", {icon:2});
		}
	});
}
//新闻幻灯片
function setNewsSlider(){
	
}

//新闻导航
function setNewsNavigation(){
	
}
//新闻列表
function setNewsList(){
	
}