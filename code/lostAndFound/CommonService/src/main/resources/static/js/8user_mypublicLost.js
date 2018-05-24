/*--------------侧边栏点击事件-------------*/
//修改密码
$('#section01').click(function(){
    $(this).addClass('act').siblings().removeClass('act');
    $('.aside_content .content').eq(1).addClass('current').siblings().removeClass('current');
    document.getElementById("erjixueyuan").selectedIndex = -1;
});
//查看我发布的失物招领
$('#section02').click(function(){
    $(this).addClass('act').siblings().removeClass('act');
    $('.aside_content .content').eq(2).addClass('current').siblings().removeClass('current');
    mypublicLost(1);
});
//查看我发布的寻物启事
$('#section03').click(function(){
    $(this).addClass('act').siblings().removeClass('act');
    $('.aside_content .content').eq(3).addClass('current').siblings().removeClass('current');
    mypublicFind(1);
});
//查看系统消息
$('#section04').click(function(){
    $(this).addClass('act').siblings().removeClass('act');
    $('.aside_content .content').eq(4).addClass('current').siblings().removeClass('current');
    sysInfo(1);
})


/*--------------点击后对应的响应函数-------------*/
//修改密码
function userChange(){
	var firstName = $('#firstname').val();
    var password = $('#password').val();
    var repassword = $('#repassword').val();
    var sex = $('input:radio[name="male"]:checked').val();
    var secSchool = $('#erjixueyuan').val();
    var classes = $('#classes').val();
    var phone = $('#contact').val();
    var email = $('#email').val();

    $.ajax({
        type:'post',
        url:'http://119.29.102.236/user/updateUser',
        data:JSON.stringify({
            "id":userInfoRes.id,
            "username":firstName,
            "password":repassword,
            "sex":sex,
            "secondSchool":secSchool,
            "userClass":classes,
            "tel":phone,
            "mail":email
        }),
        dataType:'json',
        contentType:'application/json; charset=utf-8',
        beforeSend:function(){
//                        判断两次密码是否一致
            if(password != repassword){
                alert('输入的密码不一致，请输入正确的密码');
                return false;
            }
            if(phone != ""){
                //     手机号为11位，以1开头，第二位为3,5,7,8，后9位都是数字
                if(!/^1[3,5,7,8]\d{9}$/.test(phone)){
                    alert('请输入正确的手机号');
                    return false;
                }
            }
        },
        success:function(data){
            res = data.result;
            if(res == "success"){
                alert('修改个人资料成功');
                setCookie('userInformation', data.data);//传递登录用户的信息
                document.URL=location.href;
            }else if(res == "fail"){
                alert(data.data);
            }
        }
    })

}

//查看我发布的失物招领
var FoundPageNum;
var FoundPageMax;
function mypublicLost(n){
    FoundPageNum = n;
    var mypublicLostList;
    var myPublicLostUrl = 'http://119.29.102.236/found/getAllByUser';
    var arr1 = {};
    arr1['currentPage'] = n;
    arr1['pageSize']= 6;
    $.get(myPublicLostUrl, arr1, function (data) {
        // 发送并显示返回内容
        // alert(JSON.stringify(data));
        var resData = data.data.foundList;
        var counts = data.data.count;
        FoundPageMax = Math.ceil(counts/arr1['pageSize']);
        if(FoundPageMax <= 1){
            $('#paging').hide();
        }else{
            $('#paging').show();
        }
        if (data.result === "success") {
            mypublicLostList = resData;
            $('#tab_Lost').empty();
            //alert(findOwner);
            if(counts > 0){
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
                    var _html = '<tr></tr><td>'+number+'</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>';
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
$('#paging .prev').click(function () {
    if (FoundPageNum > 1) {
        FoundPageNum = FoundPageNum - 1;
        mypublicLost(FoundPageNum);
    }else{
        mypublicLost(1);
    }
});
$('#paging .next').click(function () {
    if (FoundPageNum < FoundPageMax) {
        FoundPageNum = FoundPageNum + 1;
        mypublicLost(FoundPageNum);
    }else{
        mypublicLost(FoundPageMax);
    }
});
$('#paging .last').click(function () {
    mypublicLost(FoundPageMax);
});
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
var LostPageNum;
var LostPageMax;
function mypublicFind(n){
    LostPageNum = n
    var mypublicFindList;
    var myPublicFindUrl = 'http://119.29.102.236/lost/getAllByUser';
    var arr2 = {};
    arr2['currentPage'] = n;
    arr2['pageSize']= 5;
    $.get(myPublicFindUrl, arr2, function (data) {
        // 发送并显示返回内容
        resData = data.data.lostList;
        // alert(JSON.stringify(resData));
        var counts = data.data.count;
        LostPageMax = Math.ceil(counts/arr2['pageSize']);
        if(LostPageMax <= 1){
            $('#paging2').hide();
        }else{
            $('#paging2').show();
        }
        if (data.result === "success") {
            if(data.data.count > 0){
                mypublicFindList = resData;
                $('#tab_Find').empty();
                for (var i = 0; i < data.data.count; i++) {
                    var num = i;
                    var number = (n-1)*arr2['pageSize'] + (i+1);
                    var _html = '<tr><td>'+number+'</td><td>'+mypublicFindList[num].title+'</td><td>'+mypublicFindList[num].goodType+'</td><td>'+mypublicFindList[num].goodName+'</td><td>'+formatDateTime(mypublicFindList[num].createTime)+'</td><td><img src="'+mypublicFindList[num].pictureUrl+'" alt="" width="130" height="auto" </img></td><td><label><input type="radio" name="'+mypublicFindList[num].id+'" value="1"> 寻找中<br><input type="radio" name="'+mypublicFindList[num].id+'" value="2">寻找成功</label></td><td><button class="btn btn-primary" id="'+mypublicFindList[num].id+'" onclick="changeFindState('+mypublicFindList[num].id+')">修改状态</button></td></tr>';

                    $('#tab_Find').addClass('animated fadeIn');
                    $('#tab_Find').append(_html);

                    if(mypublicFindList[num].state == 1){
                        // alert(mypublicFindList[num].state);
                        $('input:radio[name='+ mypublicFindList[num].id +']').eq(0).attr('checked','checked');
                    }else if(mypublicFindList[num].state == 2){
                        $('input:radio[name='+ mypublicFindList[num].id +']').attr('disabled','true');
                        $('input:radio[name='+ mypublicFindList[num].id +']').eq(1).attr('checked','checked');
                        document.getElementById(mypublicFindList[num].id).setAttribute('disabled','disabled');
                    }
                }
            }
            else{
                for (var i = 0; i < 10; i++) {
                    var num = i;
                    var number = i+1;
                    var _html = '<tr></tr><td>'+number+'</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>';
                    $('#tab_Find').addClass('animated fadeIn');
                    $('#tab_Find').append(_html);
                }
                alert('您还没有任何发布失物招领的记录！');
            }
        }else{
            alert(resData);
        }
    }, 'json');
}
$('#paging2 .prev').click(function () {
    if (LostPageNum > 1) {
        LostPageNum = LostPageNum - 1;
        mypublicLost(LostPageNum);
    }else{
        mypublicLost(1);
    }
});
$('#paging2 .next').click(function () {
    if (LostPageNum < LostPageMax) {
        LostPageNum = LostPageNum + 1;
        mypublicLost(LostPageNum);
    }else{
        mypublicLost(LostPageMax);
    }
});
$('#paging2 .last').click(function () {
    mypublicLost(LostPageMax);
});
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
//查看系统消息
function sysInfo(n){
    var systemInfo;
    var systemInfoUrl = 'http://119.29.102.236/pushMessage/getAll';
    var arr3 = {};
    arr3['currentPage'] = n;
    arr3['pageSize']= 10;
    $.get(systemInfoUrl, arr3, function (data) {
        // 发送并显示返回内容
        res = data.result;
        resData = data.data;
        // alert(JSON.stringify(data));
        if (res === "success") {
            if(data.data.length > 0){
                $('#paging3').show();
                systemInfo = resData;
                $('#tab_inform').empty();
                //alert(findOwner);
                for (var i = 0; i < data.data.length; i++) {
                    var num = i;
                    var number = i+1;
                    var _html = '<td>'+number+'</td><td>\'+formatDateTime(systemInfo[num].receiveTime)+\'</td><td>'+systemInfo[num].informDetail+'</td><td><button class="btn btn-primary">删除</button></td>';

                    $('#tab_inform').addClass('animated fadeIn');
                    $('#tab_inform').append(_html);
                }
            }else{
                $('#paging3').hide()
                for (var i = 0; i < 10; i++) {
                    var num = i;
                    var number = num+1;
                    var _html = '<tr><td style="width:25px;">'+number+'</td><td></td><td></td><td></td></tr>';
                    $('#tab_inform').addClass('animated fadeIn');
                    $('#tab_inform').append(_html);
                }
            }
        }else{
            //alert(resData);
        }
    }, 'json');
}