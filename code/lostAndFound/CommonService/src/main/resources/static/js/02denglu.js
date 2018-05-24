var $username;
var $psw;
var $role;
var res;
var resData;
function login() {
    $username = $('#loginName').val();
    $role = $('input:radio[name="role"]:checked').val();
    var loginUrl = "http://119.29.102.236/user/isRegistered";
    var param = {}; // 组装发送参数
    param['loginName'] = $username;
    param['role'] = $role;
    //alert(JSON.stringify(param));
    $.ajax({
        url: loginUrl,
        type: 'get',
        data: param,
        dataType:'json',
        contentType:'application/json; charset=utf-8',
        xhrFields: {
            withCredentials: true
        },
        crossDomain: true,
        async:true,
        beforeSend: function(){
            if(!$username){
                alert('登录名不能为空，请输入登录名');
            }
            if(!$role){
                alert('请选择登录角色');
            }
        },
        success: function(data){
            res = data.result;
            resData = JSON.stringify(data.data);
            //alert(res+resData);
            if (res === "success") {
                if (resData == "true") {
                    realLogin();
                } else {
                    alert('未注册，请先注册再登录');
                    location.href = '01zhuce.html';
                }
            } else if(res == 'fail') {
                alert(resData);
            }
        }
    });
    /*$.get(loginUrl, param, function (data) {
        // 发送并显示返回内容
        //res = JSON.stringify(data.result);
        res = data.result;
        resData = JSON.stringify(data.data);
        //alert(res+resData);
        if (res === "success") {
            if (resData == "true") {
                realLogin();
            } else {
                alert('未注册，请先注册再登录');
                location.href = '01zhuce.html';
            }
        } else if(res == 'fail') {
            alert(resData);
        }
    }, 'json');*/
}
function realLogin(){
    $username = $('#loginName').val();
    $psw = $('#password').val();
    $role = $('input:radio[name="role"]:checked').val();
    var url = "http://119.29.102.236/user/login";
    var arr = {}; // 组装发送参数
    arr['loginName'] = $username;
    arr['role'] = $role;
    arr['password'] = $psw;
    //alert(JSON.stringify(arr));
    $.ajax({
        url: url,
        type: 'get',
        data: arr,
        dataType:'json',
        contentType:'application/json; charset=utf-8',
        xhrFields: {
            withCredentials: true
        },
        crossDomain: true,
        async:true,
        success: function(data) {
            // 发送并显示返回内容
            res = data.result;
            resData = JSON.stringify(data.data);
            //alert(res);
            //alert(resData);
            if (res === "success") {
                setCookie('userInformation', resData);//传递登录用户的信息

                location.href = 'index.html';
            } else if (res === "fail") {
                alert(resData);
            }
        }
    });

    /*$.get(url, arr, function (data) {
        // 发送并显示返回内容
        res = data.result;
        resData = JSON.stringify(data.data);
        //alert(res);
        //alert(resData);
        if (res === "success") {
            setCookie('userInformation',resData);//传递登录用户的信息
            location.href = 'index.html';
        } else if(res === "fail") {
            alert(resData);
        }
    }, 'json');*/
}
function cancel(){
    $('input').val("");
}
