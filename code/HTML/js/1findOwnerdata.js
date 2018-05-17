var $oResultBox = $('#listDeatil');
var pageNumber;
let findOwner;
function findOwnerDatas(n) {
    $oResultBox.empty();
    pageNumber = n;
    //alert(pageNumber);
    //alert(number);
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
        alert(JSON.stringify(resData));
        if (res === "success") {
            findOwner = resData;
            //alert(findOwner);
            createDiv(pageNumber);
        }
    }, 'json');
}


$('.search button').click(function(){
    alert('search');
    var searchWord = $('.search .form-control').val();
    var url = "http://119.29.102.236/search";
    var param = {}; // 组装发送参数
    param['keyword'] = searchWord;
    param['address'] = searchWord;
    //alert(JSON.stringify(param));
    $.get(url, param, function (data) {
        // 发送并显示返回内容
        //res = JSON.stringify(data.result);
        var res = data.result;
        var resData = data.data.foundList;
        alert(JSON.stringify(resData));
        if (res === "success") {
            findOwner = resData;
            $oResultBox.empty();
            //alert(findOwner);
            createDiv(1);
            $('#paging').hide();

        }
    }, 'json');
})



