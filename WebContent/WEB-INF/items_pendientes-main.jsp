<%@page import="java.util.Set"%>
<%-- <%@page import="dto.ItemCartaDTO"%> --%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%-- <%@page import="dto.ItemComandaDTO"%> --%>
<h2><img src="img/home.png" style="width: 25px; height: 25px;  middle; padding-right:20pt;"/>Items Pendientes</h2>
<p>Items pendientes ...</p>

	<div class="container container-fluid">
		<div id="content" class="row-fluid">
			<div class="span10">
				<div class="row-fluid">
				<form id="items_pendientes_form" action="action" method="GET" class="form-horizontal">
<!-- 					<h1>Mesas</h1> -->
					<div class="row-fluid">
						<div class="span8">
							<div class="row-fluid">
								<table class="table table-striped table-hover">
									<tbody>
										<tr>
											<td>sel</td>
											<td>id</td>
											<td>itemcarta</td>
											<td>estado</td>
											<td>cantidad</td>
											<td>facturable</td>
											<td>accion</td>
										</tr>
								        <% //ENPROCESO LISTO ENTREGADO FACTURADO DEVUELTO
								          String listo =   "<button action=\"item_pendiente_listo\" class=\"btn btn-mini btn-warning js_accion_item_pendiente\" type=\"button\">listo</button>";
// 								          String completo =  "<button action=\"completar_item_pedido\" class=\"btn btn-mini btn-danger js_accion_item_pedido\" type=\"button\">completado</button>";
// 								          String devuelto =  "<button action=\"completar_item_pedido\" class=\"btn btn-mini btn-danger js_accion_item_pedido\" type=\"button\">completado</button>";
								          
// 										  Set<ItemComandaDTO> listaItemsComanda = (Set<ItemComandaDTO>) request.getAttribute("lista-items-pendientes");
// 										  Iterator it = listaItemsComanda.iterator();
// 										  while(it.hasNext()) {
// 										    ItemComandaDTO itemComandaDTO = (ItemComandaDTO)it.next();
										    		
// 										    String disabled = "";
// 										    String accion_item_pedido = "";
// 										    String btn_accion_item_pedido = "";
										    		
// 										    if(itemComandaDTO.isEnProceso()){
// 										    	disabled = "disabled=true";
// 										    	btn_accion_item_pedido = listo;
// 										    }
// 										    out.print("<tr id_item_comanda=" + itemComandaDTO.getId() + ">");
// 										    out.print("<td><input name=\"items_comanda\" class\"checkbox_item_comanda\" type=\"checkbox\" value=\"" + itemComandaDTO.getId() + "\" " + disabled + " /></td>");
// 										    out.print("<td >" + itemComandaDTO.getId() + "</td>");
// 										    out.print("<td >" + itemComandaDTO.getItemCarta().getDescripcion() + "</td>");
// 										    out.print("<td >" + itemComandaDTO.getEstado().getEstado() + "</td>");
// 										    out.print("<td >" + itemComandaDTO.getCantidad() + "</td>");
// 										    out.print("<td >" + itemComandaDTO.isFacturable() + "</td>");
// 										    out.print("<td >" + btn_accion_item_pedido + "</td>");
// 										    out.print("</tr >");
// 										  }
										  
										%>
									</tbody>
								</table>
								<input type="hidden" name="area" value="<% out.print((String)request.getParameter("area")); %>">
<!-- 								<div class="controls"> -->
<!-- 									<button action="abrir_mesa_compuesta" class="btn btn-mini btn-success js_accion_mesa" type="button">abrir compuesta</button> -->
<!-- 								</div> -->
							</div>
						</div>
						<div class="span4">	
							<div class="row-fluid">
		  						<div class="control-group">
									<label class="control-label" for="legajo_mozo">Legajo del Mozo</label>
									<div class="controls">
										<input name="legajo_mozo" type="text" placeholder="legajo" id="legajo_mozo" />
									</div>
		  							<label class="control-label" for="cantidad_comensales">Cantidad Comensales</label>
									<div class="controls">
										<input name="cantidad_comensales" type="text" placeholder="2" id="cantidad_comensales" />
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
