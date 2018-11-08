<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri= "http://java.sun.com/jsp/jstl/core"  prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" href="${pageContext.request.contextPath}/css/backstage-css.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/backstage.js">
    </script>
</head>
<body>
	<div class="container-fluid">
        <div class="loge">
            <div class="logo0">
        <div class="fonta">
        <div class="font">餐</div>
        <div class="font">厅</div>
        <div class="font">管</div>
        <div class="font">理</div>
        <div class="font">系</div>
        <div class="font">统</div>
        </div>
    </div>
    </div>
    <div class="mainbar1">
    <div class="lb">
    <div class="leftpart">
        <ul class="list" id="list">
            <li class="table" id="table" onclick="g(this.id)">桌子信息</li>
        <li class="costumer" id="costumer" onclick="g(this.id)">顾客信息</li>
        <li class="order" id="order" onclick="g(this.id)">订单信息</li>
        <li class="menu" id="name"onclick="g(this.id)">菜品信息</li>
        <li class="boss" id="boss"onclick="g(this.id)">老板信息</li>
        </ul>
    </div>
    </div>
    
    <div class="partright" id="partright">
        <div class="table_message" id="table_message"><!--原来拥有的桌子-->
        <div class="table_messag" id="table_inquire">
        
        <c:forEach items = "${sessionScope.tablelist}" var = "table" >
            <div id="ttable " class="table_name">
                <div id="table_img" class="table_img" onclick="showmain(${table.tid })">
                    <img  class="img" src=""><!--桌子地址-->
                </div>
                <div id="table5"  class="table_table">
                    <div id="num" class="table_num" value= "${table.tid }">桌子编号：${table.tid }</div>
                    <div id="tabbleid" class="table_id">桌子类型：${table.tvariety }人</div>
                    <div id="history_order" class="table_order" >历史订单</div>
                </div>
            </div>
            </c:forEach>
            <div id="add" class="table_add">
                <img src="image/20181020203629.png" onclick="newdiv()">
                <input type="button"value="保存" class="save" id="keep" name="baocun" style="float:right" onclick = "save()">
            </div>
        </div>



        <div class="tablemain"  id="table_main" style="display: none"><!--桌子信息-->
            <table class="mainone">
                <tr class="rownew">
                    <td class="a1" id="a1num">桌子编号</td>
                    <td class="a1" id="a1zhuangtai">桌子状态</td>
                    <td class="a1" id="a1name">用户姓名</td>
                    <td class="a1" id="order-num">订单ID</td>
                    <td class="a1" id="all">总价</td>

                </tr>
                    <tr class="rownew">
                        <td class="a2" id="a2num"></td>
                <td class="a2" id="a2zhuozizhuangtai"></td>
                <td class="a2" id="a2name"></td>
                        <td class="a2" id="a2orderid"></td>
                        <td class="a2" id="a2all"></td>
                        <td class="a1" id="table_xq"><input  type="button" class="table_order0" id="table_order" value="订单详情"  >
                        </td>
                    </tr>
            </table>
        </div>
    </div>
        <div class="costumer_message" id="costumer_message" style="display: none">
            <div id="inquire" class="costumer_inquire">
                <div class="costumer_name" id="user_name">
                    <div class="costumer_group"><!--查询用户-->
                    <input type="text" name="yonghuming" class="user" id="userming">
                    <input type="button" value="用户名查询" name="chaxun" class="search" id="sear" onclick="bottom()">
                </div>
            </div>
               <!-- <table class="usermaina"><!--顾客信息
                    <tr class="user_maina">
                        <td id="user_a1id" class="u1">用户ID</td>
                        <td id="user_a1iname" class="u1">用户名</td>
                        <td id="user_a1idpas" class="u1">用户密码</td>
                        <td id="bianji" class="u1">删除</td>
                        <td id="userxqa" class="u1">订单详情</td><!--链接

                    </tr>
                    <tr class="user_mainb">
                        <td id="user_a2id" class="u1">aaa</td>
                        <td id="user_a2iname" class="u1">aaa</td>
                        <td id="user_a2idpas" class="u1">aaa</td>
                        <td id="shanchu" class="u1"><img src="shanchu.png"></td>
                    </tr>
                </table>-->

            <div class="costumer_table" id="costumer_tabla" ><!--查询后的得到顾客的信息-->
                <table class="costumer_tab" id="costumer_tab">
                    <tr class="row2">
                        <td id=" t1id" class="t1">用户ID</td>
                        <td id="t1name" class="t1">用户名</td>
                        <td id="t1pas" class="t1">用户密码</td>
                        <td id="shanchu0" class="t1">删除</td><!--链接-->
                       <!--链接-->
                    </tr>
                    <c:forEach items ="${sessionScope.costumerlist}" var = "costumer" >
                    <tr class="row1">
                        <td id="t2id" class="t1">${costumer.uid }</td>
                        <td id="t2name" class="t1">${costumer.uname }</td>
                        <td id="t2pas" class="t1">${costumer.upassword }</td>
                        <td id="shanchu1" class="u1" onclick="deleteRowa(this)"><img src="image/shanchu.png"></td>
                        <td id="userxqa1" class="t1"><input type="button"  id="aaabbb" class="aaab" value="订单详情" username = "${costumer.uname }" onclick = "orderbyUser(this)"></td>
                    </tr>
                    </c:forEach>
                </table>

            </div>
            </div>
        </div>
        <div class="order_message" style="display: none">
            <div class="order_inquire">
               用户名:<input type="text"  class="seara" name="duoyangsousuo" id="searchb"><br>
                订单ID:<input type="text"  class="seara" name="duoyangsousuo" id="searchc"><br>
                <input type="button" class="searchall" name="aootijiao" id="submit1" value="查询" onclick = "searchorders()">
            </div>
            <div class="order_main" id = "showorder">
            <c:forEach items = "${sessionScope.orderlist}" var = "orders" > 
             <div class="order_table" id = "showorder">
                 <table class="userbill">
                     <tr class="rowc">
                         <td class="ro1" id="tableida">桌子ID</td>
                         <td class="ro2" id="ida">${orders.tid }</td>

                     </tr>
                     <tr class="rowc"><!--食物的种类即个数-->
                         <td class="ro1" id="orderida"><nobr>订单ID</nobr></td>
                         <td class="ro2" id="ordera">${orders.oid }</td>
                     </tr>
                     <tr class="rowc">
                         <td class="ro1" id="userida">用户ID</td>
                         <td class="ro2" id="usera">${orders.uid }</td>

                     </tr>
                     <tr class="rowc">
                         <td class="ro1" id="food">菜品</td>
                         <td class="ro2" id="jaige">价格/份数</td>

                     </tr>
                     <c:forEach items = "${orders.orderitems }" var = "orderitem">
                     <tr class="rowc"><!--食物的种类即个数-->
                         <td class="ro1" id="food1"><nobr>${orderitem.product.pname }</nobr></td>
                         <td class="ro2" id="price">￥${orderitem.product.pprice }*${orderitem.buynum }</td>

                     </tr>
                     </c:forEach>
                     <tr class="rowc"><!--食物的种类即个数-->
                         <td class="ro1" id="allmoney"><nobr>总价</nobr></td>
                         <td class="ro2" id="doller">￥${orders.allprice }</td>
                     </tr>
                     <tr class="rowc"><!--食物的种类即个数-->
                         <td class="ro1" id="statea"><nobr>状态</nobr></td>
                         <td class="ro2" id="state">已支付</td>
                     </tr>
                 </table>
                </div>
                </c:forEach>
        </div>
    </div>
        <div class="menu_message" style="display:none ">
            <div class="menu_main">
            <div class="menu_css" >
           <table class="foodzhonglei" id = "foodzhonglei">
                    <p class="aa10">菜品分类</p>
                    <tr class="row9">
                   <c:forEach items = "${sessionScope.alltype}" var = "all" > 
                    <td class="lei" id="lei0${all.ptid }"  onclick= "typemenu(this)" value = "${all.ptid }" >
                       ${all.ptname }<img  class="imglei"  id="lei0${all.ptid }_a" src="image/enrro.png" style="display: none"  onclick= "deleteType(this)" value = "${all.ptid }"></td>
            </c:forEach>
           </tr>
            <!--   <table class="foodzhonglei" id = "foodzhonglei">
                    <p class="aa10">菜品分类</p>
                    <tr class="row9">
                   <c:forEach items = "${sessionScope.alltype}" var = "all">
                   <td class="lei" id="lei0" onclick = "typemenu(this);azx(this)" value = "${all.ptid }">
                    ${all.ptname }<img  class="imglei1"  id="lei0_a" src="image/enrro.png" style="display: none" onclick = "deleteType(this)" value = "${all.ptid }"></td>
                    </c:forEach>
                  <!--   <td class="lei" id="lei1" >
                        红烧排骨红烧牛肉面<img  class="imglei" id="lei1_a" src="image/enrro.png" alt="null" style="display: none" ></td> 
                    </tr>
                    <tr class="row8">
                    </tr>-->
                </table>
                </div>
            <div id="menu_inquire" class="menu_inquire">
                    <!--查询用户-->
                        <input type="text" name="menu-search" class="menu0" id="menuming">
                        <input type="button" value="查询" name="menu-chaxun" class="menu-search" id="searmenu" onclick="searchmenu()">
                </div>
                <div class="menu_add">
                <input type="button" value="添加" class="madd" id="menu_add" name="zengtian" onclick="addnew()">
                <div class="menu_table" id="menu_tabla" ><!--查询后的得到顾客的信息-->
                    <table class="costumer_tab" id="rowcel">
                        <tr class="rowa">
                            <td id=" m1id" class="t1">菜品类别
                            </td>
                            <td id="m1name" class="t1">菜品名称</td>
                            <td id="m1pas" class="t1">菜品价格</td>
                            <td id="m1zhuangtai" class="t1">菜品状态</td>
                            <td id="shanchu3" class="t1">删除</td>
                           <!-- <td id="menuorder" class="t1">编辑</td>-->
                        </tr>
                    	<c:forEach  items = "${sessionScope.allproduct }" var = "all">
                        <tr class="rowb">
                            <td id="m2id" class="t1" ondblclick="ShowElement(this);chuxian()">${all.product_type.ptname }</td>
                            <td id="m2name" class="t1" ondblclick="ShowElement(this);chuxian()">${all.pname}</td>
                            <td id="m2pas" class="t1" ondblclick="ShowElement(this);chuxian()">${all.pprice }</td>
                            <td id="m2zhuangtai" class="t1" ondblclick="ShowElement(this);chuxian()">${all.pstate }</td>
                            <td id="shanchu2" class="b1" onclick="deleteRow0(this)" value ="${all.pname}"><img src="image/shanchu.png"></td>
                            <!--<td id="m2biabji" class="t1" ><img src="index.png"></td>-->
                            <td id="ok" class="newc"><input type="submit" class="new_name1" id="bottom_pickup" name="querentijiao" style="display: none" value="确定" pid = "${all.pid }" onclick="xiaoshi(this)"></td>
                        </tr>
                        </c:forEach>
                        <!--<tr class="rowa" id="new_row">
                            <td id="nwe_t1" class="t11"><input type="text" id="new_id" class="new_name0"></td>
                            <td id="new_t2" class="t12"><input type="text" id="new_name" class="new_name0"></td>
                            <td id="new_t3" class="t13"><input type="text" id="new_prise" class="new_name0"></td>
                            <td id="new_t4" class="t14"><input type="text" id="new_zhuangtai" class="new_name0"></td>
                            <td id="new_t5" class="new"><img  class="abc" src="shanchu.png"></td>
                            <td id="new_t6" class="new0"><img src="index.png"></td>
                        </tr>-->
                    </table>
                </div>

</div>
            </div>
</div>
        <div class="boss_message" style="display: none">
            <div class="boss_inquire">
                员工姓名:<input type="text" class="employ0" id="employ01" name="employzhuce"><br>
                密码:<input type="password" class="employ2" id="employ21" name="employpas"><br>
                <input type="button" class="employ1" id="employ11" name="employtijiao" value="注册" onclick="register()"><span id = "msg"></span>
            </div>
            
			<div id = "userall" class="boss_abc">
                <table class="employ_main" id="rowemp">
                   
                    <tr class="emp1">
                        <td class="emp10">员工姓名
                        </td>
                        <td class="emp10">员工密码
                        </td>
                        <td class="emp10">删除
                        </td>
                    </tr>
                   <c:forEach items = "${sessionScope.userlist }" var = "user">
                    <tr  class="emp2">
                        <td class="emp20" id="emp20" ondblclick="ShowElement(this);chuxian0()" >${user.uname }</td>
                        <td class="emp20" id="enp21" ondblclick="ShowElement(this);chuxian0()" >${user.upassword}</td>
                        <td class="emp2a" id="emp22"onclick="deleteRow(this)"value ="${ user.uname}"><img src="image/shanchu.png"></td>
                        <td class="ok0" id="ok0" style="display: none"  onclick="xiaoshi0()"><input type="submit" value="确定"></td>
                    </tr>
                 </c:forEach>
                </table>
              </div>

        </div>
</div>
    </div>
</div>
<img src="image/enrro.png" class="imglei1">
</body>
</html>