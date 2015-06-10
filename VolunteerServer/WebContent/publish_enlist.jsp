<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<title>发布招募</title>
<link rel="stylesheet" href="<%=basePath %>css/mystyle1.css"/>
<style type="text/css">
#menu ul{
	width:1340px;
}
#text2 p{
	margin-left:25px;
	font-size:22px;
}
#text2 input{
	color:#666;
	height:22px;
	font-size:16px;
}
a{
	text-decoration:none;
}
#bq{
	width:1346px;
}
</style>
</head>
<%=basePath %>
<body>
<div id="zy1">
	<div id="menu">
  <ul>
    		<li id="frist"><a href="服务中心.html"><b>服务中心</b></a></li>
        	<li id="end"><a href="登陆界面.html"><b>退出</b></a></li>
      </ul>
    </div>
</div>
<div id="main">
	<div id="navigation">
        <ul>
            <li id="active" class="frist"><a href="通告.html">通告</a></li>
            <li><a href="发布招募.html">发布招募</a></li>
            <li><a href="我的发布.html">我的发布</a></li>
            <li><a href="筛选志愿者.html">筛选志愿者</a></li>
            <li class="last"><a href="我的资料.html">我的资料</a></li>
        </ul>
    </div>
	<div id="text">
        <div id="text2">
        	<h1>发布招募</h1>
            <div id="tx2">
            	<img src="images/志愿者.jpg" />
                <p><input type="f" value="选择照片"  style="color:#000; width:80px; height:30px;"/></p>
            </div>
            <p>招募标题：<input name="textfield1" type="text" value="请输入招募标题" onfocus="if (value =='请输入招募标题'){value =''}" onblur="if (value ==''){value='请输入招募标题'}"  style="width:177px"/></p>
            <p>服务类型：<select>
                    <optgroup value="Swedish Cars">
                    <option value ="qs" selected="selected">青少</option>
                    <option value ="jl">敬老</option>
                    <option value ="bm">便民</option>
                    <option value ="fp">扶贫</option>
                    <option value ="hb">环保</option>
                    <option value ="wt">文体</option>
                    <option value ="zc">助残</option>
                    </optgroup>
                </select>
                </p>
               <p>招募人数：<input name="textfield1" type="text" value="请输入招募人数" onfocus="if (value =='请输入招募人数'){value =''}" onblur="if (value ==''){value='请输入招募人数'}"  style="width:177px"/></p>
            <p>活动时间：<input name="textfield1" type="text" value="请输入活动时间" onfocus="if (value =='请输入活动时间'){value =''}" onblur="if (value ==''){value='请输入活动时间'}"  style="width:177px"/></p>
            <p>截止时间：<input name="textfield1" type="text" value="请输入截止时间" onfocus="if (value =='请输入截止时间'){value =''}" onblur="if (value ==''){value='请输入截止时间'}"  style="width:177px"/></p>
            <p>活动地点：<select>
                    <optgroup value="Swedish Cars">
                    <option value ="gds" selected="selected">广东省</option>
                    </optgroup>
                </select>
                <select>
                    <optgroup value="Swedish Cars">
                    <option value ="gzs" selected="selected">广州市</option>
                    </optgroup>
                </select>
                <select>
                    <optgroup value="Swedish Cars">
                    <option value ="thq" selected="selected">天河区</option>
                    <option value ="yxq">越秀区</option>
                    <option value ="hzq">海珠区</option>
                    <option value ="byq">白云区</option>
                    <option value ="hbq">黄埔区</option>
                    <option value ="pyq">番禺区</option>
                    <option value ="lwq">荔湾区</option>
                    <option value ="lgq">罗岗区</option>
                    <option value ="nsq">南沙区</option>
                    <option value ="hdq">花都区</option>
                    <option value ="chs">从化市</option>
                    <option value ="zcs">增城市</option>
                    </optgroup>
                </select>
                <input name="textfield1" type="text" value="请输入活动地点" onfocus="if (value =='请输入活动地点'){value =''}" onblur="if (value ==''){value='请输入活动地点'}"  style="width:177px"/>
            </p>
            <p>联 系 人：<input name="textfield1" type="text" value="请输入联系人姓名" onfocus="if (value =='请输入联系人姓名'){value =''}" onblur="if (value ==''){value='请输入联系人姓名'}"  style="width:277px"/></p>
            <p>联系电话：<input name="textfield1" type="text" value="请输入电话号码" onfocus="if (value =='请输入电话号码'){value =''}" onblur="if (value ==''){value='请输入电话号码'}"  style="width:277px"/></p>
            <p>联系邮箱：<input name="textfield1" type="text" value="请输入常用邮箱" onfocus="if (value =='请输入常用邮箱'){value =''}" onblur="if (value ==''){value='请输入常用邮箱'}"  style="width:155px"/>
            	<select>
                    <optgroup value="Swedish Cars">
                    <option value ="163" selected="selected">@163.com</option>
                    <option value ="qq">@qq.com</option>
                    <option value ="sina">@sina.com</option>
                    <option value ="sohu">@sohu.com</option>
                    </optgroup>
                </select>
            </p>
            <p><span id="wbk">活动描述：</span><textarea style=" width:277px; color:#666;" value="请输入关于活动的描述" onfocus="if (value =='请输入关于活动的描述'){value =''}" onblur="if (value ==''){value='请输入关于活动的描述'}"></textarea></p>
            <p><a href="通告.html"><input type="button"  value="提交" style="margin:5px; padding:3px; width:120px; height:32px; color:#000; margin-left:100px"/></a>
               <a href="发布招募.html"><input type="button" value="取消" style="margin:5px; margin-left:122px; padding:3px; width:120px; height:32px; color:#000;" /></a></p>
        </div>
  </div>
<div id="bq">
    	<ul>
        	<li id="one"><a href="关于我们.html"><b>关于我们</b></a></li>
            <li><a href="服务条款.html"><b>服务条款</b></a></li>
            <li><a href="帮助中心.html"><b>帮助中心</b></a></li>
    </ul>
  </div>
</div>
</body>
</html>
