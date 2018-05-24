var things;
var books;
var pageNumber;
$(function () {
	findOwnerList(1);
	findThingList(1);
});

function findOwnerList(n){
    var $oResultBox1 = $('#lostListDeatil');
    $oResultBox1.empty();
    pageNumber = n;
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
        //alert(JSON.stringify(data));
        //alert(JSON.stringify(resData));
        //alert(resData[0].role)
        if (res === "success") {
            books = resData;
            for (var i = 0; i < 3; i++) {
                //var num = (number - 1) * 5 + i;
                var num = i;
                var roletype;
                if(books[num].role == 0){
                    roletype = '普通用户';
                }else if(books[num].role == 1){
                    roletype = '管理员';
                }

                var create_div = $('<button class="lostListBox" onClick="findOwner('+num+','+pageNumber+')"></button>');
                var _html = '<div class="list-group-item lostList"><h4 class="list-group-item-heading fl lostListHead"><img src="'+ books[num].pictureUrl +'" alt=""></h4><div class="list-group-item-text fl lostListDesc"><h2 class="fabuTitlt">'+ books[num].title +'</h2><br><span>失物类型：&nbsp;</span><span>失物招领</span><br><span>发布者：&nbsp;</span><span class="fabuPerson">'+ books[num].username +'</span><br><span>发布者身份：&nbsp;</span><span class="fabuType">'+ roletype +'</span><br><span>发布时间：&nbsp;</span><span class="fabuTime">'+ formatDateTime(books[num].createTime) +'</span><br><span>发布地点：&nbsp;</span><span class="fabuLocation">'+ books[num].foundAddress +'</span></div><div class="list-group-item-text fl clickNum"><p><span class="time">'+ formatDateTime(books[num].createTime) +'</span>&nbsp;&nbsp;查阅数： <span class="checkNum">'+ books[num].clickNum +'</span></p><br><br><p><button id="'+ num +'" disabled="true"></button></p><br><br><p>了解详情 &nbsp;&nbsp;&gt;&gt;</p></div></div>';

                create_div.html(_html).addClass('animated fadeIn');
                $oResultBox1.append(create_div);
            };
            for (var j = 0; j < 3; j++) {
                //var num = (n - 1) * 5 + i;
                var num = j;
                var state = books[num].state;
                var btns = document.getElementById(num);
                //console.log(state);
                if(state === 2){
                    btns.innerHTML = "招领成功";
                    btns.setAttribute("class","btn btn-lg btn-warning");
                }else if(state === 1){
                    btns.innerHTML = "招领中…";
                    btns.setAttribute("class","btn btn-lg btn-danger");
                }
            }
        }
    }, 'json');
};
function findThingList(n){
	var $oResultBox2 = $('#findListDeatil');
    $oResultBox2.empty();
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
        //alert(JSON.stringify(data));
        var res = data.result;
        var resData = data.data.lostList;
        //alert(resData.username);
        if (res === "success") {
            things = resData;
            //alert(findOwner);
            for (var i = 3; i < 6; i++) {
                var num = i - 3;
                var roletype;
                if(things[num].role == 0){
                    roletype = '普通用户';
                }else if(things[num].role == 1){
                    roletype = '管理员';
                }

                var create_div = $('<button class="lostListBox" onClick="findThing('+ num +','+pageNumber+');"></button>');
                var _html = '<div class="list-group-item lostList"><h4 class="list-group-item-heading fl lostListHead"><img src="'+ things[num].pictureUrl +'" alt=""></h4><div class="list-group-item-text fl lostListDesc"><h2 class="fabuTitlt">'+ things[num].title +'</h2><br><span>失物类型：&nbsp;</span><span>寻物启事</span><br><span>发布者：&nbsp;</span><span class="fabuPerson">'+ things[num].username +'</span><br><span>发布者身份：&nbsp;</span><span class="fabuType">'+ roletype +'</span><br><span>发布时间：&nbsp;</span><span class="fabuTime">'+ formatDateTime(things[num].createTime) +'</span><br><span>发布地点：&nbsp;</span><span class="fabuLocation">'+ things[num].lostAddress +'</span></div><div class="list-group-item-text fl clickNum"><p><span class="time">'+ formatDateTime(things[num].createTime) +'</span>&nbsp;&nbsp;查阅数： <span class="checkNum">'+ things[num].clickNum +'</span></p><br><br><p><button id="'+ i +'" disabled="true"></button></p><br><br><p>了解详情 &nbsp;&nbsp;&gt;&gt;</p></div></div>';

                create_div.html(_html).addClass('animated fadeIn');
                $oResultBox2.append(create_div);
            }
            for (var j = 3; j < 6; j++) {
                var num1 = j - 3;
                var btnstate = things[num1].state;
                var obtns = document.getElementById(j);
                //console.log(state);
                if(btnstate === 2){
                    obtns.innerHTML = "寻找成功";
                    obtns.setAttribute("class","btn btn-lg btn-warning");
                }else if(btnstate === 1){
                    obtns.innerHTML = "寻找中…";
                    obtns.setAttribute("class","btn btn-lg btn-danger");
                }
            }
        }
    }, 'json');

}

function findOwner(p,pageNum){
    setCookie('infoFindOwnerNum',p);//记录是从哪个失物招领列表跳转进来的
    setCookie('currentPageNum',pageNum);//记录是从哪个分页数据跳转进来的
	location.href = "1findOwner_detail.html";
}

function findThing(p,pageNum){
	setCookie('infoFindThingNum',p);//记录是从哪个寻物启事列表跳转进来的
    setCookie('currentThingsPageNum',pageNum);//记录是从哪个分页数据跳转进来的
	location.href = "2findThing_detail.html";
}