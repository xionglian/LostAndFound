var num = getCookie('infoFindThingNum');
//alert(num);
var pageNum = getCookie('currentThingsPageNum');
//alert(pageNum);
var info;
$(document).ready(function(e) {
    findThingDatas(pageNum);
    $('.fabuTitlt').html("");
    $('.fabuTime').html("");
    $('.checkNum').html("");
    $('.fabuContact').html("");
    $('.fabuPerson').html("");
    $('#fabuPerson').html("");
    $('#thingsType').html("");
    $('#location').html("");
    $('#findPerson').html("");
    $('#contactNum').html("");
    $('#pickupTime').html("");
    $('#detailDesc').html("");
});
function findThingDatas(n) {
    var url = "http://119.29.102.236/lost/getAll";
    var param = {}; // 组装发送参数
    param['currentPage'] = n;
    param['pageSize'] = 5;
    //alert(JSON.stringify(param));
    $.get(url, param, function (data) {
        // 发送并显示返回内容
        //res = JSON.stringify(data.result);
        var res = data.result;
        var resData = data.data.lostList;
        //alert(JSON.stringify(resData));
        if (res === "success") {
            info = resData;
            //alert(info[num].title);
            detail();
        }
    }, 'json');
}
function detail(){
    var btns = document.getElementById('btnState');
    var state = info[num].state;

    if(state === 2){
        btns.innerHTML = "寻找成功";
        btns.setAttribute("class","btn btn-lg btn-warning");
    }else if(state === 1){
        btns.innerHTML = "寻找中…";
        btns.setAttribute("class","btn btn-lg btn-danger");
    }


    $('.fabuTitlt').html(info[num].title);
    $('.fabuTime').html(formatDateTime(info[num].create_time));
    $('.checkNum').html(info[num].click_num);
    $('.fabuContact').html(info[num].link_phone);
    $('.fabuPerson').html(info[num].link_name);
    $('#fabuPerson').html(userInfoRes.username);
    $('#thingsType').html(info[num].good_type);
    $('#tingsName').html(info[num].good_name);
    $('#keyWord').html(info[num].key_word01+'    '+info[num].key_word02+'    '+info[num].key_word03);
    $('#location').html(info[num].found_address+info[num].found_address_detail);
    $('#findPerson').html();

    $('#contactNum').html(info[num].link_phone);
    $('#pickupTime').html(formatDateTime(info[num].found_time));
    $('#thingsImage').attr('src',info[num].picture_url);
    $('#detailDesc').html(info[num].description_detail);
};

