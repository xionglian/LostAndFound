var num = getCookie('infoLetterNum');
var pageNum = getCookie('currentLetterPageNum');//记录是第几页分页的记录
var info;
window.onload = function(){	
	$('.fabuTitlt').html("");
	$('.fabuTime').html("");
	$('.checkNum').html("");
	$('#letterContent').html("");
	$('#luokuan').html("");
    thinkLetterDatas(pageNum);
};
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
        //alert(JSON.stringify(resData));
        if (res === "success") {
            info = resData;
            //alert(findOwner);
            $('.fabuTitlt').html(info[num].title);
            $('.fabuTime').html(formatDateTime(info[num].createTime));
            $('#letterContent').html(info[num].content);
            $('#luokuan').html(info[num].publisher);
        }
        else if(res === "fail"){
            alert(resData);
        }
    }, 'json');
}
