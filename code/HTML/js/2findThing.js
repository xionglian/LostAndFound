var books = findThingData;
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
        var _html = '<div class="list-group-item lostList"><h4 class="list-group-item-heading fl lostListHead"><img src="'+ books[num].imgUrl +'" alt=""></h4><div class="list-group-item-text fl lostListDesc"><h2 class="fabuTitlt">'+ books[num].fabuTitlt +'</h2><br><span>失物类型：&nbsp;</span><span>寻物启事</span><br><span>发布者：&nbsp;</span><span class="fabuPerson">'+ books[num].fabuPerson +'</span><br><span>发布者身份：&nbsp;</span><span class="fabuType">'+ books[num].fabuType +'</span><br><span>发布时间：&nbsp;</span><span class="fabuTime">'+ books[num].fabuTime +'</span><br><span>发布地点：&nbsp;</span><span class="fabuLocation">'+ books[num].fabuLocation +'</span></div><div class="list-group-item-text fl clickNum"><p><span class="time">'+ books[num].dateTime +'</span>&nbsp;&nbsp;查阅数： <span class="checkNum">'+ books[num].checkNum +'</span></p><br><br><p><button id="'+ num +'" disabled="true"></button></p><br><br><p>了解详情 &nbsp;&nbsp;&gt;&gt;</p></div></div>';

        create_div.html(_html).addClass('animated fadeIn');
        $oResultBox.append(create_div);
      }
	  
      for (var i = 0; i < currentPages; i++) {
        var num = (now - 1) * 5 + i;
		var state = books[num].state;
		var btns = document.getElementById(num);
		console.log(state);
		if(state === 1){	
			btns.innerHTML = "寻找成功";
			btns.setAttribute("class","btn btn-lg btn-warning");
		}else if(state === 0){	
			btns.innerHTML = "寻找中…";
			btns.setAttribute("class","btn btn-lg btn-danger");
		}
	  }
	}
  });
  
});

function turnTo(p){	
	setCookie('infoFindThingNum',p);//记录是从哪个寻物启事列表跳转进来的
	location.href = "2findThing_detail.html";
}