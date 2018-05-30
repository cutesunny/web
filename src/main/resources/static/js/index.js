
//首页数据处理

$(function(){
	//获取幻灯片数据
	$.ajax({
		url:baseUrl+'/api/slider-image/list',
		async:false,
		method:'get',
		dataType:'json',
		success:function(response){
			if(response.code === 200){
				setSliderImage(response.data);
			}else{
				layer.alert('加载轮播图数据失败', {icon: 2});
			}
		},
		error:function(){
            layer.alert('加载轮播图数据失败', {icon: 2});
		}
	});
	//获取书法数据
	$.ajax({
		url:baseUrl+'/api/calligraphy/index',
		method:'get',
		dataType:'json',
		success:function(response){
			if(response.code === 200){
				setCalligraphyData(response.data);
			}else{
                layer.alert('加载书法数据失败', {icon: 2});
			}
		},
		error:function(){
            layer.alert('加载书法数据失败', {icon: 2});
		}
	});
	//获取绘画数据
	$.ajax({
		url:baseUrl+'/api/painting/list?pageNum=1&pageSize=3',
		method:'get',
		dataType:'json',
		success:function(response){
			if(response.code === 200){
				setPaintingData(response.data.content);
			}else{
                layer.alert('加载绘画数据失败', {icon: 2});
			}
		},
		error:function(){
            layer.alert('加载绘画数据失败', {icon: 2});
		}
	});
	//获取展厅数据
	$.ajax({
		url:baseUrl+'/api/article/index',
		method:'get',
		dataType:'json',
		success:function(response){
			if(response.code === 200){
				setGalleryData(response.data);
			}else{
                layer.alert('获取展厅数据失败', {icon: 2});
			}
		},
		error:function(){
            layer.alert('获取展厅数据失败', {icon: 2});
		}
	});

/*	//获取竞拍数据
    $.ajax({
        url:baseUrl+'/api/auction?offset=0&limit=8',
        method:'get',
        dataType:'json',
        success:function(response){
            if(response.code === 200){
                setAuctionData(response.data);
            }else{
                layer.alert('获取竞拍数据失败', {icon: 2});
            }
        },
        error:function(){
            layer.alert('获取竞拍数据失败', {icon: 2});
        }
    });*/

    //获取新闻数据
    $.ajax({
        url:baseUrl+'/api/news/list?pageNum=1&pageSize=2',
        method:'get',
        dataType:'json',
        success:function(response){
            if(response.code === 200){
                setNewsData(response.data.content);
            }else{
                layer.alert('获取新闻数据失败', {icon: 2});
            }
        },
        error:function(){
            layer.alert('获取新闻数据失败', {icon: 2});
        }
    });
});
/**
 * 置幻灯片数据
 */
function setSliderImage(sliderList){
	for(let i = 0; i < sliderList.length; i++){
		if(i === 0 ){
            $('#slider_index').append('<li data-target="#carousel1" data-slide-to="'+i+'" class="active"></li>');
            $('#slider_image').append('<div class="item active"><img src="'+sliderList[i].path+'" ></div>');
		}else{
            $('#slider_index').append('<li data-target="#carousel1" data-slide-to="'+i+'"></li>');
            $('#slider_image').append('<div class="item"><img src="'+sliderList[i].path+'" ></div>');
		}
	}
}
/**
 * 置书法数据
 */
 
function setCalligraphyData(dataList){
	 $('[name="calligraphy_title"]').each(function(index, obj){
	 	$(obj).html(dataList[index].title);
	 	$($('[name="calligraphy_path"]')[index]).attr('src', dataList[index].path);
	 	$($('[name="calligraphy_description"]')[index]).html(dataList[index].description);
	 	$($('[name="calligraphy_url"]')[index]).attr('href','/calligraphy/'+dataList[index].id);
	 });
}
 
/**
 * 置绘画数据
 */
 
function setPaintingData(dataList){
    for(let i = 0; i < dataList.length; i++){
        $('#contemporary_painting').append('<div class="col-lg-4"> <figure class="effect-roxy">' +
            ' 	<img src="'+dataList[i].path+'" />' +
            ' <figcaption><h2>'+dataList[i].title+'</h2>' +
            ' <p>'+dataList[i].description+'</p>' +
            ' <a href="/painting/'+dataList[i].id+'">View more</a> </figcaption></figure>' +
            '</div>');
    }
}

/**
 * 置展厅数据
 */
 
function setGalleryData(dataList){
    $('[name="gallery_title"]').each(function(index, obj){
        $(obj).html(dataList[index].title);
        $($('[name="gallery_thumb"]')[index]).attr('src', dataList[index].thumb);
        $($('[name="gallery_description"]')[index]).html(dataList[index].description);
        $($('[name="gallery_url"]')[index]).attr('href', '/show/'+dataList[index].id);
    });
}
/**
 * 竞拍数据
 */
function setAuctionData(datas){
	
}

/**
 * 置新闻数据
 */
 
function setNewsData(dataList){
    $('[name="news_thumb"]').each(function(index, obj){
        $(obj).attr('src', dataList[index].thumb);
        $($('[name="news_title"]')[index]).html(dataList[index].title);
        $($('[name="news_url"]')[index]).attr('href','/news/'+dataList[index].id);
    });
}

function doLogin() {
    let username = $('#l_username').val();
    let password = $('#l_password').val();
    if(username !== null && username !== ''
        && password !== null && password !== ''){
        //do something
        $.ajax({
			url:'/api/user/login',
			method:'post',
			data:{
				username:username,
				password:password
			},
			dataType:'json',
			success:function (response) {
				if(response.code === 200){
                    layer.msg('登陆成功', {icon: 1}, function () {
						window.location.reload();
                    });
				}else{
                    layer.msg(response.errMsg, {icon: 2});
				}
            },
			error:function () {
                layer.msg('登陆失败', {icon: 2});
            }
        });
    }
}
function doRegister() {
    let username = $('#reg_username').val();
    let password = $('#reg_password').val();
    let email = $('#reg_email').val();
    let phone = $('#reg_phone').val();
    let type = $('input[name="reg_type"]:checked').val();
    if(username !== null && username !== ''
        && password !== null && password !== ''){
        //do something
        $.ajax({
            url:'/api/user/register',
            method:'post',
            data:{
                username:username,
                password:password,
                email:email,
                phone:phone,
                type:type
            },
            dataType:'json',
            success:function (response) {
                if(response.code === 200){
                    layer.msg('注册成功', {icon: 1}, function () {
                        window.location.reload();
                    });
                }else{
                    layer.msg(response.errMsg, {icon: 2});
                }
            },
            error:function () {
                layer.msg('注册失败', {icon: 2});
            }
        });
    }
}