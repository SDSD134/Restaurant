/**
 * Created by Administrator on 2018/10/26.
 */
$(document).ready(function () {
    $(".menu_main td").mouseover(function () {
        var aas = $(this).children().attr("id");
        console.log(aas);
        $("#"+aas).attr("style","display:block");
    })
})
$(document).ready(function () {
    $(".menu_main td").mouseout(function () {
        var aas = $(this).children().attr("id");
        console.log(aas);
        $("#"+aas).attr("style","display:none");
    })
})
function newdiv() {

    $("#table_inquire").append("<div class=\"table_name\" id=\"ttable\"><form enctype=\"multipart/form-data\" class='aa' id ='addTable' action = \"servlet/tablesServlet?method=addTablesServlet\" method = \"post\"><input type='file' name='timg' class=\"table_imgadd\"><div class='tabler'></input><div class='num'> 桌子编号：<input name='tid' type='text' class=\"tnum\"></div>"

        + "<div class='tablefenl'> 桌子类型<input type='text' class='people' id='people' name='tvariety'></div></form></div>")
        
}

function save() {
	document.getElementById("addTable").submit();//提交
}

 $(document).ready(function () {
    $(".lb li").click(function () {
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
        $("."+name+"_abc").show();
        $("."+name+"_css").show();
    });
});
 



function xiaoshi(pid) {
    $("#bottom_pickup").attr("style","display:none;");
    updateProduct(pid);
}


function noa() {
    $("#bottom_pickup").attr("style","display:none;");
    $(".newad").attr("style","display:none;");
    addmenu();
}



$(document).ready(function () {
    $(".table_order").click(function () {
        $("#partright div").hide();
        $(".order_message").show();
        $(".order_inquire").show();
        $(".order_main").show();
        $(".order_table").show();
        
    });
});

$(document).ready(function () {
    $(".table_order0").click(function () {
        $("#partright div").hide();
        $(".order_message").show();
        $(".order_inquire").show();
        $(".order_main").show();
        $(".order_table").show();
        currentOrder();
    });
});

//用户订单详情跳转
$(document).ready(function () {
    $(".aaab").click(function () {
        $("#partright div").hide();
        $(".order_message").show();
        $(".order_inquire").show();
        $(".order_main").show();
        $(".order_table").show();
    });
});

function chuxian0() {
    $("#ok0").attr("style","display:block;");
}

function xiaoshi0() {
    $("#ok0").attr("style","display:none;");
}



function bottom() {
    var bot=document.getElementById("costumer_tabla");
    var username = document.getElementById("userming").value;
    alert(username);
    var xhr = getXMLHttpRequest();
    
    //处理结果
    xhr.onreadystatechange = function(){
    	//alert(1);
    	if(xhr.readyState == 4) {
    		if(xhr.status == 200) {
    			if(xhr.responseText == "true"){
    				$("#costumer_tabla").load(location.href + " #costumer_tabla");
    			
    			}
    			
    		}
    	}
    }
    
    //创建连接
    xhr.open("get","/restaurant/servlet/userServlet?username=" + username + "&method=findUser");
    xhr.send(null);
    bot.style.display="block";
}

/*$(document).ready(function () {
    $(".foodzhonglei td").mouseover(function () {
        var aa12 = $(this).attr("id");
        console.log(aa12);
        $("#" + aa12 + "_a").attr("style", "display:block")
    })
})

$(document).ready(function () {
    $(".foodzhonglei td").mouseout(function () {
        var aa12 = $(this).attr("id");
        $("#" + aa12 + "_a").attr("style", "display:none")
    })
})*/
$(function() {
    var elm = $('.leftpart');
    var startPos = $(elm).offset().top;
    $.event.add(window, "scroll", function() {
        var p = $(window).scrollTop();
        $(elm).css('position',((p) > startPos) ? 'fixed' : 'static');
        $(elm).css('top',((p) > startPos) ? '0px' : '');
    });
});
/*function empty() {
    $(".rowb").empty();
}*/
/*script type="text/javascript">  三个文本框 / 一个添加按钮 按钮实现功能 添加信息到表格中  一个表格，行数动态增加的 function addRow()
 { // 获取input元素节点数组 var inputNodes = document.getElementsByTagName("input"); var str = new String(inputNodes[0].value);
 var str1 = new String(inputNodes[1].value); var str2 = new String(inputNodes[2].value); if ((str.length > 0) && (str1.length > 0) && (str2.length > 0))
 { //添加一行 insertRow() 方法用于在表格中的指定位置插入一个新行 var newTr = testTble.insertRow();
添加四列 sertCell() 方法用于在 HTML 表的一行的指定位置插入一个空的 <td> 元素 var newTd0 = newTr.insertCell();
 var newTd1 = newTr.insertCell(); var newTd2 = newTr.insertCell(); var newTd3 = newTr.insertCell();
 分别给每一列赋值 newTd0.innerText= inputNodes[0].value; newTd1.innerText= inputNodes[1].value; newTd2.innerText= inputNodes[2].value;
 newTd3.innerHTML = "<input type='button' value='删除' onclick='deleteTable(this)'>"; } else { alert("请先把信息填写完整！"); return; } }
 function deleteTable(r) { //获取当前表格行号 var i = r.parentNode.parentNode.rowIndex;
调用deleteRow()删除本行 document.getElementById('testTble').deleteRow(i); } </script>
*/
//添加商品
function addmenu() {
//	$('#myForm').serialize()
	 var formobj = new FormData();
	var ptname = document.getElementById("new_id").value;
 	var pname = document.getElementById("new_name").value;
 	var pprice = document.getElementById("new_prise").value;
 	var pstate = document.getElementById("new_zhuangtai").value;
 	var pimg = document.getElementById("src").files[0];
 	//alert(pimg.size);
 	
 	if (typeof (pimg) == "undefined" || pimg.size <= 0) {
      alert("请选择图片");
      return;
 	}
    formobj.append('ptname',ptname);
    formobj.append('pname',pname);
    formobj.append('pprice',pprice);
    formobj.append('pstate',pstate);
    formobj.append('pimg',pimg);
	$.ajax({ 
		type: "POST",
		 url:"/restaurant/servlet/productServlet?method=addProduct",
		 cache: false,
		 data: new FormData($('#myForm')[0]),
		 async: false, 
		 processData: false,
		 contentType: false,
		 error: function(request) { 
			 alert("Connection error");
		 },
		 success: function() {
			 $("#foodzhonglei").load(location.href + " #foodzhonglei");
			 alert("成功");
		 }
		 
	});
}

//删除菜品种类
function deleteType(del) {
	var ptid = del.getAttribute("value");
	var xhr = getXMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4) {
			if(xhr.status == 200) {
				if (xhr.responseText = "true"){
					
    						$("#menu_main").load(location.href + " #menu_main");
    				
				}
				}
			}
		}
	
	//创建连接
	xhr.open("post","/restaurant/servlet/product_TypeServlet?ptid="+ ptid +"&method=deletProduct_Type");
    xhr.send(null);
	
}

//删除商品
function deleteproduct(obj) {
	var pid = obj.getAttribute("value");
	var xhr = getXMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4) {
			if(xhr.status == 200) {
				if (xhr.responseText = "true"){
			
    						$("#menu_tabla").load(location.href + " #menu_tabla");
    				
				}
				}
			}
		}
	
	//创建连接
	xhr.open("get","/restaurant/servlet/productServlet?pid="+ pid+"&method=deletProduct");
    xhr.send(null);
	
}


    
    
    function chuxian() {
        $("#bottom_pickup").attr("style","display:block;");
    }



//获取所有员工信息
function showAllUser() {
	var xhr = getXMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4) {
			if(xhr.status == 200) {
				
					/*$(function(){
						setInterval(function () {
							$("#userall").load(location.href + " #userall");
						},10);
					});*/
				if(xhr.responseText =="true") {
					$("#userall").load(location.href + " #userall");
				}
				
					/*var user = xhr.responseText;
					var userArray = eval(user);
				    for (var i= 0; i < userArray.length;i++ ) {
				    		name = userArray[i].name;
				    		password = userArray[i].password;
				    		document.getElementsByName("username")[i].value = name;
				    		document.getElementsByName("password")[i].innerHTML = password;
					}
    				*/
				
				}
			}
		}
	
	//创建连接
  
	xhr.open("post","/restaurant/servlet/userServlet?method=queryAll");
    xhr.send(null);
	
}

//显示所有顾客
function showAllCostumer(){
	var xhr = getXMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4) {
			if(xhr.status == 200) {
				if (xhr.responseText = "true"){
    				$("#costumer_tab").load(location.href + " #costumer_tab");
    				
				}
				}
			}
		}
	
	//创建连接
	xhr.open("get","/restaurant/servlet/userServlet?method=allCostumer");
    xhr.send(null);
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

//当前订单
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

//获取所有商品
function showAllMenu() {
var xhr = getXMLHttpRequest();
    //处理结果
    xhr.onreadystatechange = function(){
    	//alert(1);
    	if(xhr.readyState == 4) {
//    		alert(1);
//    		alert(xhr.readyState);
    		if(xhr.status == 200) {
    			if (xhr.responseText = "true"){
    						$("#menu_tabla").load(location.href + " #menu_tabla");
    						$("#foodzhonglei").load(location.href + " #foodzhonglei");
    				
				}
    			
    		}
    	}
    	
    }
    //创建连接
    xhr.open("get","/restaurant/servlet/productServlet?method=queryAll");
    xhr.send(null);
    
}

//查询商品信息
function searchmenu() {
	var pname = document.getElementById("menuming").value;
	//alert(search);
	if(pname==""){
		showAllMenu();
	} else{
		 var xhr = getXMLHttpRequest();
		    
		    //处理结果
		    xhr.onreadystatechange = function(){
		    	//alert(1);
		    	if(xhr.readyState == 4) {
		    		if(xhr.status == 200) {
		    			if(xhr.responseText == "true"){
		    				$("#menu_tabla").load(location.href + " #menu_tabla");
		    			}
		    			
		    		}
		    	}
		    }
		    
		    //创建连接
		    xhr.open("get","/restaurant/servlet/productServlet?pname=" + pname + "&method=searchProduct");
		    xhr.send(null);
		
	}
	
	
}

//删除员工
function deleteUser(obj1) {
	var username =  obj1.getAttribute("value");
	    var xhr = getXMLHttpRequest();
		xhr.onreadystatechange = function() {
			if(xhr.readyState == 4) {
				if(xhr.status == 200) {
					if (xhr.responseText = "true"){
				        var username = document.getElementById("emp20").innerHTML;
	    				$("#menu_table").load(location.href + " #showorder");
	    				
					}
					}
				}
			}
		
		//创建连接
		xhr.open("get","/restaurant/servlet/userServlet?username="+ username+"&method=deleteUser");
	    xhr.send(null);
	    
	    
	   
}

//通过用户名字查询历史订单
function orderbyUser(costumer) {
	var xhr = getXMLHttpRequest();
    var username = costumer.getAttribute("username");
    alert(username);
    //处理结果
    xhr.onreadystatechange = function(){
    	//alert(1);
    	if(xhr.readyState == 4) {
    		if(xhr.status == 200) {
    			if(xhr.responseText == "true"){
    				$("#partright div").hide();
    			    $(".order_message").show();
    			    $(".order_inquire").show();
    			    $(".order_main").show();
    			    $(".order_table").show();
    				$("#showorder").load(location.href + " #showorder");
    				
    				
    			}
    		  
    		}
    	}
   
}
    //创建连接
    xhr.open("get","/restaurant/servlet/orderServlet?username="+username+"&method=searchOrder");
    xhr.send(null);
}

//修改商品
function updateProduct(pid) {
	var productId = pid.getAttribute("pid");
	var ptname;
	var pname;
	var pprice;
	var pstate;
	var tr = pid.parentNode.parentNode.childNodes;
	for(var i = 0; i< tr.length; i++) {
		if (tr[i].nodeType == 1) {
			if(tr[i].id == "m2id") {
				ptname = tr[i].innerHTML;
				ptname = ptname.replace(/^\s*|\s*$/g,"");
			}
			if(tr[i].id == "m2name") {
				pname = tr[i].innerHTML;
				pname = pname.replace(/^\s*|\s*$/g,"");
			}
			if(tr[i].id == "m2pas") {
				pprice = tr[i].innerHTML;
				pprice = pprice.replace(/\s*/g,"");
			}
			if(tr[i].id == "m2zhuangtai") {
				pstate = tr[i].innerHTML;
				pstate = pstate.replace(/\s*/g,"");
				
			}
		}
	}
	var xhr = getXMLHttpRequest();
    xhr.onreadystatechange = function(){
    	if(xhr.readyState == 4) {
    		if(xhr.status == 200) {
    			if (xhr.responseText = "true"){
    				$("#menu_tabla").load(location.href + " #menu_tabla");
				}
    			
    		}
    	}
    	
    }
    //创建连接
    xhr.open("post","/restaurant/servlet/productServlet?ptname=" + ptname +
    		"&pname=" + pname + "&pprice=" + pprice + "&pstate=" + pstate + "&pid=" +productId +
    		"&method=updateProduct");
    xhr.send(null);
}

//商品种类对应的菜
function typemenu(obj) {
	var typeid = obj.getAttribute("value");
	var xhr = getXMLHttpRequest();
    xhr.onreadystatechange = function(){
    	if(xhr.readyState == 4) {
    		if(xhr.status == 200) {
    			if (xhr.responseText = "true"){
    				$("#menu_tabla").load(location.href + " #menu_tabla");
				}
    			
    		}
    	}
    	
    }
   
    xhr.open("get","/restaurant/servlet/productServlet?ptid=" + typeid +"&method=findProductByPtid");
    xhr.send(null);
	
}

function currentOrder() {
		var orderid = document.getElementById("oid").innerHTML;
		alert(orderid);
		var xhr = getXMLHttpRequest();
		xhr.onreadystatechange = function(){
	    	if(xhr.readyState == 4) {
	    		if(xhr.status == 200) {
	    			if (xhr.responseText = "true"){
	    				$("#showorder").load(location.href + " #showorder");
					}
	    			
	    		}
	    	}
	    	
	    }
	   
	    xhr.open("get","/restaurant/servlet/orderServlet?orderid=" + orderid +"&method=searchOrder")
	    xhr.send(null);
		
}

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

//
function addnew() {
	//action ='/restaurant/servlet/productServlet?method=addProduct' method='post'enctype ='multipart/form-data' 
    $("#rowcel").append("<tr class=\"rowa\" id=\"new_row\">" +"<form  id ='myForm' enctype ='multipart/form-data'>"
    		 + "<td id=\"nwe_t1\" class=\"a0\">" +
        "<input type=\"text\" id=\"new_id\" class=\"new_name0\" name = \"ptname\"></td> " +
        "<td id=\"new_t2\" class=\"a0\"><input type=\"text\" id=\"new_name\" class=\"new_name0\" name = \"pname\" ></td>"+
        "<td id=\"new_t3\" class=\"a0\"><input type=\"text\" id=\"new_prise\" class=\"new_name0\" name = \"pprice\"></td>"+
        "<td id=\"new_t4\" class=\"a1a\"><input type=\"text\" id=\"new_zhuangtai\" class=\"new_name0\" name = \"pstate\"></td>"+
        "<td id=\"new_t5\" class=\"new\"><input type='file' value=\"图片\" class='abc' id='src' name='pimg'></td>"+
         "<td id=\"new_t6\" class=\"newad\" ><input type=\"button\" value=\"确定\" class='new_mame0' id='bottom_piclup' name=\"querentijiao\" onclick='noa()'></td>"+
         "</form></tr>");                            
}

function showmain(tid) {
    var show=document.getElementById("table_main");
    show.style.display="block";
}

//删除商品
function deleteRow0(obj){
    var index=obj.parentNode.rowIndex;
    var table = document.getElementById("rowcel");
    var con=confirm("确定删除?"); 
    if(con == true) {
    table.deleteRow(index);
    deleteproduct(obj);
    }else {
    	return;
    }
}

//员工注册
function register() {
	var username = document.getElementById("employ01").value;
	var password = document.getElementById("employ21").value;
	var msg = document.getElementById("msg");
	if(username=="" || password=="") {
		document.getElementById("ok0").setAttribute("disabled", true);
		msg.innerHTML = "不能为空";
		return;
	}
	
	
	var xhr = getXMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4) {
			if(xhr.status == 200) {
				if(xhr.responseText =="false"){
					msg.innerHTML = "注册失败";
				} else{
					msg.innerHTML ="";
					showAllUser();
					
				}
				
			}
		}
	}
	//创建连接
	xhr.open("get","/restaurant/servlet/userServlet?username=" + username +"&password=" + password + "&method=register");
    xhr.send(null);
	
}

function ShowElement(element) {
    var oldhtml = element.innerHTML;
    //创建新的input元素
    var newobj = document.createElement('input');
    //为新增元素添加类型
    newobj.type = 'text';
    newobj.style.width='50px';
    //为新增元素添加value值
    newobj.value = oldhtml;
    //为新增元素添加光标离开事件
    newobj.onblur = function() {
        element.innerHTML = this.value == oldhtml ? oldhtml : this.value;
        //当触发时判断新增元素值是否为空，为空则不修改，并返回原有值
    }
    //设置该标签的子节点为空
    element.innerHTML = '';
    //添加该标签的子节点，input对象
    element.appendChild(newobj);
    //设置选择文本的内容或设置光标位置（两个参数：start,end；start为开始位置，end为结束位置；如果开始位置和结束位置相同则就是光标位置）
    newobj.setSelectionRange(0, oldhtml.length);
    //设置获得光标
    newobj.focus();
}


//删除员工
function deleteRow(obj1){
  var index1=obj1.parentNode.rowIndex;
  var table1= document.getElementById("rowemp");
  var con=confirm("确定删除?"); 
  if(con == true) {
	    table1.deleteRow(index1);
	    deleteUser(obj1);
  }else{
  	return;
  }
}


function login(){
  var isSuccess = true;//调用后台登陆校验返回是否成功

  if(isSuccess){
      document.getElementById("boss").style.display = "none";
  }

}

//退出登陆
function logOut(){
  document.getElementById("boss").style.display = "inline";
}

function deleteRowa(obj2){
  var index2=obj2.parentNode.rowIndex;
  var table2= document.getElementById("costumer_tab");
  table2.deleteRow(index2);
  
  }

//显示桌子当前信息
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
    			a2num.innerHTML = "<span >" +tid + "</span>";
    			if(mation == 1){
    			    a2state.innerHTML = "<span>有人</span>";
    			} else {
    				a2state.innerHTML = "<span>空桌</span>";
    			}
    			a2name.innerHTML = "<span>" + mation[2] + "</span>";
    			a2orderid.innerHTML = "<span id = 'oid'>" + mation[3] + "</span>";
    			//alert(a2orderid);
    			a2all.innerHTML = "<span>" + mation[4] + "<span>";
    			
    			if(document.getElementById("oid").innerHTML == "空") {
    				document.getElementById("table_order").disabled = true;
    			} else {
    				document.getElementById("table_order").disabled = false;
    			}
    		}
    	}
    }
    
    //创建连接
    xhr.open("get","/restaurant/servlet/orderServlet?tid=" + tid + "&method=findCurrentOrder");
    xhr.send(null);
    
}

//选择点击，目录栏
function g(x){
	if(x=="order") {
		showOrders();       //三天内所有订单
    }
	if(x=="name") {
		showAllMenu();     //获取所有菜品
	}
	if (x=="costumer") {
		showAllCostumer();
	}
	if(x=="boss") {
		showAllUser();
	}
	if(x == "table") {
		window.location.href="/restaurant/servlet/tablesServlet?method=queryAll";
	}
       d=document.getElementsByTagName('li');
           for(p=d.length;p--;){
                    if(d[p].id!=x){d[p].style.color='black'/*其他*/}
                   else{d[p].style.color='pink'/*点击的*/}
                }
       
   }

