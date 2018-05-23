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

