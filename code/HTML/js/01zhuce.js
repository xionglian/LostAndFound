var erjixueyuanData = ["电子与信息学院","机电学院","计算机科学学院","汽车与交通工程学院","自动化学院","光电工程学院","数学与系统科学学院","教育科学与技术学院","财经学院","法学与知识产权学院","管理学院","外国语学院","文学与传媒学院","美术学院","音乐学院","民族学院","马克思主义学院","国际教育学院","教师培训与继续教育学院","创新创业学院","广东工业实训中心","体育部"];    
$(document).ready(function() {
    for(var i = 0; i < erjixueyuanData.length; i ++){	
		//动态添加option  
		$("#erjixueyuan").append("<option value='"+erjixueyuanData[i]+"'>"+erjixueyuanData[i]+"</option>"); 
		
	}
})