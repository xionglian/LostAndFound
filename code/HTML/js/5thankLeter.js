var books = thanksLetterData;
$(function () {
  var $oResultBox = $('#listDeatil');

  $('#paging').paging({
    nowPage: 1,
    allPages: Math.ceil(books.length / 5),
    displayPage: 7,
    callBack: function (now) {
      var currentPages = now * 5 < books.length ? 5 : books.length - (now - 1) * 5;

      $oResultBox.html('');

      for (var i = 0; i < currentPages; i++) {
        var num = (now - 1) * 5 + i;
        var create_div = $('<button class="lostListBox" onClick="turnTo('+ num +');"></button>');
        var _html = '<div class="list-group-item lostList"><h4 class="list-group-item-heading fl lostListHead"><img src="'+ books[num].user_imgUrl +'" alt=""><br><span>'+ books[num].fabuPerson +'</span></h4><div class="list-group-item-text fl lostListDesc"><h2 class="fabuTitlt">'+ books[num].fabuTitlt +'</h2><br><br><p class="letterContent">'+ books[num].letterContent +'</p></div><div class="list-group-item-text fl clickNum"><p><span class="time">'+ books[num].fabuTime +'</span>&nbsp;&nbsp;查阅数： <span class="checkNum">'+ books[num].checkNum +'</span></p><br><br><br><br><p>了解详情 &nbsp;&nbsp;&gt;&gt;</p></div></div>';

        create_div.html(_html).addClass('animated fadeIn');
        $oResultBox.append(create_div);
      }
	}
  });
  
});

function turnTo(p){	
	//qext.LocalStorage.save(p);
	setCookie('infoLetterNum',p);//记录是从哪个失物招领列表跳转进来的
	location.href = "5thanksLetter_detail.html";
}