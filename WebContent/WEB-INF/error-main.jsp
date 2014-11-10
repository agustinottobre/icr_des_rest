<h1><img src="img/stop.png" style="vertical-align: middle; padding-right:20pt;"/>Error Modulo Despacho</h1>
						<% 						
// 						if(null != request.getSession().getAttribute("error").toString()){
// 							out.print(request.getSession().getAttribute("error").toString());
// 						}else{
						if(null != (String) request.getAttribute("error")){
							out.print((String) request.getAttribute("error"));
						}else{
							out.print("<p>Despacho - No encuentra el contenido solicitado.</p>");
						}
						%>
