var erjixueyuanData = ["电子与信息学院","机电学院","计算机科学学院","汽车与交通工程学院","自动化学院","光电工程学院","数学与系统科学学院","教育科学与技术学院","财经学院","法学与知识产权学院","管理学院","外国语学院","文学与传媒学院","美术学院","音乐学院","民族学院","马克思主义学院","国际教育学院","教师培训与继续教育学院","创新创业学院","广东工业实训中心","体育部"];    
$(document).ready(function() {
    for(var i = 0; i < erjixueyuanData.length; i ++){	
		//动态添加option  
		$("#erjixueyuan").append("<option value='"+erjixueyuanData[i]+"'>"+erjixueyuanData[i]+"</option>"); 
		
	}
});
var $loginname,$username,$psw,$repsw,$userImg,$role,$sex,$schoolLocation,$secondSchool,$class,$contactWay,$qq,$eMail,$server,$submit ;

function submit(){
    $loginname = $('#loginname').val();
    $username = $('#username').val();
    $psw = $('#password').val();
    $repsw = $('#repassword').val();
    $userImg = $('#userImg').val();
    $role = $('input:radio[name="role"]:checked').val();
    $sex = $('input:radio[name="male"]:checked').val();
    $schoolLocation = $('#schoolLocation').val();
    $secondSchool = $('#erjixueyuan').val();
    $class = $('#classes').val();
    $contactWay = $('#contact').val();
    $qq = $('#qq').val();
    $eMail = $('#email').val();
    $server = $('#server');
    //alert('提交');
    //先上传图片
    //var formData = new FormData($('#uploadForm')[4]);
    var formData = new FormData(document.getElementById("uploadForm"));
    formData.append("uploadFile", $userImg);
    $.ajax({
        type: 'post',
        url: "http://119.29.102.236/File/uploadPhoto",
        data: formData,
        cache: false,
        processData: false,
        contentType: false,
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
            if(!($server.is(':checked'))){
                alert('请仔细阅读用户协议，并勾选“我已阅读并完全同意服务协议”');
                return false;
            }
        },
        success: function(data){
            if(data.result == 'success'){
                $userImg = data.data
                realSubmit();
            }
        }
    })
};

//再发布
function realSubmit(){
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
        success:function(data){
            //alert(JSON.stringify(data));
            if(data.result == "success"){
                if(data.data == true){
                    alert('注册成功，欢迎您成为我们校园失物信息共享平台的一员！请开始您的参观之旅吧');
                    location.href = '02denglu.html';
                }else{
                    alert(data.data)
                }
            }else if(data.result === "fail"){
                alert(data.data)
            }
        }
    })
}
