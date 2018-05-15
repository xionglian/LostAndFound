var erjixueyuanData = ["电子与信息学院","机电学院","计算机科学学院","汽车与交通工程学院","自动化学院","光电工程学院","数学与系统科学学院","教育科学与技术学院","财经学院","法学与知识产权学院","管理学院","外国语学院","文学与传媒学院","美术学院","音乐学院","民族学院","马克思主义学院","国际教育学院","教师培训与继续教育学院","创新创业学院","广东工业实训中心","体育部"];    
$(document).ready(function() {
    for(var i = 0; i < erjixueyuanData.length; i ++){	
		//动态添加option  
		$("#erjixueyuan").append("<option value='"+erjixueyuanData[i]+"'>"+erjixueyuanData[i]+"</option>"); 
		
	}
});

var res;
function submit(){
    //alert('提交');
    var $loginname = $('#loginname').val();
    var $username = $('#username').val();
    var $psw = $('#password').val();
    var $repsw = $('#repassword').val();
    var $userImg = $('#userImg').val();
    var $role = $('input:radio[name="role"]:checked').val();
    var $sex = $('input:radio[name="male"]:checked').val();
    var $schoolLocation = $('#schoolLocation').val();
    var $secondSchool = $('#erjixueyuan').val();
    var $class = $('#classes').val();
    var $contactWay = $('#contact').val();
    var $qq = $('#qq').val();
    var $eMail = $('#email').val();
    var $server = $('#server');
    var $submit = $('#submit');
    //alert($loginname+$username+$psw+$repsw+$userImg+$role+$sex+$schoolLocation+$secondSchool+$class+$contactWay)
    $.ajax({
        type:'post',
        url:'http://119.29.102.236/user/register',
        data:JSON.stringify({
            "loginName":$loginname,
            "username":$username,
            "password":$psw,
            "role":$role,
            "sex":$sex,
            "schoolLocation":$schoolLocation,
            "secondSchool":$secondSchool,
            "userClass":$class,
            "tel":$contactWay,
            "qq":$qq,
            "mail":$eMail,
            "userImg":$userImg
        }),
        dataType:'json',
        contentType:'application/json; charset=utf-8',
        beforeSend:function(){
//                        判断用户名是否为空
            if(!$loginname){
                alert('登录用户名不能为空，且必须由字母组成，请输入您的登录用户名');
                return false;
            }
            if(!$username){
                alert('用户名不能为空，请输入您的用户名');
                return false;
            }
//                        判断密码是否为空
            if(!$psw){
                $('#password').attr('placeholder','密码不能为空，请输入您的密码');
                alert('密码不能为空，请输入您的密码');
                return false;
            }
//                        判断两次密码是否一致
            if($psw != $repsw){
                alert('输入的密码不一致，请输入正确的密码');
                return false;
            }
//                        判断确认密码是否为空
            if(!$repsw){
                alert('确认密码不能为空，请输入您的确认密码');
                return false;
            }
            //判断班级不能为空
            if(!$class){
                alert('班级信息不能为空，请填写班级信息');
                return false;
            }
            //联系方式不能为空
            if(!$contactWay){
                alert('联系方式不能为空，请填写联系方式');
                return false;
            }
            //     手机号为11位，以1开头，第二位为3,5,7,8，后9位都是数字
            if(!/^1[3,5,7,8]\d{9}$/.test($contactWay)){
                alert('请输入正确的手机号');
                return false;
            }
            //服务协议是否打钩
            if(!$server.is(':checked')){
                alert('请仔细阅读用户协议，并勾选“我已阅读并完全同意服务协议”');
                return false;
            }
//                        判断$submit按钮是否有disabled属性，如果没有添加属性，如果有结束执行
            if($submit.hasClass('disabled')){
                return false;
            }
            $submit.val('正在注册').addClass('disabled');
        },
        success:function(data){
            //alert(JSON.stringify(data.result));
            res = JSON.stringify(data.result);
            if(res == "success"){
                alert('注册成功，欢迎您成为我们校园失物信息共享平台的一员！请开始您的参观之旅吧');
                location.href = '02denglu.html';
            }else{
                alert('不好意思，注册失败了！请稍候再进行注册，对您造成的不便之处，烦请谅解，谢谢配合！')
            }
        },
        error:function(){
            alert('请求不成功');
        }
    })
    /*//成功后的处理函数,res为服务器返回的数据
    .done(function(res) {
        alert("success");
    })
    //失败后的处理函数
    .fail(function(res) {
        alert("error");
        //console.log(res);
    })
    //结束后的处理函数，不管成功失败都执行
    .always(function(res) {
        alert("complete");
    });*/
};

