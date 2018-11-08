/**
 * Created by Administrator on 2018/10/26.
 */
//ajax
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

    $("#table_inquire").append("<div class=\"table_name\" id=\"ttable\"><form enctype=\"multipart/form-data\" class='aa' id ='addTableForm' action = \"servlet/tablesServlet?method=addTablesServlet\"  method = \"post\"><input type='file' name='timg' class=\"table_imgadd\"><div class='tabler'></input><div class='num'> 桌子编号：<input name='tid' type='text' class=\"tnum\"></div>"

        + "<div class='tablefenl'> 桌子类型<input type='text' class='people' id='people' name='tvariety'></div></form></div>")

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
    			alert(mation);
    			//嵌入数值
    			a2num.innerHTML = "<span>" + mation[0] + "</span>";
    			if(mation == 1){
    			    a2state.innerHTML = "<span>有人</span>";
    			} else {
    				a2state.innerHTML = "<span>空桌</span>";
    			}
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

//查询用户信息,用户名查询
function bottom() {
    var bot=document.getElementById("costumer_tabla");
    var username = document.getElementById("userming").value;
    //alert(username);
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
    					},100);
    				});
    			}
    			
    		}
    	}
    }
    
    //创建连接
    xhr.open("get","/restaurant/servlet/userServlet?username=" + username + "&method=findUser");
    xhr.send(null);
    
    bot.style.display="block";
}

//获取三天内所有订单
function showOrders() {
	var xhr = getXMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4) {
			if(xhr.status == 200) {
				if (xhr.responseText = "true"){
					$(function(){
    					setInterval(function () {
    						$("#showorder").load(location.href + " #showorder");
    					},10);
    				});
				}
				}
			}
		}
	
	//创建连接
	xhr.open("get","/restaurant/servlet/orderServlet?&method=findThreedayOrder");
    xhr.send(null);
		
	
	
}

function searchorders () {
	var username = document.getElementById("searchb").value;
	var orderid = document.getElementById("searchc").value;
	if (username =="" && orderid =="") {
		showOrders();
	} else {
		var xhr = getXMLHttpRequest();
		xhr.onreadystatechange = function() {
			if(xhr.readyState == 4) {
				if(xhr.status == 200) {
					if (xhr.responseText = "true"){
						$(function(){
	    					setInterval(function () {
	    						$("#showorder").load(location.href + " #showorder");
	    					},10);
	    				});
					}
					}  
				}
			}
		
		//创建连接
		xhr.open("get","/restaurant/servlet/orderServlet?username=" + username +"&orderid=" + orderid + "&method=searchOrder");
	    xhr.send(null);
	}
	
	
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
        $("."+name+"_main").show();
        $("."+name+"_group").show();
    });
});

function addnew() {
         $("#menu_add").append();
     }

$(document).ready(function () {
    $(".table_order").click(function () {
    	//alert(1);
    	showOrderByTable(this);
    	//alert(this);
        $("#partright div").hide();
        $(".order_message").show();
        $(".order_inquire").show();
        $(".order_main").show();
        $(".order_table").show();
    });
});

function showOrderByTable(div) {
	var tableid = div.parentNode.children[0].getAttribute('value');
	//alert(tableid);
	//console.log(tableid);
	var xhr = getXMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4) {
			if(xhr.status == 200) {
				if (xhr.responseText = "true"){
					$(function(){
    					setInterval(function () {
    						$("#showorder").load(location.href + " #showorder");
    					},10);
    				});
				}
				
				
				}
			}
		}
	
	//创建连接
	xhr.open("get","/restaurant/servlet/orderServlet?tableid=" + tableid + "&method=findOrderByTid");
    xhr.send(null);
	
	
}

//员工注册
function register() {
	var username = document.getElementById("employ01").value;
	var password = document.getElementById("employ21").value;
	var msg = document.getElementById("msg");
	
	var xhr = getXMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4) {
			if(xhr.status == 200) {
				if(xhr.responseText =="false"){
					msg.innerHTML = "注册失败";
				} 
				if(xhr.responseText == "true") {
					msg.innerHTML = "";
					showAllUser();
				}
			}
		}
	}
	//创建连接
	xhr.open("get","/restaurant/servlet/userServlet?username=" + username +"&password=" + password + "&method=register");
    xhr.send(null);
	

}

//获取所有员工信息
function showAllUser() {
	var register = document.getElementById("employTable");
	var xhr = getXMLHttpRequest();
	/*var name = document.getElementsByName("append");
	for (var s= 0; s < name.length;s++){
		name[i].parents('tr').remove();

	}*/
	var name = "";
	var password = "";
	
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4) {
			if(xhr.status == 200) {
				var user = xhr.responseText;
				var userArray = eval(user);
	            for (var i= 0; i < userArray.length;i++ ) {
	            		name = userArray[i].name;
	            		password = userArray[i].password;
	            	var userbody = ("<tr  class='emp3 >" + 
                        "<td class='emp20'>" + name +"</td>" + 
                        "<td class='emp20'>" + password + "</td>" +
                        "<td class='emp20'><img src='image/shanchu.png'></td>" +
                        "<td class='emp20'><img src='image/index.png'></td>" +
                    "</tr>");
	            	$('#employTable').append(userbody);

	            }
	               
				

				}
			}
		}
	
	//创建连接
	xhr.open("post","/restaurant/servlet/userServlet?method=queryAll");
    xhr.send(null);
}



