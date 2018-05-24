var user = getCookie('userInformation');//用户的基本信息；
//alert(user);
var userInfoRes = JSON.parse(user);
if(user.length>0){
    $('.btnBox').hide();
    $('.userInfo').show();
    $('#userName').html(userInfoRes.username);
	//alert(userInfoRes.username+userInfoRes.role);
    if(userInfoRes.role == 0){
        $('#normal').attr('checked','checked');
        $('#manager').attr('disabled','true');
        $('#userName').parent('a').attr('href','8userManage.html');
	}else if(userInfoRes.role == 1){
        $('#manager').attr('checked','checked');
        $('#normal').attr('disabled','true');
        $('#userName').parent('a').attr('href','9manager.html');
	}
	$('#fabuPerson').attr({'placeholder':userInfoRes.username,'disabled':'true'});
}

//设置AJAX的全局默认选项
$.ajaxSetup( {
    xhrFields: {
        withCredentials: true
    },
    crossDomain: true,
    async:true,// 默认异步加载
    error: function(jqXHR, textStatus, errorMsg){ // 出错时默认的处理函数
        // jqXHR 是经过jQuery封装的XMLHttpRequest对象
        // textStatus 可能为： null、"timeout"、"error"、"abort"或"parsererror"
        // errorMsg 可能为： "Not Found"、"Internal Server Error"等

        // 提示形如：发送AJAX请求到"/index.html"时出错[404]：Not Found
        alert( '发送AJAX请求到"' + this.url + '"时出错[' + jqXHR.status + ']：' + errorMsg );
    }
} );

//用户退出
function exit(){
    $.ajax({
        url: 'http://119.29.102.236/user/logout',
        type: 'get',
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
                location.href = '02denglu.html';
                $('.btnBox').show();
                $('.userInfo').hide();
            } else if (res === "fail") {
                alert(resData);
            }
        }
    });
}

//学院的遍历
var erjixueyuanData = ["电子与信息学院","机电学院","计算机科学学院","汽车与交通工程学院","自动化学院","光电工程学院","数学与系统科学学院","教育科学与技术学院","财经学院","法学与知识产权学院","管理学院","外国语学院","文学与传媒学院","美术学院","音乐学院","民族学院","马克思主义学院","国际教育学院","教师培训与继续教育学院","创新创业学院","广东工业实训中心","体育部"];
$(document).ready(function() {
    for(var i = 0; i < erjixueyuanData.length; i ++){
        //动态添加option
        $("#erjixueyuan").append("<option value='"+erjixueyuanData[i]+"'>"+erjixueyuanData[i]+"</option>");

    }
});
