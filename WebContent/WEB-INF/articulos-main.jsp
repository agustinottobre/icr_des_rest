<%-- <%@page import="dto.ItemCartaDTO"%> --%>
<%@page import="dto.ArticuloDTO"%>
<%@page import="java.util.List"%>
<%-- <%@page import="dto.ItemComandaDTO"%> --%>
<%@page import="java.util.Iterator"%>
<%-- <%@page import="dto.ComandaDTO"%> --%>
<h2><img src="img/home.png" style="width: 25px; height: 25px;  middle; padding-right:20pt;"/>Articulos</h2>
<p>Articulos...</p>

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
											<td>deposito</td>
											<td>id</td>
											<td>descripcion</td>
										</tr>
									</thead>
									<tfoot>
										<tr>
											<td>deposito</td>
											<td>id</td>
											<td>descripcion</td>
										</tr>
									</tfoot>
									<tbody>
								        <%
								        
								          String agregar = "<button action=\"agregar_item_pedido\" class=\"btn btn-mini btn-success js_accion_item_pedido\" type=\"button\">agregar</button>";
								          String editar =   "<button action=\"editar_item_pedido\" class=\"btn btn-mini btn-warning js_accion_item_pedido\" type=\"button\">editar</button>";
								          String borrar =   "<button action=\"borrar_item_pedido\" class=\"btn btn-mini btn-danger js_accion_item_pedido\" type=\"button\">borrar</button>";
								          String validar_almacen =   "<button action=\"validar_almacen_item_pedido\" class=\"btn btn-mini btn-danger js_accion_item_pedido\" type=\"button\">validar y agregar</button>";
								          String validar_deposito =  "<button action=\"validar_deposito_item_pedido\" class=\"btn btn-mini btn-danger js_accion_item_pedido\" type=\"button\">validar deposito</button>";
								          String solicitud_repo =    "<button action=\"solicitud_repo_item_pedido\" class=\"btn btn-mini btn-danger js_accion_item_pedido\" type=\"button\">solicitur reposicion</button>";
								          
								          String distribuir =        "<button action=\"distribuir_pedido\" class=\"btn btn-mini btn-primary js_accion_pedido\" type=\"button\">distribuir</button>";
								          
								          String entregado =   "<button action=\"item_pendiente_entregado\" class=\"btn btn-mini btn-success js_accion_item_pedido\" type=\"button\">entregado</button>";
// 								          String cerrar =  "<button action=\"cerrar_mesa\"  class=\"btn btn-mini btn-danger  js_accion_mesa\" type=\"button\">cerrar</button>";
// 								          String pedido = "<button action=\"liberar_mesa\" class=\"btn btn-mini\" type=\"button\">pedido</button>";
								          
// 										  ComandaDTO comanDto = (ComandaDTO) request.getAttribute("comanda");
// 										  Iterator it = comanDto.getItemsComanda().iterator();
// 										  while(it.hasNext()) {
// 										    //out.print("<br>try: " + it.next());
// 										    ItemComandaDTO itemComandaDTO = (ItemComandaDTO)it.next();
										    		
// 										    String disabled = "";
// // 										    String accion_mesa = "";
// 										    String btn_accion_item_pedido = "";
										    		
// 										    if(itemComandaDTO.isListo()){
// // 										    	disabled = "disabled=true";
// 										    	btn_accion_item_pedido = entregado;
// 										    }
// 										    if(mesaDTO.getEstadoMesa().getEstado().equals("RESERVADA")){
// 										    	disabled = "disabled=true";
// 										    	btn_accion_mesa = abrir + liberar;
// 										    }
// 										    if(mesaDTO.getEstadoMesa().getEstado().equals("LIBRE")){
// 										    	btn_accion_mesa = abrir;
// 										    }
// 										    if(mesaDTO.getEstadoMesa().getEstado().equals("CERRADA")){
// 										    	disabled = "disabled=true";
// 										    	btn_accion_mesa = liberar;
// 										    }
// 										    out.print("<tr id_item_pedido=" + itemComandaDTO.getId() + ">");
// 										    out.print("<td><input name=\"seleccion_item_pedido\" class\"checkbox_item_pedido\" type=\"checkbox\" value=\"" + itemComandaDTO.getId() + "\" " + disabled + " /></td>");
// 										    out.print("<td >" + itemComandaDTO.getId() + "</td>");
// 										    out.print("<td >" + itemComandaDTO.getCantidad() + "</td>");
// 										    out.print("<td >" + itemComandaDTO.getEstado().getEstado() + "</td>");
// 										    out.print("<td >" + itemComandaDTO.getItemCarta().getDescripcion() + "</td>");
// 										    out.print("<td >" + btn_accion_item_pedido + "</td>");
// 										    out.print("</tr >");
// 										  }
										  List<ArticuloDTO> listaArticulos = (List<ArticuloDTO>)request.getAttribute("lista-articulos");
// 										  String cantidad_platos = request.getParameter("cantidad_platos");
// 										  String validar_almacen_ok = request.getParameter("validar_almacen_ok");
										  
										  for (ArticuloDTO articuloDTO : listaArticulos ){
											  
											  out.print("<tr id_articulo=" + articuloDTO.getIdArticulo() + ">");
// 											  out.print("<td><input name=\"seleccion_item_pedido\" class\"checkbox_item_pedido\" type=\"checkbox\" value=\"" + "itemComandaDTO.getId()" + "\" " + "disabled" + " /></td>");
											  out.print("<td >" + articuloDTO.getIdDeposito() + "</td>");
											  out.print("<td >" + articuloDTO.getIdArticulo() + "</td>");
											  out.print("<td >" + articuloDTO.getDescripcion() + "</td>");
											  out.print("</tr >");  
										  }
										  
										%>
									</tbody>
								</table>
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
