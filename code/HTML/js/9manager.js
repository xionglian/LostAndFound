/*-------------点击事件对于的响应函数--------------*/
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
//查看所有的失物招领信息
function allFindOwner(n){
    var findOwner;
    allFoundPageNum = n;
    var url = "http://119.29.102.236/found/getAll";
    var param = {}; // 组装发送参数
    param['currentPage'] = n;
    param['pageSize'] = 7;
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

//查看我发布的失物招领
function mypublicLost(n){
    var mypublicLostList;
    var myPublicLostUrl = 'http://119.29.102.236/found/getAllByUser';
    var arr1 = {};
    arr1['currentPage'] = n;
    arr1['pageSize']= 10;
    $.get(myPublicLostUrl, arr1, function (data) {
        // 发送并显示返回内容
        resData = data.data.foundList;
        //alert(JSON.stringify(data));
        if (data.result === "success") {
            mypublicLostList = resData;
            $('#tab_Lost').empty();
            //alert(findOwner);
            if(data.data.count > 0){
                for (var i = 0; i < data.data.count; i++) {
                    var num = i;
                    var number = i+1;
                    var _html = '<tr><td>'+number+'</td><td>'+mypublicLostList[num].title+'</td><td>'+mypublicLostList[num].goodType+'</td><td>'+mypublicLostList[num].goodName+'</td><td>'+formatDateTime(mypublicLostList[num].createTime)+'</td><td><img src="'+mypublicLostList[num].pictureUrl+'" alt="" width="130" height="auto" </img></td><td><label><input type="radio" name="lostState" value="1"> 招领中</label><br><label><input type="radio" name="lostState" value="2">认领成功</label></td>';

                    $('#tab_Lost').addClass('animated fadeIn');
                    $('#tab_Lost').append(_html);
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
                    var _html = '<tr><td>'+number+'</td><td>'+mypublicFindList[num].title+'</td><td>'+mypublicFindList[num].goodType+'</td><td>'+mypublicFindList[num].goodName+'</td><td>'+formatDateTime(mypublicFindList[num].createTime)+'</td><td><img src="\'+mypublicList[num].pictureUrl+\'" alt="" width="130" height="auto" </img></td><td><label><input type="radio" name="findState" value="1"> 招领中</label><br><label><input type="radio" name="findState" value="2">认领成功</label></td>';

                    $('#tab_Find').addClass('animated fadeIn');
                    $('#tab_Find').append(_html);
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
