<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%
// String tipoReporte = request.getParameter("tipo-reporte");
// if(null == tipoReporte){
// 	//Por default mostrar reportes de operaciones
// 	tipoReporte = "operaciones";
// }

//	String pais = request.getParameter("pais");
// String pais;
//	if(null == pais){
	//Por default mostrar reportes CONSOLIDADO
// 	pais = "CONSOLIDADO";
//	}

//	String desde = request.getParameter("desde");
// String desde;
//	String hasta = request.getParameter("hasta");
// String hasta;
//	if(null == desde || null == hasta){
	//Por default mostrar ultimo mes
//      Calendar cal = Calendar.getInstance();
//      cal.setTime(new Date());
//  	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//  	hasta = sdf.format(cal.getTime());
//  	cal.add(Calendar.MONTH, -1); //1 mes atras
//  	desde = sdf.format(cal.getTime());
//	}


// 	System.out.println("pais default " + pais);
// 	System.out.println("desde default " + desde);
// 	System.out.println("hasta default " + hasta);
// 	String pathReporteOperaciones = "reportes.jsp?tipo-reporte=operaciones" + "&pais=" + pais+ "&desde=" + desde + "&hasta=" + hasta;
// 	String pathReporteProducto = "reportes.jsp?tipo-reporte=producto" + "&pais=" + pais+ "&desde=" + desde + "&hasta=" + hasta;
// 	String pathReporteOperacionesProy = "reportes.jsp?tipo-reporte=operaciones-proy" + "&pais=" + pais+ "&desde=" + desde + "&hasta=" + hasta;
// 	String pathReporteProductoProy = "reportes.jsp?tipo-reporte=producto-proy" + "&pais=" + pais+ "&desde=" + desde + "&hasta=" + hasta;
%>

<div id="menu">
<ul>
<li><a href="home.jsp">Home</a></li>
<!-- <li><a href="abrir_mesa.jsp">AbrirMesa</a></li> -->
<li><a href="accion?accion=listar_articulos">Articulos</a></li>
<li><a href="accion?accion=listar_ordenesdespacho">Ordenes Despacho</a></li>
<li><a href="accion?accion=listar_solicitudesarticulos">Solicitudes Articulos</a></li>
<li><a href="accion?accion=listar_propiedades">Config</a></li>
<!-- <li><a href="action?action=mesas_view">Mesas</a></li> -->
<!-- <li><a href="action?action=listar_items_pendientes&area=cafeteria">Cafeteria</a></li> -->
<!-- <li><a href="action?action=listar_items_pendientes&area=barra">Barra</a></li> -->
<!-- <li><a href="servicios.jsp?tipo-servicio=alta-consumos-xml">Servicios</a></li> -->
<!--   <li><a href="#">Resto</a> -->
<!--     <ul> -->
<!--       <li><a href="#">Item 3-1</a></li> -->
<!--       <li><a href="#">Item 3-2</a></li> -->
<!--       <li><a href="#">Item 3-3</a></li> -->
<!--       <li><a href="#">Item 3-4</a></li> -->
<!--       <li><a href="#">Item 3-5</a></li> -->
<!--     </ul> -->
<!--   </li> -->
  <li><a href="about.jsp">About</a></li>
  <!-- <li><a href="action?action=test_poblar">Test poblar</a></li> -->
  <!-- <li><a href="action?action=test_json">Test JSON</a></li> -->
  <li><a href="logout.jsp">Logout</a></li>
<!--   <li><a href="#">Item 4</a></li> -->
<!--   <li><a href="#">Item 5</a></li> -->
</ul>
</div>