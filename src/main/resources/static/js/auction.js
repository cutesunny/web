/**
 * Created by xuanxin on 2018/5/18.
 */

$('#order').click(function () {
    $.ajax({
        url:baseUrl+"/api/auction/order",
        method:"post",
        data:{
            id:id
        },
        dataType:"json",
        success:function (response) {
            if(response.code === 200){
                layer.msg('竞拍成功', {icon: 1}, function () {
                    window.location.reload();
                });
            }else{
                layer.msg(response.errMsg, {icon: 2});
            }
        },
        error:function () {
            layer.msg('网络繁忙', {icon: 2});
        }
    });
});

function onMove(obj){
    $('#img1').attr('src', $(obj).attr('src'));
}

smallBox.onmouseover = function() {
    imgBox.src = img1.src;
    floatBox.style.display = "block";
    bigBox.style.display = "block";
}
smallBox.onmouseout = function() {
    floatBox.style.display = "none";
    bigBox.style.display = "none";
}
smallBox.onmousemove = function(e) {
    var event = e || window.event;
    var left = event.clientX - smallBox.offsetLeft - floatBox.offsetWidth / 2;
    var top = event.clientY - smallBox.offsetTop - floatBox.offsetHeight / 2;
    if(left < 0) left = 0;
    else {
        if(left > (smallBox.offsetWidth - floatBox.offsetWidth))
            left = smallBox.offsetWidth - floatBox.offsetWidth;
    }
    if(top < 0) top = 0;
    else {
        if(top > (smallBox.offsetHeight - floatBox.offsetHeight))
            top = smallBox.offsetHeight - floatBox.offsetHeight;
    }
    floatBox.style.left = left + "px";
    floatBox.style.top = top + "px";
    imgBox.style.left = -(left * imgBox.offsetWidth) / smallBox.offsetWidth + "px";
    imgBox.style.top = -(top * imgBox.offsetHeight) / smallBox.offsetHeight + "px";

}
$(function() {
    $('#collapseFour').collapse({
        toggle: false
    })
});
$(function() {
    $('#collapseOne').collapse('show')
});
$(function() {
    $('#collapseThree').collapse('toggle')
});
$(function() {
    $('#collapseTwo').collapse('hide')
});
var key = false;

/*			function removeBoder() {
 shufa1.style.border = "none";
 shufa2.style.border = "none";
 shufa3.style.border = "none";
 shufa4.style.border = "none";
 shufa5.style.border = "none";
 }*/

function tan() {
    if(key) {} else {
        chose.innerHTML = "请选择";
        icon.style.border = "1px solid red";
    }
}
var select = false;

/*			shufa1.onclick = function() {
 select = DoSelect("shufa1", select);
 }
 shufa2.onclick = function() {
 select = DoSelect("shufa2", select);
 }
 shufa3.onclick = function() {

 select = DoSelect("shufa3", select);
 }
 shufa4.onclick = function() {

 select = DoSelect("shufa4", select);
 }
 shufa5.onclick = function() {
 select = DoSelect("shufa5", select);
 }*/
var oldId;
$(document).ready(function() {
    //获得文本框对象
    var t = $("#text_box");
    //初始化数量为1,并失效减
    $('#min').attr('disabled', true);
    //数量增加操作
    $("#add").click(function() {
        // 给获取的val加上绝对值，避免出现负数
        t.val(Math.abs(parseInt(t.val())) + 1);
        if(parseInt(t.val()) != 1) {
            $('#min').attr('disabled', false);
        };
    })
    //数量减少操作
    $("#min").click(function() {
        t.val(Math.abs(parseInt(t.val())) - 1);
        if(parseInt(t.val()) == 1) {
            $('#min').attr('disabled', true);
        };
    })
});
function click1() {
    var goods = document.getElementById('goods-details');
    var record = document.getElementById('record');
    var service = document.getElementById('service');
    var know = document.getElementById('know');
    goods.style.display = "block";
    record.style.display = "none";
    service.style.display = "none";
    know.style.display = "none";
}

function click2() {
    var goods = document.getElementById('goods-details');
    var record = document.getElementById('record');
    var service = document.getElementById('service');
    var know = document.getElementById('know');
    goods.style.display = "none";
    record.style.display = "block";
    service.style.display = "none";
    know.style.display = "none";
}

function click3() {
    var goods = document.getElementById('goods-details');
    var record = document.getElementById('record');
    var service = document.getElementById('service');
    var know = document.getElementById('know');
    goods.style.display = "none";
    record.style.display = "none";
    service.style.display = "block";
    know.style.display = "none";
}
function click4() {
    var goods = document.getElementById('goods-details');
    var record = document.getElementById('record');
    var service = document.getElementById('service');
    var know = document.getElementById('know');
    goods.style.display = "none";
    record.style.display = "none";
    service.style.display = "none";
    know.style.display = "block";
}
onload = function () {
    function removeActiveClass(node) {
        node.className = '';
    }

    document.querySelector('ul[id=style1]').onclick = function (e) {
        Array.prototype.forEach.call(document.querySelectorAll('ul[id=style1] > li'), removeActiveClass);
        var target = e.target;
        target.className = 'li-active';
    }
}