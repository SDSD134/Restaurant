/**
 * Created by Administrator on 2018/10/26.
 */
function getXMLHttpRequest(){
	var xmlhttp;
	if (window.XMLHttpRequest)
	  {// code for IE7+, Firefox, Chrome, Opera, Safari
	  xmlhttp=new XMLHttpRequest();
	  }
	else
	  {// code for IE6, IE5
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
		return xmlhttp;
}

function newdiv() {

    $("#table_inquire").append("<div class=\"table_name\" id=\"ttable\"><form enctype=\"multipart/form-data\" class='aa' id ='addTableForm' action = \"servlet/tablesServlet?method=addTablesServlet\" method = \"post\"><input type='file' name='timg' class=\"table_imgadd\"><div class='tabler'></input><div class='num'> 桌子编号：<input name='tid' type='text' class=\"tnum\"></div>"

        + "<div class='tablefenl'> 桌子类型<input type='text' class='people' id='people' name='tvariety'></div></form></div>");

}

//保存桌子添加数据
function save(){
	document.getElementById("addTableForm").submit();//提交
}

//显示桌子信息
function showmain(tid) { 
    var show=document.getElementById("table_main");
   show.style.display = "block";
    var xhr = getXMLHttpRequest();
    
    
    //处理结果
    xhr.onreadystatechange = function(){
    	//alert(1);
    	if(xhr.readyState == 4) {
//    		alert(1);
//    		alert(xhr.readyState);
    		if(xhr.status == 200) {
    			var str = xhr.responseText;
    			var mation = str.split(",");
    			/*for(var i = 0 ;i < mation.length; i ++) {
    				alert(mation[i]);
    			}*/
    			//获取标签
    			var a2num = document.getElementById("a2num");
    			var a2state = document.getElementById("a2zhuozizhuangtai");
    			var a2name = document.getElementById("a2name");
    			var a2orderid = document.getElementById("a2orderid");
    			var a2all = document.getElementById("a2all");
    			//嵌入数值
    			a2num.innerHTML = "<span>" + mation[0] + "</span>";
    			a2state.innerHTML = "<span>" + mation[1] + "</span>";
    			a2name.innerHTML = "<span>" + mation[2] + "</span>";
    			a2orderid.innerHTML = "<span>" + mation[3] + "</span>";
    			//alert(a2orderid);
    			a2all.innerHTML = "<span>" + mation[4] + "<span>";
    		}
    	}
    }
    
    //创建连接
    xhr.open("get","/restaurant/servlet/orderServlet?tid=" + tid + "&method=findCurrentOrder");
    xhr.send(null);
    
}

//查询用户信息
function bottom() {
    var bot=document.getElementById("costumer_tabla");
    var username = document.getElementById("userming").value;
    var xhr = getXMLHttpRequest();
    
    //处理结果
    xhr.onreadystatechange = function(){
    	//alert(1);
    	if(xhr.readyState == 4) {
    		if(xhr.status == 200) {
    			if(xhr.responseText == "1"){
    				$(function(){
    					setInterval(function () {
    						$("#costumer_tabla").load(location.href + " #costumer_tabla");
    					},10);
    				});
    			}
    			
    		}
    	}
    }
    
    //创建连接
    xhr.open("get","/restaurant/servlet/userServlet?username=" + username + "&method=findUserByName");
    xhr.send(null);
    
    bot.style.display="block";
}

$(document).ready(function () {
    $(".leftpart li").click(function () {
        $("#partright div").hide();
        var name=$(this).attr("class");
        $("."+name+"_message").show();
        $("."+name+"_inquire").show();
        $("."+name+"_name").show();
        $("."+name+"_table").show();
        $("."+name+"_img").show();
        $("."+name+"_num").show();
        $("."+name+"_order").show();
        $("."+name+"_add").show();
        $("."+name+"_id").show();
        $("."+name+"_messag").show();
    });
});




