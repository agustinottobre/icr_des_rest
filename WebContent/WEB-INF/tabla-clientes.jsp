<%-- <%@page import="stc.model.entities.Cliente"%> --%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
        <h3 class="customH3"><%=(String) request.getAttribute("clientes-response")%></h3>
        
		<div class="CSSTableGenerator" align="center">
            <table >
                <tr>
                    <td>
                        id
                    </td>
                    <td >
                        Razon Social
                    </td>
                </tr>
		        <%
// 				  List listaClientes = (List) request.getAttribute("lista-clientes");
// 				  Iterator it = listaClientes.iterator();
// 				  while(it.hasNext()) {
// 				    //out.print("<br>try: " + it.next());
// 				    Cliente cli = (Cliente)it.next();
// 				    out.print("<tr >");
// 				    out.print("<td >" + cli.getId() + "</td>");
// 				    out.print("<td >" + cli.getRazonSocial() + "</td>");
// 				    out.print("</tr >");
// 				  }
				%>
            </table>
        </div>
