<%-- <%@page import="dto.ComandaDTO"%> --%>
<%-- <%@page import="stub.Stub"%> --%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%-- <%@page import="dto.MesaDTO"%> --%>
<h2><img src="img/home.png" style="width: 25px; height: 25px;  middle; padding-right:20pt;"/>Mesas</h2>
<p>Pone los datos...</p>
								        <%
								          String liberar = "<button action=\"liberar_mesa\" class=\"btn btn-mini btn-warning js_accion_mesa\" type=\"button\">liberar</button>";
								          String abrir =   "<button action=\"abrir_mesa\" class=\"btn btn-mini btn-success js_accion_mesa\" type=\"button\">abrir</button>";
								          String abrir_compuesta = "<button action=\"abrir_mesa_compuesta\" class=\"btn btn-mini btn-success js_accion_mesa\" type=\"button\">abrir compuesta</button>";
								          String cerrar =  "<button action=\"cerrar_mesa\"  class=\"btn btn-mini btn-danger  js_accion_mesa\" type=\"button\">cerrar</button>";
								          String pedido =  "<button action=\"listar_pedido\" class=\"btn btn-mini btn-inverse js_accion_pedido\" type=\"button\">pedido</button>";
								          String reservar ="<button action=\"reservar_mesa\" class=\"btn btn-mini js_accion_mesa\" type=\"button\">reservar</button>";
								          %>
<div class="container container-fluid">
		<div id="content" class="row-fluid">
			<div class="span10">
				<div class="row-fluid">
				<form id="mesas_form" action="action" method="GET" class="form-horizontal">
<!-- 					<h1>Mesas</h1> -->
					<div class="row-fluid">
						<div class="span8">
							<div class="row-fluid">
								<table class="table table-striped table-hover">
									<tbody>
										<tr>
											<td>sel</td>
											<td>id</td>
											<td>codigo</td>
											<td>estado</td>
											<td>capacidad</td>
											<td>accion</td>
										</tr>
								        <%
// 								          String liberar = "<button action=\"liberar_mesa\" class=\"btn btn-mini btn-warning js_accion_mesa\" type=\"button\">liberar</button>";
// 								          String abrir =   "<button action=\"abrir_mesa\" class=\"btn btn-mini btn-success js_accion_mesa\" type=\"button\">abrir</button>";
// 								          String cerrar =  "<button action=\"cerrar_mesa\"  class=\"btn btn-mini btn-danger  js_accion_mesa\" type=\"button\">cerrar</button>";
// 								          String pedido =  "<button action=\"editar_pedido\" class=\"btn btn-mini btn-inverse\" type=\"button\">pedido</button>";
// 								          String reservar ="<button action=\"reservar_mesa\" class=\"btn btn-mini js_accion_mesa\" type=\"button\">reservar</button>";
								          
// 										  List<MesaDTO> listaMesas = (List<MesaDTO>) request.getAttribute("lista-mesas");
// 										  Iterator it = listaMesas.iterator();
// 										  while(it.hasNext()) {
// 										    //out.print("<br>try: " + it.next());
// 										    MesaDTO mesaDTO = (MesaDTO)it.next();
										    		
// 										    String disabled = "";
// 										    String accion_mesa = "";
// 										    String btn_accion_mesa = "";
// 										    boolean tieneUnPedidoEnCurso = false;
										    
// 										    Stub stub = null;
// 											stub = stub.getIntance();
// 											if (stub.srOnline()){
// 												System.out.println("## STUB ONLINE");
// 												try {
// 													ComandaDTO comandaDTO = stub.getSistemaRemoto().buscarComandaPorMesa(mesaDTO);
// 													if (comandaDTO != null && 0 <= comandaDTO.getItemsComanda().size()){
// 														tieneUnPedidoEnCurso = true;	
// 													}else{
// 														tieneUnPedidoEnCurso = false;
// 													}
// 												} catch (Exception e) {
// 													e.printStackTrace();
// 												}
// 											}
											
// 										    if(mesaDTO.getEstadoMesa().getEstado().equals("OCUPADA")){
// 										    	disabled = "disabled=true";
// 										    	if(tieneUnPedidoEnCurso){
// 										    		btn_accion_mesa = cerrar + pedido;
// 										    	}else{
// 										    		btn_accion_mesa = pedido;
// 										    	}	
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
// 										    out.print("<tr id_mesa=" + mesaDTO.getId() + ">");
// 										    out.print("<td><input name=\"seleccion_mesa\" class\"checkbox_mesa\" type=\"checkbox\" value=\"" + mesaDTO.getId() + "\" " + disabled + " /></td>");
// 										    out.print("<td >" + mesaDTO.getId() + "</td>");
// 										    out.print("<td >" + mesaDTO.getCodigo() + "</td>");
// 										    out.print("<td >" + mesaDTO.getEstadoMesa().getEstado() + "</td>");
// 										    out.print("<td >" + mesaDTO.getCapacidad() + "</td>");
// 										    out.print("<td >" + btn_accion_mesa + "</td>");
// 										    out.print("</tr >");
// 										  }
										  
										%>
									</tbody>
								</table>
<!-- 								<div class="controls"> -->
<!-- 									<button action="abrir_mesa_compuesta" class="btn btn-mini btn-success js_accion_mesa" type="button">abrir compuesta</button> -->
										<% out.print( abrir_compuesta ); %>
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
									
									<div class="controls">
										<% out.print( reservar ); %>
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