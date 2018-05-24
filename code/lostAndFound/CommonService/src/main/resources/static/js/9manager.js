/*-------------点击事件对于的响应函数--------------*/
//查看所有的失物招领信息
function allFindOwner(n){
    var findOwner;
    allFoundPageNum = n;
    var url = "http://119.29.102.236/found/getAll";
    var param = {}; // 组装发送参数
    param['currentPage'] = n;
    param['pageSize'] = 10;
    $.get(url, param, function (data) {
        //alert(JSON.stringify(data));
        var res = data.result;
        var resData = data.data.foundList;
        var counts = data.data.count;
        //alert(res+resData+counts)
        allFoundPageMax = Math.ceil(counts/param['pageSize']);
        if (res === "success") {
            $('#tab_allLost').empty();
            findOwner = resData;
            //alert(JSON.stringify(findOwner))
            for (var i = 0; i < param['pageSize']; i++) {
                var num = i;
                var number = (n-1) * param['pageSize'] + (i + 1);
                var thingState;
                if(findOwner[num].state == 2){
                    thingState = "认领成功";
                }else if(findOwner[num].state == 1){
                    thingState = "招领中";
                }
                var _html = '<tr><td>'+number+'</td><td>'+findOwner[num].title+'</td><td>'+findOwner[num].goodType+findOwner[num].goodName+'</td><td>'+formatDateTime(findOwner[num].createTime)+'</td><td>'+findOwner[num].foundAddress+'</td><td>'+findOwner[num].username+'</td><td></td><td>'+findOwner[num].linkPhone+'</td><td>'+thingState+'</td><td></td></tr>';

                $('#tab_allLost').addClass('animated fadeIn');
                $('#tab_allLost').append(_html);
            }

        }
    }, 'json');
}
function search01(){
    // alert('search');
    var school = $('#schoolLocation01').val();
    // var searchWord = $('#thingType').val()+$('#thingName').val();
    var url = "http://119.29.102.236/search";
    var param = {}; // 组装发送参数
    param['keyword'] = school;
    param['address'] = school;
    //alert(JSON.stringify(param));
    $.get(url, param, function (data) {
        var res = data.result;
        var resData = data.data.foundList;
        // console.log(JSON.stringify(resData));
        if (res === "success") {
            findOwner = resData;
            $('#tab_allLost').empty();
            $('#paging').hide();
            for (var i = 0; i < resData.length; i++) {
                var num = i;
                var number = i + 1;
                var thingState;
                if (findOwner[num].state == 2) {
                    thingState = "认领成功";
                } else if (findOwner[num].state == 1) {
                    thingState = "招领中";
                }
                var _html = '<tr><td>' + number + '</td><td>' + findOwner[num].title + '</td><td>' + findOwner[num].goodType + findOwner[num].goodName + '</td><td>' + formatDateTime(findOwner[num].createTime) + '</td><td>' + findOwner[num].foundAddress + '</td><td>' + findOwner[num].username + '</td><td></td><td>' + findOwner[num].linkPhone + '</td><td>' + thingState + '</td><td></td></tr>';

                $('#tab_allLost').addClass('animated fadeIn');
                $('#tab_allLost').append(_html);
            }
        }
    }, 'json');
}
//查看所有的寻物启事信息
function allFingThing(n){
    var findThing;
    allLostPageNum = n;
    var url = "http://119.29.102.236/lost/getAll";
    var param = {}; // 组装发送参数
    param['currentPage'] = n;
    param['pageSize'] = 6;
    $.get(url, param, function (data) {
       //alert(JSON.stringify(data));
        var res = data.result;
        var resData = data.data.lostList;
        var counts = resData.length;
        //alert(res+resData+counts)
        allLostPageMax = Math.ceil(counts/param['pageSize']);
        //alert(allLostPageMax);
        if (res === "success") {
            $('#tab_allFind').empty();
            findThing = resData;
            //alert(JSON.stringify(findOwner))
            for (var i = 0; i < param['pageSize']; i++) {
                var num = i;
                var number = (n-1) * param['pageSize'] + (i + 1);
                var thingState;
                if(findThing[num].state == 2){
                    thingState = "寻找成功";
                }else if(findThing[num].state == 1){
                    thingState = "寻找中";
                }
                var _html = '<tr><td>'+number+'</td><td>'+findThing[num].title+'</td><td>'+findThing[num].goodType+findThing[num].goodName+'</td><td>'+formatDateTime(findThing[num].createTime)+'</td><td>'+findThing[num].foundAddress+'</td><td>'+findThing[num].username+'</td><td>'+findThing[num].linkPhone+'</td><td>'+thingState+'</td><td></td></tr>';

                $('#tab_allFind').addClass('animated fadeIn');
                $('#tab_allFind').append(_html);
            }

        }
    }, 'json');
}
function search02(){
    // alert('search');
    var school = $('#schoolLocation02').val();
    // var searchWord = $('#thingType02').val()+$('#thingName02').val();
    var url = "http://119.29.102.236/search";
    var param = {}; // 组装发送参数
    param['keyword'] = school;
    param['address'] = school;
    //alert(JSON.stringify(param));
    $.get(url, param, function (data) {
        var res = data.result;
        var resData = data.data.lostList;
        console.log(JSON.stringify(resData));
        console.log(resData.length)
        if (res === "success") {
            findThing = resData;
            $('#tab_allFind').empty();
            $('#paging1').hide();
            for (var i = 0; i < resData.length; i++) {
                var num = i;
                var number = i + 1;
                var thingState;
                if(findThing[num].state == 2){
                    thingState = "寻找成功";
                }else if(findThing[num].state == 1){
                    thingState = "寻找中";
                }
                var _html = '<tr><td>'+number+'</td><td>'+findThing[num].title+'</td><td>'+findThing[num].goodType+findThing[num].goodName+'</td><td>'+formatDateTime(findThing[num].createTime)+'</td><td>'+findThing[num].foundAddress+'</td><td>'+findThing[num].username+'</td><td>'+findThing[num].linkPhone+'</td><td>'+thingState+'</td><td></td></tr>';

                $('#tab_allFind').addClass('animated fadeIn');
                $('#tab_allFind').append(_html);
            }
        }
    }, 'json');
}

//查看我发布的失物招领
function mypublicLost(n){
    var mypublicLostList;
    var myPublicLostUrl = 'http://119.29.102.236/found/getAllByUser';
    var arr1 = {};
    arr1['currentPage'] = n;
    arr1['pageSize']= 5;
    $.get(myPublicLostUrl, arr1, function (data) {
        // 发送并显示返回内容
        resData = data.data.foundList;
        if(data.data.count <= arr1['pageSize']){
            $('#paging4').hide();
        }else{
            $('#paging4').show();
        }
        //alert(JSON.stringify(data));
        if (data.result === "success") {
            mypublicLostList = resData;
            $('#tab_Lost').empty();
            //alert(findOwner);
            if(data.data.count > 0){
                for (var i = 0; i < data.data.count; i++) {
                    var num = i;
                    var number = i+1;
                    var _html = '<tr><td>'+number+'</td><td>'+mypublicLostList[num].title+'</td><td>'+mypublicLostList[num].goodType+'</td><td>'+mypublicLostList[num].goodName+'</td><td>'+formatDateTime(mypublicLostList[num].createTime)+'</td><td><img src="'+mypublicLostList[num].pictureUrl+'" alt="" width="130" height="auto" </img></td><td><label><input type="radio" name="'+mypublicLostList[num].id+'" value="1">招领中<br><input type="radio" name="'+mypublicLostList[num].id+'" value="2">招领成功</label></td><td><button class="btn btn-primary" id="'+mypublicLostList[num].id+'" onclick="changeLostState('+mypublicLostList[num].id+')">修改状态</button></td></tr>';

                    $('#tab_Lost').addClass('animated fadeIn');
                    $('#tab_Lost').append(_html);
                    if(mypublicLostList[num].state == 1){
                        // alert(mypublicFindList[num].state);
                        $('input:radio[name='+ mypublicLostList[num].id +']').eq(0).attr('checked','checked');
                    }else if(mypublicLostList[num].state == 2){
                        $('input:radio[name='+ mypublicLostList[num].id +']').attr('disabled','true');
                        $('input:radio[name='+ mypublicLostList[num].id +']').eq(1).attr('checked','checked');
                        document.getElementById(mypublicLostList[num].id).setAttribute('disabled','disabled');
                    }

                }
            }else{
                for (var i = 0; i < 10; i++) {
                    var num = i;
                    var number = i+1;
                    var _html = '<tr></tr><td>'+number+'</td><td></td><td></td><td></td><td></td><td></td><td></td></tr>';
                    $('#tab_Lost').addClass('animated fadeIn');
                    $('#tab_Lost').append(_html);
                }
                alert('您还没有任何发布失物招领的记录！');
            }
        } else{
            alert(resData);
        }
    }, 'json');
}
function changeLostState(p){
    var $id = p;
    $state = $('input:radio[name='+ p +']:checked').val();
    // alert($state);
    $.ajax({
        type:'post',
        url:'http://119.29.102.236/found/update',
        data:JSON.stringify({
            "id":$id,
            "state":$state,
        }),
        dataType:'json',
        contentType:'application/json; charset=utf-8',
        success:function(data){
            // alert(JSON.stringify(data));
            if(data.result == "success"){
                alert('修改失物招领的物品状态成功！')
            }else if(data.result === "fail"){
                alert(data.data)
            }
        }
    })

}

//查看我发布的寻物启事
function mypublicFind(n){
    var mypublicFindList;
    var myPublicFindUrl = 'http://119.29.102.236/lost/getAllByUser';
    var arr2 = {};
    arr2['currentPage'] = n;
    arr2['pageSize']= 10;
    $.get(myPublicFindUrl, arr2, function (data) {
        // 发送并显示返回内容
        resData = data.data.lostList;
        //alert(JSON.stringify(data));
        if (data.result === "success") {
            if(data.data.count > 0){
                mypublicFindList = resData;
                $('#tab_Find').empty();
                for (var i = 0; i < data.data.count; i++) {
                    var num = i;
                    var number = i+1;
                    var _html = '<tr><td>'+number+'</td><td>'+mypublicFindList[num].title+'</td><td>'+mypublicFindList[num].goodType+'</td><td>'+mypublicFindList[num].goodName+'</td><td>'+formatDateTime(mypublicFindList[num].createTime)+'</td><td><img src="'+mypublicFindList[num].pictureUrl+'" alt="" width="130" height="auto" </img></td><td><label><input type="radio" name="'+mypublicFindList[num].id+'" value="1"> 寻找中<br><input type="radio" name="'+mypublicFindList[num].id+'" value="2">寻找成功</label></td><td><button class="btn btn-primary" id="'+mypublicFindList[num].id+'" onclick="changeFindState('+mypublicFindList[num].id+')">修改状态</button></td></tr>';

                    $('#tab_Find').addClass('animated fadeIn');
                    $('#tab_Find').append(_html);
                    // alert(mypublicFindList[num].state);
                    if(mypublicFindList[num].state == 1){
                        $('input:radio[name='+ mypublicFindList[num].id +']').eq(0).attr('checked','checked');
                    }else if(mypublicFindList[num].state == 2){
                        $('input:radio[name='+ mypublicFindList[num].id +']').attr('disabled','true');
                        $('input:radio[name='+ mypublicFindList[num].id +']').eq(1).attr('checked','checked');
                        document.getElementById(mypublicFindList[num].id).setAttribute('disabled','disabled');
                    }

                }
            }else{
                for (var i = 0; i < 10; i++) {
                    var num = i;
                    var number = i+1;
                    var _html = '<tr></tr><td>'+number+'</td><td></td><td></td><td></td><td></td><td></td><td></td></tr>';
                    $('#tab_Find').addClass('animated fadeIn');
                    $('#tab_Find').append(_html);
                }
                alert('您还没有任何发布寻物启事的记录！');
            }
        }else{
            alert(resData);
        }
    }, 'json');
}
function changeFindState(p){
    var $id = p;
    $state = $('input:radio[name='+ p +']:checked').val();
    // alert($state);
    $.ajax({
        type:'post',
        url:'http://119.29.102.236/lost/update',
        data:JSON.stringify({
            "id":$id,
            "state":$state,
        }),
        dataType:'json',
        contentType:'application/json; charset=utf-8',
        success:function(data){
            // alert(JSON.stringify(data));
            if(data.result == "success"){
                alert('修改寻物启事的物品状态成功！')
            }else if(data.result === "fail"){
                alert(data.data)
            }
        }
    })

}

//查看所有的用户信息
function allUserInfo(n){
    userPageNum = n;
    var allUser;
    var allUserListUrl = "http://119.29.102.236/user/getAll";
    var param = {}; // 组装发送参数
    param['currentPage'] = n;
    param['pageSize'] = 8;
    $.get(allUserListUrl, param, function (data) {
        //console.log(JSON.stringify(data.data));
        var res = data.result;
        var resData = data.data.foundList;
        var counts = data.data.count;
        userPageMax = Math.ceil(counts/param['pageSize']);
        //alert(JSON.stringify(userPageMax));
        if (res === "success") {
            allUser = resData;
            $('#userTab_inform').empty();
            for (var i = 0; i < param['pageSize']; i++) {
                var num = i;
                var number = (n-1) * param['pageSize'] + (i + 1);
                var _html = '<tr><td>'+number+'</td><td>'+allUser[num].username+'</td><td>'+allUser[num].schoolLocation+'</td><td>'+allUser[num].secondSchool+'</td><td>'+allUser[num].userClass+'</td><td>'+allUser[num].tel+'</td><td>'+allUser[num].putFoundNum+'</td><td>'+allUser[num].putLostNum+'</td>';
                $('#userTab_inform').addClass('animated fadeIn');
                $('#userTab_inform').append(_html);
            }
        }
    }, 'json');
};
//增加管理员
var $loginname,$username,$psw,$repsw,$userImg,$contactWay,$schoolLocation,$secondSchool,$class;
function submit(){
    $loginname = $('#loginName').val();
    $username = $('#managerName').val();
    $psw = $('#password').val();
    $repsw = $('#repassword').val();
    $userImg = $('#userImg').val();
    $contactWay = $('#linkPhone').val();
    $schoolLocation = $('#schoolLocation').val();
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
                alert('管理员的登录名不能为空，且必须由字母组成，请输入您的登录用户名');
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
            if(!$userImg){
                alert('管理员头像不能为空');
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
            "role":1,
            "schoolLocation":$schoolLocation,
            "secondSchool":"广技师校学生自律委员会",
            "userClass":$schoolLocation+"自律会",
            "tel":$contactWay,
        }),
        dataType:'json',
        contentType:'application/json; charset=utf-8',
        success:function(data){
            //alert(JSON.stringify(data));
            if(data.result == "success"){
                if(data.data == true){
                    alert('添加管理员成功');
                    location.href = '9manager.html';
                }else{
                    alert(data.data)
                }
            }else if(data.result === "fail"){
                alert(data.data)
            }
        }
    })
}



/*------------点击侧边栏事件 ------------*/
//查看所有的失物招领
var allFoundPageNum;
var allFoundPageMax;
$('#section01').click(function(){
    $(this).addClass('act').siblings().removeClass('act');
    $('.aside_content .content').eq(1).addClass('current').siblings().removeClass('current');
    allFindOwner(1);
    $('#paging .prev').click(function () {
        if (allFoundPageNum > 1) {
            allFoundPageNum = allFoundPageNum - 1;
            allFindOwner(allFoundPageNum);
        }else{
            allFindOwner(1);
        }
    });
    $('#paging .next').click(function () {
        if (allFoundPageNum < allFoundPageMax) {
            allFoundPageNum = allFoundPageNum + 1;
            allFindOwner(allFoundPageNum);
        }else{
            allFindOwner(allFoundPageMax);
        }
    });
    $('#paging .last').click(function () {
        allFindOwner(allFoundPageMax);
    });

});

//查看所有的寻物启事
var allLostPageNum;
var allLostPageMax;
$('#section02').click(function(){
    $(this).addClass('act').siblings().removeClass('act');
    $('.aside_content .content').eq(2).addClass('current').siblings().removeClass('current');
    allFingThing(1);
});

//查看我发布的失物招领
$('#section03').click(function(){
    $(this).addClass('act').siblings().removeClass('act');
    $('.aside_content .content').eq(3).addClass('current').siblings().removeClass('current');
    mypublicLost(1);
});

//查看我发布的寻物启事
$('#section04').click(function(){
    $(this).addClass('act').siblings().removeClass('act');
    $('.aside_content .content').eq(4).addClass('current').siblings().removeClass('current');
    mypublicFind(1);
})

//查看所用的用户信息
var userPageNum;
var userPageMax;
$('#section05').click(function() {
    $(this).addClass('act').siblings().removeClass('act');
    $('.aside_content .content').eq(5).addClass('current').siblings().removeClass('current');
    allUserInfo(1);
    $('#paging3 .prev').click(function () {
        //alert(userPageMax);
        if (userPageNum > 1) {
            userPageNum = userPageNum - 1;
        }else{
            allUserInfo(1);
        }
    });
    $('#paging3 .next').click(function () {
        if (userPageNum < userPageMax) {
            userPageNum = userPageNum + 1;
            allUserInfo(userPageNum);
        }else{
            allUserInfo(userPageMax);
        }
    });
    $('#paging3 .last').click(function () {
        allUserInfo(userPageMax);
    });
});
//增加管理员
$('#section06').click(function(){
    $(this).addClass('act').siblings().removeClass('act');
    $('.aside_content .content').eq(6).addClass('current').siblings().removeClass('current');
});
