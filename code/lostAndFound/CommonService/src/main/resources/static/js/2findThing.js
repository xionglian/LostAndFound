function createDiv(pageNumber){
    var things = findThing;
    for (var i = 0; i < 5; i++) {
        //var num = (number - 1) * 5 + i;
        var num = i;
        var roletype;
        if(things[num].role == 0){
            roletype = '普通用户';
        }else if(things[num].role == 1){
            roletype = '管理员';
        }
        var create_div = $('<button class="lostListBox" onClick="turnTo('+num+','+pageNumber+')"></button>');
        var _html = '<div class="list-group-item lostList"><h4 class="list-group-item-heading fl lostListHead"><img src="'+ things[num].pictureUrl +'" alt=""></h4><div class="list-group-item-text fl lostListDesc"><h2 class="fabuTitlt">'+ things[num].title +'</h2><br><span>失物类型：&nbsp;</span><span>寻物启事</span><br><span>发布者：&nbsp;</span><span class="fabuPerson">'+ things[num].username +'</span><br><span>发布者身份：&nbsp;</span><span class="fabuType">'+ roletype +'</span><br><span>发布时间：&nbsp;</span><span class="fabuTime">'+ formatDateTime(things[num].createTime) +'</span><br><span>发布地点：&nbsp;</span><span class="fabuLocation">'+ things[num].lostAddress +'</span></div><div class="list-group-item-text fl clickNum"><p><span class="time">'+ formatDateTime(things[num].createTime) +'</span>&nbsp;&nbsp;查阅数： <span class="checkNum">'+ things[num].clickNum +'</span></p><br><br><p><button id="'+ i +'" disabled="true"></button></p><br><br><p>了解详情 &nbsp;&nbsp;&gt;&gt;</p></div></div>';

        create_div.html(_html).addClass('animated fadeIn');
        $oResultBox.append(create_div);
    };
    for (var i = 0; i < 5; i++) {
        var num = i;
		var state = things[num].state;
		var btns = document.getElementById(num);
		//console.log(state);
		if(state === 2){
			btns.innerHTML = "寻找成功";
			btns.setAttribute("class","btn btn-lg btn-warning");
		}else if(state === 1){
			btns.innerHTML = "寻找中…";
			btns.setAttribute("class","btn btn-lg btn-danger");
		}
    };
};

function prevPage(){
    pageNumber = pageNumber-1;
    if(pageNumber<1){
        number = 1;
        findThingDatas(pageNumber);
    }else{
        findThingDatas(pageNumber);
    }
}
function nextPage(){
    pageNumber=pageNumber+1;
    //alert(pageNumber);
    findThingDatas(pageNumber);
}
function turnTo(p,pageNumber){
	setCookie('infoFindThingNum',p);//记录是从哪个寻物启事列表跳转进来的
    setCookie('currentThingsPageNum',pageNumber);//记录是第几页分页的记录
    location.href = "2findThing_detail.html";
}