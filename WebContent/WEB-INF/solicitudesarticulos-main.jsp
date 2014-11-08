<%-- <%@page import="dto.ItemCartaDTO"%> --%>
<%@page import="dto.ArticuloDTO"%>
<%@page import="java.util.List"%>
<%-- <%@page import="dto.ItemComandaDTO"%> --%>
<%@page import="java.util.Iterator"%>
<%-- <%@page import="dto.ComandaDTO"%> --%>
<h2><img src="img/home.png" style="width: 25px; height: 25px;  middle; padding-right:20pt;"/>Solicitudes de Articulos</h2>
<p>Solicitudes de Articulos...</p>

	<div class="container container-fluid">
		<div id="content" class="row-fluid">
			<div class="span10">
				<div class="row-fluid">
				<form id="items_pedido_form" action="action" method="GET" class="form-horizontal">
<!-- 					<h1>Mesas</h1> -->
					<div class="row-fluid">
						<div class="span8">
							<div class="row-fluid">
								<table class="table table-striped table-hover">
									<tbody>
										<tr>
											<td>deposito</td>
											<td>id</td>
											<td>descripcion</td>
										</tr>
								        <%
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
						<div class="span4">	
							<div class="row-fluid">
		  						<div class="control-group">
									<label class="control-label" for="select_items_carta">Items Carta</label>
									<div class="controls">
										<select name="select_items_carta" placeholder="Items Carta" id="select_items_carta">
										<option ></option>
										<%
// 											List<ItemCartaDTO> itemCartaDTOs = (List<ItemCartaDTO>) request.getAttribute("items_carta");
// 											Iterator itic = itemCartaDTOs.iterator();
// 										  	while(itic.hasNext()) {
// 										  		ItemCartaDTO itemCartaDTO = (ItemCartaDTO) itic.next();
										  		
// 										  		out.print("<option value=\"" + itemCartaDTO.getId() + "\">" + itemCartaDTO.getDescripcion() + "</option>");
// 										  	}
										%>
										</select>
									</div>
		  							<label class="control-label" for="cantidad_platos">Cantidad Platos</label>
									<div class="controls">
										<input name="cantidad_platos" type="text" placeholder="1" id="cantidad_platos" />
									</div>
									<br>
									<div class="controls inline_form">
										<%
// 										  out.print(validar_almacen);
										%>										
									</div>
								</div>
							</div>
						</div>
					</div>
				</form>
				</div>
			</div>
		</div>
	</div>
