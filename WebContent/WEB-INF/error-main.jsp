<h1><img src="img/stop.png" style="vertical-align: middle; padding-right:20pt;"/>Error AGW</h1>
						<% 						
// 						if(null != request.getSession().getAttribute("error").toString()){
// 							out.print(request.getSession().getAttribute("error").toString());
// 						}else{
						if(null != (String) request.getAttribute("error")){
							out.print((String) request.getAttribute("error"));
						}else{
							out.print("<p>AGW No encuentra el contenido solicitado.</p>");
						}
						%>
