$('.aside_navbar li').click(function(e) {
    var index = $(this).index()+1;
	$(this).addClass('act').siblings().removeClass('act');
	$('.aside_content .content').eq(index).addClass('current').siblings().removeClass('current');
});

$(function () {
    allFindOwner(1);
    allUserInfo();
});

//查看所有的用户信息
function allUserInfo(){
	var allUser;
    var allUserListUrl = "http://119.29.102.236/user/getAll";
    var param = {}; // 组装发送参数
    // param['keyword'] = searchWord;
    // param['address'] = searchWord;
    //alert(JSON.stringify(param));
    $.get(allUserListUrl, param, function (data) {
        // 发送并显示返回内容
        //res = JSON.stringify(data.result);
        var res = data.result;
        var resData = data.data;
        //alert(JSON.stringify(resData));
        if (res === "success") {
            allUser = resData;
            $('#userTab_inform').empty();
            alert(allUser);
            for (var i = 0; i < 10; i++) {
                var num = i;
                var number = i+1;
                var _html = '<tr><td>'+number+'</td><td>'+allUser[num].username+'</td><td>'+allUser[num].schoolLocation+'</td><td>'+allUser[num].secondSchool+'</td><td>'+allUser[num].userClass+'</td><td>'+allUser[num].tel+'</td><td>'+allUser[num].putFoundNum+'</td><td>'+allUser[num].putLostNum+'</td>';
                $('#userTab_inform').addClass('animated fadeIn');
                $('#userTab_inform').append(_html);
            }
        }}, 'json')
}

//查看所有的失物招领信息
function allFindOwner(n){
    var findOwner;
    var url = "http://119.29.102.236/found/getAll";
    var param = {}; // 组装发送参数
    param['currentPage'] = n;
    param['pageSize'] = 5;
    //alert(JSON.stringify(param));
    $.get(url, param, function (data) {
        // 发送并显示返回内容
        //res = JSON.stringify(data.result);
        var res = data.result;
        var resData = data.data.foundList;
        //alert(JSON.stringify(resData));
        if (res === "success") {
            $('#tab_allFind').empty();
            findOwner = resData;
            alert(findOwner);
            for (var i = 0; i < 10; i++) {
                var num = i;
                var number = i+1;
                var thingState;
                if(findOwner[num].state == 2){
                    thingState = "认领成功";
                }else if(findOwner[num].state == 1){
                    thingState = "招领中";
                }
                var _html = '<td>'+number+'</td><td>'+findOwner[num].title+'</td><td>'+findOwner[num].goodType+findOwner[num].goodName+'</td><td>'+formatDateTime(findOwner[num].createTime)+'</td><td>'+findOwner[num].foundAddress+'</td><td></td><td>'+findOwner[num].linkPhone+'</td><td>'+thingState+'</td><td></td>';

                $('#tab_inform').addClass('animated fadeIn');
                $('#tab_inform').append(_html);
            }

        }
    }, 'json');
}