<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <!--[if lt IE 9]>
    <script type="text/javascript" src="lib/html5.js"></script>
    <script type="text/javascript" src="lib/respond.min.js"></script>
    <script type="text/javascript" src="lib/PIE_IE678.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.css" />
    <link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.7/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="lib/icheck/icheck.css" />
    <link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css" />
    <!--[if IE 6]>
    <script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <title>菜品类别</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 菜品 <span class="c-gray en">&gt;</span> 菜品类别 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <div class="text-c"> 
        <button type="submit" class="btn btn-success radius" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 菜品类别</button>
        <!-- <button type="submit" class="btn btn-success radius r" id="" name="">排序</button> -->
    </div>

<div class="row"style="padding-top: 20px;">
    <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
        <div class="info-box1 bg-fff">
            <p class="p1"></p>
            <p class="p2"><a title="添加" href="caipin-add.jsp"><i class="Hui-iconfont r" style="margin:0px 100px;" >&#xe600;</i></a></p>
            <p></p>
        </div>

    </div>
    <c:forEach items="${type }" var="t" varStatus="vs" >
	    <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
	        <div class="info-box1 bg-fff">
	            <p class="p1"><a style="text-decoration:none" class="ml-5" onClick="caipin_del(this,'${t.dishtypeid}')" href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a><a style="text-decoration:none" class="ml-5"  href="caipin-edit.jsp?dishtypeid=${t.dishtypeid }" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a></p>
	            <p class="p3">${t.dishtype }</p>
	            <p></p>
	        </div>
	    </div>
    </c:forEach>
    <!-- <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
        <div class="info-box1 bg-fff">
            <p class="p1"><a style="text-decoration:none" class="ml-5" onClick="caipin_del(this,'10001')" href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a><a style="text-decoration:none" class="ml-5" onClick="caipin_edit('菜品编辑','caipin-edit.html','1','500','300')" href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a></p>
            <p class="p3">菜品</p>
            <p></p>
        </div>
    </div> -->
   
    
    
        </div>
</div>
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="lib/layer/2.1/layer.js"></script>
<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="lib/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script>
<script type="text/javascript">
    $(function(){
        $('.table-sort').dataTable({
            "aaSorting": [[ 1, "desc" ]],//默认第几个排序
            "bStateSave": true,//状态保存
            "aoColumnDefs": [
                //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
                {"orderable":false,"aTargets":[0,8,9]}// 制定列不参与排序
            ]
        });
        $('.table-sort tbody').on( 'click', 'tr', function () {
            if ( $(this).hasClass('selected') ) {
                $(this).removeClass('selected');
            }
            else {
                table.$('tr.selected').removeClass('selected');
                $(this).addClass('selected');
            }
        });
    });
    /*
     参数解释：
     title	标题
     url		请求的url
     id		需要操作的数据id
     w		弹出层宽度（缺省调默认值）
     h		弹出层高度（缺省调默认值）
     */
    /*用户-添加*/
    function caipin_add(title,url,w,h){
        layer_show(title,url,w,h);
    }
    /*用户-查看*/
    function member_show(title,url,id,w,h){
        layer_show(title,url,w,h);
    }

    /*用户-编辑*/
    function caipin_edit(title,url,id,w,h){
        layer_show(title,url,w,h);
    }
    /*密码-修改*/
    function change_password(title,url,id,w,h){
        layer_show(title,url,w,h);
    }
    /*用户-删除*/
    function caipin_del(obj,id){
        layer.confirm('确认要删除吗？',function(index){
        
        	location.href="dishTypeServlet?dishtypeid="+id+"&method=delete";
            $(obj).parents(".col-md-3").remove();
            layer.msg('已删除!',{icon:1,time:1000});
        });
    }
</script>
</body>
</html>