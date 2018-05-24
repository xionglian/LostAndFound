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
//搜索框搜索
function findThingSearch01(){
    //alert('search');
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
        var resData = data.data.lostList;
        if(resData.length>0){
            if (res === "success") {
                findThing = resData;
                $oResultBox.empty();
                //alert(findOwner);
                createDiv(1);
                $('#paging').hide();
            }
        }else{
            alert('没有关键词为：“'+searchWord+'”的数据')
            window.reload();
        }
    }, 'json');
}
//校区搜索
function findThingSearch02(){
    //alert('search');
    var searchWord = $('#adress').val();
    var url = "http://119.29.102.236/search";
    var param = {}; // 组装发送参数
    param['keyword'] = searchWord;
    param['address'] = searchWord;
    //alert(JSON.stringify(param));
    $.get(url, param, function (data) {
        // 发送并显示返回内容
        //res = JSON.stringify(data.result);
        var res = data.result;
        var resData = data.data.lostList;
        if(resData.length>0){
            if (res === "success") {
                findThing = resData;
                $oResultBox.empty();
                //alert(findOwner);
                createDiv(1);
                $('#paging').hide();
            }
        }else{
            alert('没有关键词为：“'+searchWord+'”的数据')
            window.reload();
        }
    }, 'json');
}
