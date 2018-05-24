//alert(books);
function createDiv(pageNumber){
    var books = findOwner;
    for (var i = 0; i < 5; i++) {
        //var num = (number - 1) * 5 + i;
        var num = i;
        var roletype;
        if(books[num].role == 0){
            roletype = '普通用户';
        }else if(books[num].role == 1){
            roletype = '管理员';
        }
        var create_div = $('<button class="lostListBox" onClick="turnTo('+num+','+pageNumber+')"></button>');
        var _html = '<div class="list-group-item lostList"><h4 class="list-group-item-heading fl lostListHead"><img src="'+ books[num].pictureUrl +'" alt=""></h4><div class="list-group-item-text fl lostListDesc"><h2 class="fabuTitlt">'+ books[num].title +'</h2><br><span>失物类型：&nbsp;</span><span>失物招领</span><br><span>发布者：&nbsp;</span><span class="fabuPerson">'+ books[num].username +'</span><br><span>发布者身份：&nbsp;</span><span class="fabuType">'+ roletype +'</span><br><span>发布时间：&nbsp;</span><span class="fabuTime">'+ formatDateTime(books[num].createTime) +'</span><br><span>发布地点：&nbsp;</span><span class="fabuLocation">'+ books[num].foundAddress +'</span></div><div class="list-group-item-text fl clickNum"><p><span class="time">'+ formatDateTime(books[num].createTime) +'</span>&nbsp;&nbsp;查阅数： <span class="checkNum">'+ books[num].clickNum +'</span></p><br><br><p><button id="'+ num +'" disabled="true"></button></p><br><br><p>了解详情 &nbsp;&nbsp;&gt;&gt;</p></div></div>';

        create_div.html(_html).addClass('animated fadeIn');
        $oResultBox.append(create_div);
    };
   for (var i = 0; i < 5; i++) {
       //var num = (n - 1) * 5 + i;
       num = i;
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
};

function prevPage(){
    pageNumber = pageNumber-1;
    if(pageNumber<1){
        number = 1;
        findOwnerDatas(pageNumber);
    }else{
        findOwnerDatas(pageNumber);
    }
}
function nextPage(){
    pageNumber=pageNumber+1;
    //alert(pageNumber);
    findOwnerDatas(pageNumber);
}
function turnTo(p,pageNumber){
	//qext.LocalStorage.save(p);
    //alert(p);
	setCookie('infoFindOwnerNum',p);//记录是从哪个失物招领列表跳转进来的
    setCookie('currentPageNum',pageNumber);//记录是第几页分页的记录
	location.href = "1findOwner_detail.html";
}