var $oResultBox = $('#listDeatil');
var pageNumber;
let thanksLetterData;
function thinkLetterDatas(n) {
    $oResultBox.empty();
    pageNumber = n;
    //alert(pageNumber);
    //alert(number);
    var url = "http://119.29.102.236/thanks/getAll";
    var param = {}; // 组装发送参数
    param['currentPage'] = n;
    param['pageSize'] = 5;
    //alert(JSON.stringify(param));
    $.get(url, param, function (data) {
        // 发送并显示返回内容
        //res = JSON.stringify(data.result);
        var res = data.result;
        var resData = data.data;
        // alert(JSON.stringify(resData));
        if (res === "success") {
            thanksLetterData = resData;
            createDiv(pageNumber);
        }
        else if(res === "fail"){
            alert(resData);
        }
    }, 'json');
}

