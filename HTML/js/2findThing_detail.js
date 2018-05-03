var num = getCookie('infoFindThingNum');
var info = findThingData;
var state = info[num].state;
var btns = document.getElementById('btnState');
$(document).ready(function(e) {
	if(state === 1){	
		btns.innerHTML = "寻找成功";
		btns.setAttribute("class","btn btn-lg btn-warning");
	}else if(state === 0){	
		btns.innerHTML = "寻找中…";
		btns.setAttribute("class","btn btn-lg btn-danger");
	}
});
window.onload = function(){	
	$('.fabuTitlt').html("");
	$('.fabuTime').html("");
	$('.checkNum').html("");
	$('.fabuContact').html("");
	$('.fabuPerson').html("");
	$('#fabuPerson').html("");
	$('#thingsType').html("");
	$('#location').html("");
	$('#findPerson').html("");
	$('#contactNum').html("");
	$('#fabuTime').html("");
	$('#detailDesc').html("");

	$('.fabuTitlt').html(info[num].fabuTitlt);
	$('.fabuTime').html(info[num].fabuTime);
	$('.checkNum').html(info[num].checkNum);
	$('.fabuContact').html(info[num].Contact);
	$('.fabuPerson').html(info[num].fabuPerson);
	$('#fabuPerson').html(info[num].fabuPerson);
	$('#thingsType').html(info[num].thingsType);
	$('#location').html(info[num].location);
	$('#findPerson').html(info[num].findPerson);
	$('#contactNum').html(info[num].Contact);
	$('#fabuTime').html(info[num].fabuTime);
	$('#thingsImage').attr('src',info[num].imgUrl);
	$('#detailDesc').html(info[num].detailDesc);
}
