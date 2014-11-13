<%-- <%@page import="dto.ItemCartaDTO"%> --%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Properties"%>
<%@page import="dto.ItemSolicitudArticuloDTO"%>
<%@page import="dto.SolicitudArticuloDTO"%>
<%@page import="dto.ArticuloDTO"%>
<%@page import="java.util.List"%>
<%-- <%@page import="dto.ItemComandaDTO"%> --%>
<%@page import="java.util.Iterator"%>
<%-- <%@page import="dto.ComandaDTO"%> --%>
<h2><img src="img/home.png" style="width: 25px; height: 25px;  middle; padding-right:20pt;"/>Solicitudes de Articulos</h2>
<p>Propiedades...</p>

<%
	Properties propiedades = (Properties)request.getAttribute("propiedades");

// 	Set<Object> keysLogistica = new HashSet<Object>();
// 	Set<Object> keysDeposito = new HashSet<Object>();
// 	Set<Object> keysPortal = new HashSet<Object>();
// 	Set<Object> keysVarias = new HashSet<Object>();

// 	Set<Object> keys = propiedades.keySet();
// 	for(Object key : keys){
// 		String keyStr = (String) key;
// 		if(keyStr.matches("logistica-(.*)")){
// 			keysLogistica.add(key);			
// 		}else if(keyStr.matches("deposito-(.*)")){
// 			keysDeposito.add(key);
// 		}else if(keyStr.matches("portal-(.*)")){
// 			keysPortal.add(key);
// 		}else{
// 			keysVarias.add(key);
// 		}
// 	}
// 	System.out.println(keysLogistica.size());
// 	System.out.println(keysDeposito.size());
// 	System.out.println(keysPortal.size());
// 	System.out.println(keysVarias.size());

// 	Object[] oo = keysLogistica.toArray();
// 	for(Object o : oo){
// 		System.out.println(o);	
// 	}

%>

	<div class="container container-fluid">
		<div id="content" class="row-fluid">
			<div class="span10">
				<div class="row-fluid">
				<form id="propiedades_form" action="accion?accion=guardar" method="POST" class="form-horizontal">
<!-- 					<h1>Mesas</h1> -->
					<input class="btn btn-blue pull-left" type="submit" value="guardar" />
					<div class="row-fluid">
						<div class="span12">
							<div class="row-fluid">
								<h4>Logistica</h4>
								<table class="table table-striped table-hover">
									<thead>
										<tr>
											<td>nro</td>
											<td>id modulo</td>
											<td>host</td>
											<td>path</td>
										</tr>
									</thead>
									<tfoot>
										<tr>
											<td>nro</td>
											<td>id modulo</td>
											<td>host</td>
											<td>path</td>
										</tr>
									</tfoot>
									<tbody>
								        <%
											out.print("<tr id_propiedad=" + "logistica-rest-id1" + ">");
								        	out.print("<td>1</td>");
											out.print("<td ><input name=\"" + "logistica-rest-id1" + "\" type=text value=\""  + propiedades.getProperty("logistica-rest-id1") + "\"</td>");
											out.print("<td ><input name=\"" + "logistica-rest-host1" + "\" type=text value=\""  + propiedades.getProperty("logistica-rest-host1") + "\"</td>");
											out.print("<td ><input name=\"" + "logistica-rest-path-cambioestado1" + "\" type=text value=\""  + propiedades.getProperty("logistica-rest-path-cambioestado1") + "\"</td>");
											out.print("</tr >");
											
											out.print("<tr id_propiedad=" + "logistica-rest-id2" + ">");
											out.print("<td>2</td>");
											out.print("<td ><input name=\"" + "logistica-rest-id2" + "\" type=text value=\""  + propiedades.getProperty("logistica-rest-id2") + "\"</td>");
											out.print("<td ><input name=\"" + "logistica-rest-host2" + "\" type=text value=\""  + propiedades.getProperty("logistica-rest-host2") + "\"</td>");
											out.print("<td ><input name=\"" + "logistica-rest-path-cambioestado2" + "\" type=text value=\""  + propiedades.getProperty("logistica-rest-path-cambioestado2") + "\"</td>");
											out.print("</tr >");
											
											out.print("<tr id_propiedad=" + "logistica-rest-id3" + ">");
											out.print("<td>3</td>");
											out.print("<td ><input name=\"" + "logistica-rest-id3" + "\" type=text value=\""  + propiedades.getProperty("logistica-rest-id3") + "\"</td>");
											out.print("<td ><input name=\"" + "logistica-rest-host3" + "\" type=text value=\""  + propiedades.getProperty("logistica-rest-host3") + "\"</td>");
											out.print("<td ><input name=\"" + "logistica-rest-path-cambioestado3" + "\" type=text value=\""  + propiedades.getProperty("logistica-rest-path-cambioestado3") + "\"</td>");
											out.print("</tr >");
										  
										%>
									</tbody>
								</table>
								<br>
								<h4>Deposito</h4>
								<table class="table table-striped table-hover">
									<thead>
										<tr>
											<td>nro</td>
											<td>id modulo</td>
											<td>host</td>
											<td>cola</td>
											<td>seguridad</td>
											<td>usuario</td>
											<td>password</td>
										</tr>
									</thead>
									<tfoot>
										<tr>
											<td>nro</td>
											<td>id modulo</td>
											<td>host</td>
											<td>cola</td>
											<td>seguridad</td>
											<td>usuario</td>
											<td>password</td>
										</tr>
									</tfoot>
									<tbody>
								        <%
											out.print("<tr id_propiedad=" + "deposito-jms-id1" + ">");
								        	out.print("<td>1</td>");
											out.print("<td ><input name=\"" + "deposito-jms-id1" + "\" type=text value=\""  + propiedades.getProperty("deposito-jms-id1") + "\"</td>");
											out.print("<td ><input name=\"" + "deposito-jms-host1" + "\" type=text value=\""  + propiedades.getProperty("deposito-jms-host1") + "\"</td>");
											out.print("<td ><input name=\"" + "deposito-jms-cola1" + "\" type=text value=\""  + propiedades.getProperty("deposito-jms-cola1") + "\"</td>");
											out.print("<td ><input name=\"" + "deposito-jms-seguridad1" + "\" type=text value=\""  + propiedades.getProperty("deposito-jms-seguridad1") + "\"</td>");
											out.print("<td ><input name=\"" + "deposito-jms-usuario1" + "\" type=text value=\""  + propiedades.getProperty("deposito-jms-usuario1") + "\"</td>");
											out.print("<td ><input name=\"" + "deposito-jms-password1" + "\" type=text value=\""  + propiedades.getProperty("deposito-jms-password1") + "\"</td>");
											out.print("</tr >");
											
											out.print("<tr id_propiedad=" + "deposito-jms-id2" + ">");
											out.print("<td>2</td>");
											out.print("<td ><input name=\"" + "deposito-jms-id2" + "\" type=text value=\""  + propiedades.getProperty("deposito-jms-id2") + "\"</td>");
											out.print("<td ><input name=\"" + "deposito-jms-host2" + "\" type=text value=\""  + propiedades.getProperty("deposito-jms-host2") + "\"</td>");
											out.print("<td ><input name=\"" + "deposito-jms-cola2" + "\" type=text value=\""  + propiedades.getProperty("deposito-jms-cola2") + "\"</td>");
											out.print("<td ><input name=\"" + "deposito-jms-seguridad2" + "\" type=text value=\""  + propiedades.getProperty("deposito-jms-seguridad2") + "\"</td>");
											out.print("<td ><input name=\"" + "deposito-jms-usuario2" + "\" type=text value=\""  + propiedades.getProperty("deposito-jms-usuario2") + "\"</td>");
											out.print("<td ><input name=\"" + "deposito-jms-password2" + "\" type=text value=\""  + propiedades.getProperty("deposito-jms-password2") + "\"</td>");
											out.print("</tr >");
											
											out.print("<tr id_propiedad=" + "deposito-jms-id3" + ">");
											out.print("<td>3</td>");
											out.print("<td ><input name=\"" + "deposito-jms-id3" + "\" type=text value=\""  + propiedades.getProperty("deposito-jms-id3") + "\"</td>");
											out.print("<td ><input name=\"" + "deposito-jms-host3" + "\" type=text value=\""  + propiedades.getProperty("deposito-jms-host3") + "\"</td>");
											out.print("<td ><input name=\"" + "deposito-jms-cola3" + "\" type=text value=\""  + propiedades.getProperty("deposito-jms-cola3") + "\"</td>");
											out.print("<td ><input name=\"" + "deposito-jms-seguridad3" + "\" type=text value=\""  + propiedades.getProperty("deposito-jms-seguridad3") + "\"</td>");
											out.print("<td ><input name=\"" + "deposito-jms-usuario3" + "\" type=text value=\""  + propiedades.getProperty("deposito-jms-usuario3") + "\"</td>");
											out.print("<td ><input name=\"" + "deposito-jms-password3" + "\" type=text value=\""  + propiedades.getProperty("deposito-jms-password3") + "\"</td>");
											out.print("</tr >");
											
											out.print("<tr id_propiedad=" + "deposito-jms-id4" + ">");
											out.print("<td>4</td>");
											out.print("<td ><input name=\"" + "deposito-jms-id4" + "\" type=text value=\""  + propiedades.getProperty("deposito-jms-id4") + "\"</td>");
											out.print("<td ><input name=\"" + "deposito-jms-host4" + "\" type=text value=\""  + propiedades.getProperty("deposito-jms-host4") + "\"</td>");
											out.print("<td ><input name=\"" + "deposito-jms-cola4" + "\" type=text value=\""  + propiedades.getProperty("deposito-jms-cola4") + "\"</td>");
											out.print("<td ><input name=\"" + "deposito-jms-seguridad4" + "\" type=text value=\""  + propiedades.getProperty("deposito-jms-seguridad4") + "\"</td>");
											out.print("<td ><input name=\"" + "deposito-jms-usuario4" + "\" type=text value=\""  + propiedades.getProperty("deposito-jms-usuario4") + "\"</td>");
											out.print("<td ><input name=\"" + "deposito-jms-password4" + "\" type=text value=\""  + propiedades.getProperty("deposito-jms-password4") + "\"</td>");
											out.print("</tr >");
										  
										%>
									</tbody>
								</table>
								<br>
								<h4>Portal</h4>
								<table class="table table-striped table-hover">
									<thead>
										<tr>
											<td>nro</td>
											<td>id modulo</td>
											<td>host</td>
											<td>path</td>
										</tr>
									</thead>
									<tfoot>
										<tr>
											<td>nro</td>
											<td>id modulo</td>
											<td>host</td>
											<td>path</td>
										</tr>
									</tfoot>
									<tbody>
								        <%
											out.print("<tr id_propiedad=" + "portal-ws-id1" + ">");
								        	out.print("<td>1</td>");
											out.print("<td ><input name=\"" + "portal-ws-id1" + "\" type=text value=\""  + propiedades.getProperty("portal-ws-id1") + "\"</td>");
											out.print("<td ><input name=\"" + "portal-ws-host1" + "\" type=text value=\""  + propiedades.getProperty("portal-ws-host1") + "\"</td>");
											out.print("<td ><input name=\"" + "portal-ws-path1" + "\" type=text value=\""  + propiedades.getProperty("portal-ws-path1") + "\"</td>");
											out.print("</tr >");
											
											out.print("<tr id_propiedad=" + "portal-ws-id2" + ">");
											out.print("<td>2</td>");
											out.print("<td ><input name=\"" + "portal-ws-id2" + "\" type=text value=\""  + propiedades.getProperty("portal-ws-id2") + "\"</td>");
											out.print("<td ><input name=\"" + "portal-ws-host2" + "\" type=text value=\""  + propiedades.getProperty("portal-ws-host2") + "\"</td>");
											out.print("<td ><input name=\"" + "portal-ws-path2" + "\" type=text value=\""  + propiedades.getProperty("portal-ws-path2") + "\"</td>");
											out.print("</tr >");
											
											out.print("<tr id_propiedad=" + "portal-ws-id3" + ">");
											out.print("<td>3</td>");
											out.print("<td ><input name=\"" + "portal-ws-id3" + "\" type=text value=\""  + propiedades.getProperty("portal-ws-id3") + "\"</td>");
											out.print("<td ><input name=\"" + "portal-ws-host3" + "\" type=text value=\""  + propiedades.getProperty("portal-ws-host3") + "\"</td>");
											out.print("<td ><input name=\"" + "portal-ws-path3" + "\" type=text value=\""  + propiedades.getProperty("portal-ws-path3") + "\"</td>");
											out.print("</tr >");
											
											out.print("<tr id_propiedad=" + "portal-ws-id4" + ">");
											out.print("<td>3</td>");
											out.print("<td ><input name=\"" + "portal-ws-id4" + "\" type=text value=\""  + propiedades.getProperty("portal-ws-id4") + "\"</td>");
											out.print("<td ><input name=\"" + "portal-ws-host4" + "\" type=text value=\""  + propiedades.getProperty("portal-ws-host4") + "\"</td>");
											out.print("<td ><input name=\"" + "portal-ws-path4" + "\" type=text value=\""  + propiedades.getProperty("portal-ws-path4") + "\"</td>");
											out.print("</tr >");
										%>
									</tbody>
								</table>
								<br>
							
							
<!-- 								<table class="table table-striped table-hover"> -->
<!-- 									<thead> -->
<!-- 										<tr> -->
<!-- 											<td>alias</td> -->
<!-- 											<td>valor</td> -->
<!-- 										</tr> -->
<!-- 									</thead> -->
<!-- 									<tfoot> -->
<!-- 										<tr> -->
<!-- 											<td>alias</td> -->
<!-- 											<td>valor</td> -->
<!-- 										</tr> -->
<!-- 									</tfoot> -->
<!-- 									<tbody> -->
								        <%
// // 										  List<SolicitudArticuloDTO> propiedades = (List<SolicitudArticuloDTO>)request.getAttribute("lista-solicitudesarticulos");
// // 										  String cantidad_platos = request.getParameter("cantidad_platos");
// // 										  String validar_almacen_ok = request.getParameter("validar_almacen_ok");										  
// // 										   entryse propiedades.entrySet().iterator();
// // 											propiedades.
// 										  for (Map.Entry<Object, Object> propiedad : propiedades.entrySet() ){
											  
// 											  out.print("<tr id_propiedad=" + propiedad.getKey() + ">");
// // 											  out.print("<td><input name=\"seleccion_item_pedido\" class\"checkbox_item_pedido\" type=\"checkbox\" value=\"" + "itemComandaDTO.getId()" + "\" " + "disabled" + " /></td>");
// 											  out.print("<td >" + propiedad.getKey() + "</td>");
// 											  out.print("<td ><input name=\"" + propiedad.getKey() + "\" type=text value=\""  + propiedad.getValue() + "\"</td>");
// 											  out.print("</tr >");  
// 										  }
										  
 										%>
<!-- 									</tbody> -->
<!-- 								</table> -->
								<style>body { margin: 10px; }</style>
<!-- 									<div class="controls inline_form"> -->
										<%
// 											if(0 < comanDto.getItemsComanda().size()){
// 										  		out.print(distribuir);
// 											}
										%>	
<%-- 										<input type="hidden" name="area" value="<% out.print((String)request.getParameter("area")); %>"> --%>
<!-- 									</div> -->
<%-- 									<input type="hidden" name="id_mesa" value="<% out.print(comanDto.getMesa().getId()); %>"> --%>
<%-- 									<input type="hidden" name="id_producto" value="<% out.print(comanDto.get.getId()); %>"> --%>
<!-- 								<div class="controls"> -->
<!-- 									<button action="abrir_mesa_compuesta" class="btn btn-mini btn-success js_accion_mesa" type="button">abrir compuesta</button> -->
<!-- 								</div> -->
							</div>
						</div>
<!-- 						<div class="span4">	 -->
<!-- 							<div class="row-fluid"> -->
<!-- 		  						<div class="control-group"> -->
<!-- 									<label class="control-label" for="select_items_carta">Items Carta</label> -->
<!-- 									<div class="controls"> -->
<!-- 										<select name="select_items_carta" placeholder="Items Carta" id="select_items_carta"> -->
<!-- 										<option ></option> -->
<%-- 										<% --%>
<%-- 										%> --%>
<!-- 										</select> -->
<!-- 									</div> -->
<!-- 		  							<label class="control-label" for="cantidad_platos">Cantidad Platos</label> -->
<!-- 									<div class="controls"> -->
<!-- 										<input name="cantidad_platos" type="text" placeholder="1" id="cantidad_platos" /> -->
<!-- 									</div> -->
<!-- 									<br> -->
<!-- 									<div class="controls inline_form"> -->
<%-- 										<% --%>
<%-- 										%>										 --%>
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 						</div> -->
					</div>
					<div>
					<input class="btn btn-blue pull-left" type="submit" value="guardar" />
					</div>
				</form>
				</div>
			</div>
		</div>
	</div>
