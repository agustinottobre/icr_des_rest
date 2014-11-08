<%-- <%@page import="dto.ItemCartaDTO"%> --%>
<%@page import="dto.ItemSolicitudArticuloDTO"%>
<%@page import="dto.SolicitudArticuloDTO"%>
<%@page import="dto.ArticuloDTO"%>
<%@page import="java.util.List"%>
<%-- <%@page import="dto.ItemComandaDTO"%> --%>
<%@page import="java.util.Iterator"%>
<%-- <%@page import="dto.ComandaDTO"%> --%>
<h2><img src="img/home.png" style="width: 25px; height: 25px;  middle; padding-right:20pt;"/>Solicitudes de Articulos</h2>
<p>Solicitudes de Articulos...</p>



<!-- <h2>Tablesorter Custom Bootstrap LESS theme</h2> -->

<!-- <button class="error">Show Error Row</button> -->
<!-- <button class="process">Toggle Processing icon</button> -->
<!-- <button class="sortable">Toggle Sorting of last column</button> -->
<!-- <br> -->
<!-- <br> -->
<!-- <table class="tablesorter-bootstrap"> -->
<!-- 	<thead> -->
<!-- 		<tr> -->
<!-- 			<th>Name</th> -->
<!-- 			<th>Major</th> -->
<!-- 			<th class="filter-select filter-exact" data-placeholder="Pick a gender">Sex</th> -->
<!-- 			<th>English</th> -->
<!-- 			<th>Japanese</th> -->
<!-- 			<th>Calculus</th> -->
<!-- 			<th>Geometry</th></tr> -->
<!-- 	</thead> -->
<!-- 	<tfoot> -->
<!-- 		<tr> -->
<!-- 			<th>Name</th> -->
<!-- 			<th>Major</th> -->
<!-- 			<th>Sex</th> -->
<!-- 			<th>English</th> -->
<!-- 			<th>Japanese</th> -->
<!-- 			<th>Calculus</th> -->
<!-- 			<th>Geometry</th> -->
<!-- 		</tr> -->
<!-- 	</tfoot> -->
<!-- 	<tbody> -->
<!-- 		<tr><td>Student01</td><td>Languages</td><td>male</td><td>80</td><td>70</td><td>75</td><td>80</td></tr> -->
<!-- 		<tr><td>Student02</td><td>Mathematics</td><td>male</td><td>90</td><td>88</td><td>100</td><td>90</td></tr> -->
<!-- 		<tr><td>Student03</td><td>Languages</td><td>female</td><td>85</td><td>95</td><td>80</td><td>85</td></tr> -->
<!-- 		<tr><td>Student04</td><td>Languages</td><td>male</td><td>60</td><td>55</td><td>100</td><td>100</td></tr> -->
<!-- 		<tr><td>Student05</td><td>Languages</td><td>female</td><td>68</td><td>80</td><td>95</td><td>80</td></tr> -->
<!-- 		<tr><td>Student06</td><td>Mathematics</td><td>male</td><td>100</td><td>99</td><td>100</td><td>90</td></tr> -->
<!-- 		<tr><td>Student07</td><td>Mathematics</td><td>male</td><td>85</td><td>68</td><td>90</td><td>90</td></tr> -->
<!-- 		<tr><td>Student08</td><td>Languages</td><td>male</td><td>100</td><td>90</td><td>90</td><td>85</td></tr> -->
<!-- 		<tr><td>Student09</td><td>Mathematics</td><td>male</td><td>80</td><td>50</td><td>65</td><td>75</td></tr> -->
<!-- 		<tr><td>Student10</td><td>Languages</td><td>male</td><td>85</td><td>100</td><td>100</td><td>90</td></tr> -->
<!-- 		<tr><td>Student11</td><td>Languages</td><td>male</td><td>86</td><td>85</td><td>100</td><td>100</td></tr> -->
<!-- 		<tr><td>Student12</td><td>Mathematics</td><td>female</td><td>100</td><td>75</td><td>70</td><td>85</td></tr> -->
<!-- 		<tr><td>Student13</td><td>Languages</td><td>female</td><td>100</td><td>80</td><td>100</td><td>90</td></tr> -->
<!-- 		<tr><td>Student14</td><td>Languages</td><td>female</td><td>50</td><td>45</td><td>55</td><td>90</td></tr> -->
<!-- 		<tr><td>Student15</td><td>Languages</td><td>male</td><td>95</td><td>35</td><td>100</td><td>90</td></tr> -->
<!-- 	</tbody> -->
<!-- </table> -->
  
<!-- <style>body { margin: 10px; }</style> -->





	<div class="container container-fluid">
		<div id="content" class="row-fluid">
			<div class="span10">
				<div class="row-fluid">
				<form id="items_pedido_form" action="action" method="GET" class="form-horizontal">
<!-- 					<h1>Mesas</h1> -->
					<div class="row-fluid">
						<div class="span12">
							<div class="row-fluid">
								<table class="table table-striped table-hover tablesorter-bootstrap">
									<thead>
										<tr>
											<td>id</td>
											<td>orden despacho</td>
											<td>deposito</td>
											<td>estado</td>
											<td>articulo</td>
											<td>descripcion</td>
											<td>cantidad</td>
										</tr>
									</thead>
									<tfoot>
										<tr>
											<td>id</td>
											<td>orden despacho</td>
											<td>deposito</td>
											<td>estado</td>
											<td>articulo</td>
											<td>descripcion</td>
											<td>cantidad</td>
										</tr>
									</tfoot>
									<tbody>
								        <%
										  List<SolicitudArticuloDTO> listaSolicitudesArticulos = (List<SolicitudArticuloDTO>)request.getAttribute("lista-solicitudesarticulos");
// 										  String cantidad_platos = request.getParameter("cantidad_platos");
// 										  String validar_almacen_ok = request.getParameter("validar_almacen_ok");
										  
										  for (SolicitudArticuloDTO solicitudArticuloDTO : listaSolicitudesArticulos ){
											  
											  out.print("<tr id_solicitudarticulo=" + solicitudArticuloDTO.getIdSolicitud() + ">");
// 											  out.print("<td><input name=\"seleccion_item_pedido\" class\"checkbox_item_pedido\" type=\"checkbox\" value=\"" + "itemComandaDTO.getId()" + "\" " + "disabled" + " /></td>");
											  out.print("<td >" + solicitudArticuloDTO.getIdSolicitud() + "</td>");
											  out.print("<td >" + solicitudArticuloDTO.getIdOrdenDespacho() + "</td>");
											  out.print("<td >" + solicitudArticuloDTO.getidDeposito() + "</td>");
											  out.print("<td >" + solicitudArticuloDTO.getEstadoSolicitud() + "</td>");
											  for(ItemSolicitudArticuloDTO item : solicitudArticuloDTO.getItems() ){
												  out.print("<td >" + item.getArticulo().getIdArticulo() + "</td>");
												  out.print("<td >" + item.getArticulo().getDescripcion() + "</td>");
												  out.print("<td >" + item.getCantidad() + "</td>");
										  	  }
											  out.print("</tr >");  
										  }
										  
										%>
									</tbody>
								</table>
								<style>body { margin: 10px; }</style>
<!-- 									<div class="controls inline_form"> -->
										<%
// 											if(0 < comanDto.getItemsComanda().size()){
// 										  		out.print(distribuir);
// 											}
										%>	
										<input type="hidden" name="area" value="<% out.print((String)request.getParameter("area")); %>">
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
				</form>
				</div>
			</div>
		</div>
	</div>
