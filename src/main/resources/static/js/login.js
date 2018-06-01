function login() {
    $('#login').css('display', 'block');
}
function closelogin() {
    $('#login').css('display', 'none');
}
function register() {
    $('#register').css('display', 'block');
}

function closeregister() {
    $('#register').css('display', 'none');
}
function certification() {
    $('#certification').css('display', 'block');
}

function closecertification() {
    $('#certification').css('display', 'none');
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
                    layer.msg('登录成功', {icon: 1}, function () {
                        window.location.reload();
                    });
                }else{
                    layer.msg(response.errMsg, {icon: 2});
                }
            },
            error:function () {
                layer.msg('登录失败', {icon: 2});
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