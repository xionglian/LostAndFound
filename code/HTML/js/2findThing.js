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

;(function ($, window, document, undefined) {

  var Paging = function (elem, options) {
    var self = this;
    this.$oPaging = elem;
    this.$oFirst = this.$oPaging.find('.first');
    this.$oLast = this.$oPaging.find('.last');
    this.$oPrev = this.$oPaging.find('.prev');
    this.$oNext = this.$oPaging.find('.next');
    this.$oList = this.$oPaging.find('.list');
    this.$aItem = this.$oList.find('li');
    this.$oGo = this.$oPaging.find('.go');
    this.$oGo_text = this.$oGo.find('input');
    this.$oGo_btn = this.$oGo.find('button');

    this.defaults = {
      nowPage: 1,
      allPages: 10,
      displayPage: 5
    };
    this.opts = $.extend({}, this.defaults, options);

    this.nowPage = this.opts.nowPage;
    this.allPages = this.opts.allPages;
    this.displayPage = this.opts.displayPage > this.allPages 
                     ? this.opts.displayPage = this.allPages 
                     : this.opts.displayPage;
    this.iNum = this.nowPage;
    this.min_halfPage = Math.floor(this.displayPage / 2);
    this.big_halfPage = Math.ceil(this.displayPage / 2);
  };

  Paging.prototype = {
    clickFn: function () {
      this.cleanClassName();
      this.setPaging(this.iNum);
      this.detectionPage(this.iNum);

      this.opts.callBack && this.opts.callBack(this.iNum);
    },

    cleanClassName: function () {
      this.$aItem.removeClass('cur');
    },

    detectionPage: function (currentPage) {
	  //console.log(currentPage);
      if (currentPage >= this.big_halfPage + 1) {
        this.$oFirst.removeClass('disable');
      } else {
        this.$oFirst.addClass('disable');
      }

      if (currentPage < this.allPages) {
        this.$oLast.removeClass('disable');
      }else {
        this.$oLast.addClass('disable');
      }

      if (currentPage > 1) {
        this.$oPrev.removeClass('disable');
      } else {
        this.$oPrev.addClass('disable');
      }

      if (currentPage < this.allPages) {
        this.$oNext.removeClass('disable');
      } else {
        this.$oNext.addClass('disable');
      }
    },

    setPaging: function (currentPage) {
      this.$aItem = this.$oList.find('li');

      for (var i = 1; i <= this.displayPage; i++) {
        if (currentPage <= this.min_halfPage) {
          this.$aItem.eq(i - 1).text(i).attr('index', '#' + i);

          for (var j = 1; j <= this.min_halfPage; j++) {
            if (currentPage === j && i === j) {
              this.$aItem.eq(i - 1).addClass('cur');
            }
          }
        } else if ((this.allPages - currentPage) < this.min_halfPage) {
          var nowNum = this.allPages - this.displayPage + i;

          this.$aItem.eq(i - 1).text(nowNum).attr('index', '#' + nowNum);

          for (var j = 0; j < this.min_halfPage; j ++) {
            if ((this.allPages - currentPage) === j && i === this.displayPage - j) {
              this.$aItem.eq(i - 1).addClass('cur');
            }
          }
        } else {
          var nowNum = currentPage - this.big_halfPage + i;

          if (i === this.big_halfPage) {
            this.$aItem.eq(i - 1).addClass('cur');
          }

          this.$aItem.eq(i - 1).text(nowNum).attr('index', '#' + nowNum);
        }
      }
    },

    initalPaging: function () {
      for (var i = 1; i <= this.displayPage; i ++) {
        var $create_li = $('<li></li>');

        $create_li.text(i).attr('index', '#' + i);

        this.$oList.append($create_li);
      }

      if (this.allPages <= this.displayPage) {
        this.$aItem.eq(this.nowPage - 1).addClass('cur');
      } else {
        this.$oGo.css({display: 'inline-block'});
        this.$oGo_text.attr('placeholder', 'Total: ' + this.allPages);
      }

      this.setPaging(this.nowPage);
      this.detectionPage(this.nowPage);
    },

    inital: function () {
      var self = this;

      this.initalPaging();
      this.opts.callBack && this.opts.callBack(this.iNum);

      this.$aItem.click(function () {
        if (!$(this).hasClass('cur')) {
          self.iNum = parseInt($(this).attr('index').substring(1));

          self.clickFn();
        }
      });

      this.$oFirst.click(function () {
        if (!$(this).hasClass('disable')) {
          self.iNum = 1;

          self.clickFn();
        }
      });

      this.$oLast.click(function () {
        if (!$(this).hasClass('disable')) {
          self.iNum = self.allPages;

          self.clickFn();
        }
      });

      this.$oPrev.click(function () {
        if (!$(this).hasClass('disable')) {
          self.iNum --;

          self.clickFn();
        }
      });

      this.$oNext.click(function () {
        if (!$(this).hasClass('disable')) {
          self.iNum ++;

          self.clickFn();
        }
      });

      this.$oGo_btn.click(function () {
        var value = self.$oGo_text.val();
        var reg = new RegExp(/^[0-9]*[1-9][0-9]*$/);

        if (value !== '' && reg.test(value) && value <= self.allPages) {
          self.iNum = parseInt(value);

          self.clickFn();

          self.$oGo_text.val('');
        } else {
          self.$oGo_text.val('');
        }
      });
    },

    constructor: Paging
  };

  $.fn.paging = function (options) {
    var paging = new Paging(this, options);

    return paging.inital();
  };

})(jQuery, window, document, undefined);

function turnTo(p){	
	setCookie('infoFindThingNum',p);//记录是从哪个寻物启事列表跳转进来的
	location.href = "2findThing_detail.html";
}