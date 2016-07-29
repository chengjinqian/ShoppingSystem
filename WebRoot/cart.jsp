<%@page import="entity.Item,entity.Cart"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'cart.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link type="text/css" rel="stylesheet" href="css/style1.css" />
	<script type="text/javascript">
		function delcfm(){
			if(!confirm("确认要删除？")){
				window.event.returnValue = false;		//超链接不执行	
			}
		}
	
	</script>
	
	
	
  </head>
  
  <body>
  	<h1>我的购物车</h1>
  	<a href='index.jsp'>首页</a>>><a href='index.jsp'>商品列表</a>
  	<hr>
  	<div id='shopping'>
  	<form action='' method=''>
  		<table>
  			<tr>
  				<th>商品名称</th>
  				<th>商品单价</th>
  				<th>商品价格</th>
  				<th>购买数量</th>
  				<th>操作</th>
  			</tr>
  			<%
  				if(request.getSession().getAttribute("cart")!=null){
  					Cart cart = (Cart)request.getSession().getAttribute("cart");
  					HashMap<Item,Integer> goods = cart.getGoods();
  					Set<Item> items = goods.keySet();
  					Iterator<Item> iter = items.iterator();
  					
  					while(iter.hasNext()){
  						Item item = iter.next();
  			 %>
  			 
  			 <tr name='products' id='product_id_1'>
  			 	<td class='thumb'><img src='images/<%=item.getPicture()%>'><a href=''><%=item.getName() %></a></td>
				<td class="number"><%=item.getPrice() %></td>
				<td class="price" id="price_id_1">
					<span><%=item.getPrice()*goods.get(item) %></span>
					<input type="hidden" value="" />
				</td>
				<td class="number">
                     	<%=goods.get(item)%>					
				</td>
				<td class="delete">
					<a href='servlet/CartServlet?action=delete&id=<%=item.getId() %>' onclick="delcfm">删除</a>
				</td>  			 
  			 </tr>
  			 <%
  			 		}
  			  %>
  		</table>
  		 <div class="total"><span id="total">总计：<%=cart.getTotalPrice() %>￥</span></div>
  		 	 <%
  		 	 }
  		 	  %>
  	</form>
  	
  	</div>
  </body>
</html>
