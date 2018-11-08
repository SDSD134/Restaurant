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
    $("#table_inquire").append("<div class=\"ttable\" id=\"ttable\"><div class='aaa'onclick='showmain()' ><input type='file' class=\"table_imgadd\"></div><div class='tabler'> </input><div class='num'> 桌子编号：<input  type='text' class=\"tnum\"></div>"
        + " <div class=\"history_order\" id=\"table_order\">历史订单</div><div class='tablefenl'> 桌子类型<input type='text' class='people' id='people' name='zhuozi'></div></div></div>")
}
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
    			//alert(mation.length);
    			var a2num = document.getElementById("a2num");
    			var a2id = document.getElementById("a2id");
    			var a2name = document.getElementById("a2name");
    			a2num.innerHTML = "<span>" + mation[0] + "</span>";
    			a2id.innerHTML = "<span>" + mation[1] + "</span>";
    			a2name.innerHTML = "<span>" + mation[2] + "</span>";
    			
    			
    		}
    	}
    }
    
    //创建连接
    xhr.open("get","/restaurant/servlet/orderServlet?tid=" + tid + "&method=findCurrentOrder");
    xhr.send(null);
    
}

function bottom() {
    var bot=document.getElementById("costumer_tabla");
    bot.style.display="block";
}
$(document).ready(function () {
    $(".leftpart li").click(function () {
        $("#partright div").hide();
        var name=$(this).attr("class");
        $("."+name+"_message").show();
        $("."+name+"_messag").show();
        $("."+name+"_inquire").show();
        $("."+name+"_name").show();
        $("."+name+"_table").show();
        $("."+name+"_img").show();
        $("."+name+"_num").show();
        $("."+name+"_order").show();
        $("."+name+"_add").show();
        $("."+name+"_id").show();
    })
})



function getOrderByTable(){
	
	
}

