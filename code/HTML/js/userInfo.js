var user = getCookie('userInformation');//用户的基本信息；
// alert(user)
var userInfoRes = JSON.parse(user);
if(user.length>0){
    $('.btnBox').hide();
    $('.userInfo').show();
    $('#userName').html(userInfoRes.username);
	//alert(userInfoRes.username+userInfoRes.role);
    if(userInfoRes.role == 0){
        $('#normal').attr('checked','checked');
        $('#manager').attr('disabled','true');
	}else if(userInfoRes.role == 1){
        $('#manager').attr('checked');
        $('#normal').attr('disabled','true');
	}
	$('#fabuPerson').attr({'placeholder':userInfoRes.username,'disabled':'true'});
}
