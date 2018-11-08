<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" href="${pageContext.request.contextPath}/css/backstage-css.css" rel="stylesheet">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/backstage.js">
    </script>
<title>Insert title here</title>
</head>
<body>
	<div class="mainpart">
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
       
        <div class="table_message" id="table_message"><!--原来拥有的桌子-->
        <div class="table_messag" id="table_inquire">
        <!-- 桌子循环 -->
          <c:forEach items = "${sessionScope.tablelist}" var = "table" >
            <div id="ttable " class="table_name"onclick="showmain(${table.tid })">
                <div class="table_img" id="table_img">
                    <img  class="img" src=""><!--桌子地址-->
                </div>

<%--                 <c:forEach items="接收集合对象" var="迭代参数名称" varStatus="迭代状态，可访问迭代自身信息"> --%>     
                <div id="table5"  class="table_table">
                    <div id="num" class="table_num">桌子编号：${table.tid }</div>
                    <div id="history_order" class="table_order">历史订单</div>
                    <div id="tabbleid" class="table_id">桌子类型：${table.tvariety }人</div>
                </div>
            </div>
             </c:forEach>
            <div class="add" id="table_add">
                <img src="QQ截图20181020203629.png" onclick="newdiv()">
                <input type="button"value="保存" class="save" id="keep" name="baocun" style="float:right">
            </div>
        </div>
        
         <div class="tablemain"  id="table_main" style="display: none";><!--桌子信息-->
            <table class="mainone">
                <tr class="row">
                    <td class="a1" id="a1num">桌子编号</td>
                    <td class="a1" id="a1zhuangtai">桌子状态</td>
                    <td class="a1" id="a1name">用户姓名</td>
                </tr>
                <tr class="row1" id="row1">
                     <td class="a2" id="a2num"></td>
                     <td class="a2" id="a2id"></td>
                     <td class="a2" id="a2name"></td>
                 </tr>
              
            </table>
           <div class="orderxq" id="table_xq">
                订单详情
            </div> 
        </div> 
        
    </div>
        <div class="costumer_message" id="costumer_message" style="display: none">
            <div class="inquire" id="costumer_inquire">
                <div class="user_name" id="costumer_name"><!--查询用户-->
                    <input type="text" name="yonghuming" class="user" id="userming">
                    <input type="button" value="查询" name="chaxun" class="search" id="sear" onclick="bottom()">
                </div>
            </div>
                <table class="usermaina"><!--顾客信息-->
                    <tr class="user_maina">
                        <td class="user_a1id">用户ID</td>
                        <td class="user_a1iname">用户名</td>
                        <td class="user_a1idpas">用户密码</td>
                        <td class="bianji"></td>
                        <td class="userxqa">用户详情</td><!--链接-->

                    </tr>
                    <tr class="user_mainb">
                        <td class="user_a2id">aaa</td>
                        <td class="user_a2iname">aaa</td>
                        <td class="user_a2idpas">aaa</td>
                    </tr>
                </table>

            <div class="costumertable" id="costumer_tabla" style="display: none"><!--查询后的得到顾客的信息-->
                <table class="costumer_tab">
                    <tr class="row">
                        <td id=" t1id" class="t1">用户ID
                        </td>
                        <td id="t1name" class="t1">用户名</td>
                        <td id="t1pas" class="t1">用户密码</td>
                        <td id="yonghudingdan" class="t1">用户订单</td><!--链接-->
                    </tr>
                    <tr class="row1">
                        <td id="t2id" class="t2">aaa</td>
                        <td id="t2name" class="t2">aaa</td>
                        <td id="t2pas" class="t2">aaa</td>
                    </tr>
                </table>

            </div>
        </div>
    </div>
</div>
</body>
</html>