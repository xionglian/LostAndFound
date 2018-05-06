var num = getCookie('infoLetterNum');
var info = thanksLetterData;
window.onload = function(){	
	$('.fabuTitlt').html("");
	$('.fabuTime').html("");
	$('.checkNum').html("");
	$('#letterContent').html("");
	$('#luokuan').html("");

	$('.fabuTitlt').html(info[num].fabuTitlt);
	$('.fabuTime').html(info[num].fabuTime);
	$('.checkNum').html(info[num].checkNum);
	$('#letterContent').html(info[num].letterContent);
	$('#luokuan').html(info[num].fabuPerson);
};
