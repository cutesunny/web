/**
 * 评论
 * Created by xuanxin on 2018/5/16.
 */

$('#comment').click(function () {
    let content = $('#content').val();
    $.ajax({
        url:baseUrl+'/api/comment',
        method:"post",
        dataType:"json",
        data:{
            materialId:materialId,
            type:type,
            star:5,
            content:content
        },
        success:function (response) {
            if(response.code === 200){
                layer.msg('发表成功', {icon: 1}, function () {
                    $('#content').val('');
                });
            }else{
                layer.msg(response.errMsg, {icon: 2});
            }
        },
        error:function () {
            layer.msg(response.errMsg, {icon: 2});
        }
    });
});