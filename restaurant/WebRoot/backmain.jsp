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
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/backstage2.js">
    </script>
</head>
<body>
	<div class="container-fluid">
    <div class="loge">
        <div class="fonta">
        <div class="font">餐</div>
        <div class="font">厅</div>
        <div class="font">管</div>
        <div class="font">理</div>
        <div class="font">系</div>
        <div class="font">统</div>
    </div>
    </div>
    <div class="mainbar1">
    <div class="leftpart">
        <ul class="list" id="list">
            <li class="table" id="table">桌子信息</li>
        <li class="costumer" id="costumer">顾客信息</li>
        <li class="order" id="order">订单信息</li>
        <li class="mene" id="name">菜品信息</li>
        <li class="boss" id="boss">老板信息</li>
        </ul>
    </div>
    <div class="partright" id="partright">
        <div class="table_message" id="table_message" style="display:"><!--原来拥有的桌子-->
        <div class="table_messag" id="table_inquire">
         <c:forEach items = "${sessionScope.tablelist}" var = "table" >
            <div id="ttable " class="table_name"onclick="showmain(${table.tid})">
                <div id="table_img" class="table_img">
                    <img  class="img" src="${table.timg }"><!--桌子地址-->
                </div>
                <div id="table5"  class="table_table">
                    <div id="num" class="table_num">桌子编号：${table.tid }</div>
                    <div id="history_order" class="table_order">历史订单</div>
                    <div id="tabbleid" class="table_id">桌子类型：${table.tvariety }人</div>
                </div>
            </div>
            </c:forEach>
         
            <div id="add" class="table_add">
                <img src="image/20181020203629.png"  onclick="newdiv()"/>
                <input type="button"value="保存" class="save" id="keep" name="baocun" onclick = "save()" style="float:right" >
            </div>
        </div>



        <div class="tablemain"  id="table_main" style="display: none";><!--桌子信息-->
            <table class="mainone">
                <tr class="row2">
                    <td class="a1" id="a1num">桌子编号</td>
                    <td class="a1" id="a1zhuangtai">桌子状态</td>
                    <td class="a1" id="a1name">用户姓名</td>
                    <td class="a1" id="order-num">订单ID</td>
                    <td class="a1" id="all">总价</td>
                    <td class="a1" id="table_xq">
                        订单详情
                    </td>
                </tr>
                    <tr class="row1">
                        <td class="a2" id="a2num"></td>
                <td class="a2" id="a2zhuozizhuangtai"></td>
                <td class="a2" id="a2name"></td>
                        <td class="a2" id="a2orderid"></td>
                        <td class="a2" id="a2all"></td>
                    </tr>
            </table>
        </div>
    </div>
        <div class="costumer_message" id="costumer_message" style="display:none ">
            <div id="inquire" class="costumer_inquire">
                <div class="costumer_name" id="user_name"><!--查询用户-->
                    <input type="text" name="username" class="user" id="userming">
                    <input type="button" value="查询" name="chaxun" class="search" id="sear" onclick="bottom()">
                </div>
            </div>
                

            <div class="costumertable" id="costumer_tabla" ><!--查询后的得到顾客的信息-->
                <table class="costumer_tab">
                    <tr class="rowa">
                        <td id=" t1id" class="t1">订单ID</td>
                        <td id="t1tid" class="t1">桌子id</td>
                        <td id="t1name" class="t1">用户名</td>
                        <td id="t1lprice" class="t1">总价</td>
                        <td id="t1state" class="t1">状态</td>
                        <td id="shanchu0" class="t1">删除</td><!--链接-->
                        <td id="userxqa1" class="t1">订单详情</td><!--链接-->
                    </tr>
                  <c:forEach items = "${sessionScope.userByName.orders }" var = "order">
                    <tr class="rowb">
                        <td id="t2id" class="t1">${order.oid }</td>
                        <td id="t2tid" class="t1">${order.tid }</td>
                        <td id="t2name" class="t1">${sessionScope.userByName.uname }</td>
                        <td id="t2price" class="t1">${order.allprice }</td>
                        <td id="t2state" class="t1">${order.ostate }</td>
                        <td id="shanchu1" class="u1"><img src="image/shanchu.png"></td>
                    </tr>
                  </c:forEach> 
                </table>

            </div>
        </div>
        <div class="order_message">
            <div class="searchall">
               
            </div>
        </div>
    </div>
</div>
</div>
</body>
</html>