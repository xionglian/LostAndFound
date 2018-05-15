let findThing;
var $oResultBox = $('#listDeatil');
var pageNumber;
function findThingDatas(n) {
    $oResultBox.empty();
    pageNumber = n;
    //alert(pageNumber);
    //alert(number);
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
            findThing = resData;
            //alert(findOwner);
            createDiv(pageNumber);
        }
    }, 'json');
}


