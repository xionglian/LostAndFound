var thingTypeData = ["卡类","证件类","文具类","生活用品类","电子产品类","雨具类","包类","其他类"];
var thingNameData = {
	Cards:["银行卡","羊城通","饭卡","水卡","其他"],
	Credentials:["学生证","身份证","借书证","准考证","驾驶证","其他"],
	Stationerys:["笔","笔袋","书籍","其他"],
	Groceries:["水杯","眼镜","钥匙","其他"],
	Electronics:["耳机","U盘","数据线","手机","充电宝","其他"],
	Umbrellas:["折叠伞","长柄直杆伞"],
	Bags:["钱包","卡包","其他"],
	Others:["运动物品","衣物","其他"]
};

$(document).ready(function(e) {
	$("#thingName").find("option").remove();
    for(var i = 0; i < thingTypeData.length; i ++){	
		//动态添加option  
		$("#thingType").append("<option value='"+thingTypeData[i]+"'>"+thingTypeData[i]+"</option>"); 
		
	}
	
	$("#thingType").click(function(e) {
		$("#thingName").find("option").remove();
		if($("#thingType").val() === "卡类"){	
			for(var j = 0; j < thingNameData.Cards.length; j++){	
				$("#thingName").append("<option value='"+thingNameData.Cards[j]+"'>"+thingNameData.Cards[j]+"</option>"); 
			}
		}else if($("#thingType").val() === "证件类"){	
			$("#thingName").empty();
			for(var j = 0; j < thingNameData.Credentials.length; j++){	
				$("#thingName").append("<option value='"+thingNameData.Credentials[j]+"'>"+thingNameData.Credentials[j]+"</option>"); 
			}
		}else if($("#thingType").val() === "文具类"){	
			$("#thingName").empty();
			for(var j = 0; j < thingNameData.Stationerys.length; j++){	
				$("#thingName").append("<option value='"+thingNameData.Stationerys[j]+"'>"+thingNameData.Stationerys[j]+"</option>"); 
			}
		}else if($("#thingType").val() === "生活用品类"){	
			$("#thingName").empty();
			for(var j = 0; j < thingNameData.Groceries.length; j++){	
				$("#thingName").append("<option value='"+thingNameData.Groceries[j]+"'>"+thingNameData.Groceries[j]+"</option>"); 
			}
		}else if($("#thingType").val() === "电子产品类"){	
			$("#thingName").empty();
			for(var j = 0; j < thingNameData.Electronics.length; j++){	
				$("#thingName").append("<option value='"+thingNameData.Electronics[j]+"'>"+thingNameData.Electronics[j]+"</option>"); 
			}
		}else if($("#thingType").val() === "雨具类"){	
			$("#thingName").empty();
			for(var j = 0; j < thingNameData.Umbrellas.length; j++){	
				$("#thingName").append("<option value='"+thingNameData.Umbrellas[j]+"'>"+thingNameData.Umbrellas[j]+"</option>"); 
			}
		}else if($("#thingType").val() === "包类"){
			$("#thingName").empty();
			for(var j = 0; j < thingNameData.Bags.length; j++){	
				$("#thingName").append("<option value='"+thingNameData.Bags[j]+"'>"+thingNameData.Bags[j]+"</option>"); 
			}
		}else if($("#thingType").val() === "其他类"){	
			$("#thingName").empty();
			for(var j = 0; j < thingNameData.Others.length; j++){	
				$("#thingName").append("<option value='"+thingNameData.Others[j]+"'>"+thingNameData.Others[j]+"</option>"); 
			}
		}
    });
});

var $title,$thingType,$releaseUserId,$confirmFoundUserId,$thingName,$keyWord01,$keyWord02,$keyWord03,$location,$locationDtail,$pickUpOne,$pickUpTime,$contactOne,$contactWay,$thingImg,$detail;
function publicFindOwner(){
    $releaseUserId = userInfoRes.id;
    $confirmFoundUserId="";
    $title = $('#title').val();
    $thingType = $('#thingType').val();
    $thingName = $('#thingName').val();
    $keyWord01 = $('#keyWord01').val();
    $keyWord02 = $('#keyWord02').val();
    $keyWord03 = $('#keyWord03').val();
    $location = $('#location').val();
    $locationDtail = $('#location_detail').val();
    $pickUpOne = $('#erjixueyuan').val()+$('#class').val()+$('#name').val();
    $pickUpTime = $('#pickUpDate').val()+'.123Z';
    $contactOne = $('#contactOne').val();
    $contactWay = $('#contactWay').val();
    $thingImg = $('#inputfile').val();
    $detail = $('#detail').val();

    //先上传图片
    var formData = new FormData(document.getElementById("uploadForm"));
    formData.append("uploadFile", $thingImg);
    $.ajax({
        type: 'post',
        xhrFields: {
            withCredentials: true
        },
        crossDomain: true,
        url: "http://119.29.102.236/File/uploadPhoto",
        data: formData,
        cache: false,
        processData: false,
        contentType: false,
        beforeSend:function(){
            if(!$title){
                alert('发布信息的标题不能为空，请输入标题');
                return false;
            }
            if(!$thingName){
                alert('请填写完物品类型');
                return false;
            }
            if(!$locationDtail){
                alert('请填写拾取到失物时的地点');
                return false;
            }
            if(!$pickUpOne){
                alert('拾取人信息不能为空，请填写完拾取人的信息');
                return false;
            }
            if(!$pickUpTime){
                alert('拾取失物的时间不能为空，请填写“拾取时间”。');
                return false;
            }
            if(!$contactOne||!$contactWay){
                alert('联系人的相关信息不能为空，请填写联系人的信息');
                return false;
            }
            //     手机号为11位，以1开头，第二位为3,5,7,8，后9位都是数字
            if(!/^1[3,5,7,8]\d{9}$/.test($contactWay)){
                alert('请输入正确的手机号');
                return false;
            }
            if(!$detail){
                alert('物品的具体描述不能为空，请填写失物的相关信息');
                return false;
            }
        },
        success: function(data){
            // alert(JSON.stringify(data));
            if(data.result == 'success'){
                $thingImg = data.data;
                realPublicFound();
            }
        }
    })
}
//发布失物招领
function realPublicFound(){
    $.ajax({
        type:'post',
        url:'http://119.29.102.236/found/add',
        xhrFields: {
            withCredentials: true
        },
        crossDomain: true,
        async:true,
        data:JSON.stringify({
                "title":$title,
                "releaseUserId":$releaseUserId,
                "confirmFoundUserId":2,
                "linkName":$contactOne,
                "linkPhone":$contactWay,
                "goodType":$thingType,
                "goodName":$thingName,
                "foundAddress":$location,
                "foundAddressDetail":$locationDtail,
                "foundTime":$pickUpTime,
                "descriptionDetail":$detail,
                "keyWord01":$keyWord01,
                "keyWord02":$keyWord02,
                "keyWord03":$keyWord03,
                "state":"1",
                "pictureUrl":$thingImg
        }),
        dataType:'json',
        contentType:'application/json; charset=utf-8',
        success:function(data){
            if(data.result === "success"){
                alert('发布失物招领信息成功!');
                location.href = '1findOwner.html';
            }else if(data.result === "fail"){
                alert(data.data);
            }
        }
    })

}