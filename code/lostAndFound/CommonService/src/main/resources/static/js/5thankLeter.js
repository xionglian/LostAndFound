function createDiv(pageNumber){
    var books = thanksLetterData;
    for (var i = 0; i < 5; i++) {
        //var num = (number - 1) * 5 + i;
        var num = i;
        var create_div = $('<button class="lostListBox" onClick="turnTo('+num+','+pageNumber+')"></button>');
        var _html = '<div class="list-group-item lostList"><h4 class="list-group-item-heading fl lostListHead"><img src="'+ books[num].userImgUrl +'" alt=""></h4><div class="list-group-item-text fl lostListDesc"><h2 class="fabuTitlt">'+ books[num].title +'</h2><br><span>发布者：&nbsp;</span><span class="fabuPerson">'+ books[num].publisher +'</span><br><span>感谢信内容：&nbsp;</span><span class="fabuType">'+ books[num].content +'</span></div><div class="list-group-item-text fl clickNum"><p><span class="time">'+ formatDateTime(books[num].createTime) +'</span></p><br><br><br><br><p>了解详情 &nbsp;&nbsp;&gt;&gt;</p></div></div>';

        create_div.html(_html).addClass('animated fadeIn');
        $oResultBox.append(create_div);
    };
};

function prevPage(){
    pageNumber = pageNumber-1;
    if(pageNumber<1){
        number = 1;
        thinkLetterDatas(pageNumber);
    }else{
        thinkLetterDatas(pageNumber);
    }
}
function nextPage(){
    pageNumber=pageNumber+1;
    //alert(pageNumber);
    thinkLetterDatas(pageNumber);
}
function turnTo(p,pageNumber){
    //qext.LocalStorage.save(p);
    //alert(p);
    setCookie('infoLetterNum',p);//记录是从哪个失物招领列表跳转进来的
    setCookie('currentLetterPageNum',pageNumber);//记录是第几页分页的记录
	location.href = "5thanksLetter_detail.html";
}