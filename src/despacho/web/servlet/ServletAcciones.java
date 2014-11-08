package despacho.web.servlet;

import java.io.File;	
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.RestoreAction;

import despacho.ejb.interfaces.remotas.AdministradorArticulos;
import despacho.ejb.interfaces.remotas.AdministradorOrdenesDespacho;
import despacho.ejb.interfaces.remotas.AdministradorSolicitudesArticulo;
import dto.ArticuloDTO;
import dto.OrdenDespachoDTO;
import dto.SolicitudArticuloDTO;

//import org.apache.commons.fileupload.FileItem;
//import org.apache.commons.fileupload.FileItemFactory;
//import org.apache.commons.fileupload.FileUploadException;
//import org.apache.commons.fileupload.disk.DiskFileItemFactory;
//import org.apache.commons.fileupload.servlet.ServletFileUpload;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.JSONValue;

//import stub.Stub;

//import dto.ComandaDTO;
//import dto.EstadoItemComandaDTO;
//import dto.EstadoMesaDTO;
//import dto.FacturaDTO;
//import dto.ItemCartaCocinaDTO;
//import dto.ItemCartaDTO;
//import dto.ItemComandaDTO;
//import dto.MesaDTO;
//import dto.MesaSimpleDTO;
//import dto.MozoDTO;
//import dto.RestaurantDTO;

//import stc.controller.ActionController;
//import stc.model.common.JSONConverter;
//import stc.model.entities.Cliente;
//import stc.model.forecast.Forecast;
//import stc.persistence.EMF;
//import stc.service.repositories.ClienteRepository;


@javax.servlet.annotation.WebServlet(urlPatterns = { "/index" })
public class ServletAcciones extends HttpServlet {
	
	@EJB
	private AdministradorArticulos administradorArticulos;
	
	@EJB
	private AdministradorOrdenesDespacho administradorOrdenesDespacho;
	
	@EJB
	private AdministradorSolicitudesArticulo administradorSolicitudesArticulo;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("## INICIO doGet #####################################");
		
//		ActionController actionController = ActionController.getInstance();
		String accion = request.getParameter("accion");
		System.out.println("## ACTION : " + accion);
//		Stub stub = Stub.getIntance();
//		
//		RestaurantDTO restaurantDTO = new RestaurantDTO();
//		restaurantDTO.setNombre("resto_1");
		
//		/* Si la accion enviada por el jsp es "abrir_mesa" */
		if(accion.equals("mesas_view")){
//			if (stub.srOnline()){
//				System.out.println("## STUB ONLINE");
//				try {
//					List<MesaDTO> listaMesas = stub.getSistemaRemoto().obtenerMesasResto(restaurantDTO);
//					if (listaMesas != null && 0 <= listaMesas.size())
//					{
//						request.setAttribute("mesas-response", "Hay " + listaMesas.size() + " mesas");
//						request.setAttribute("lista-mesas", listaMesas);
//					}else{
//						request.setAttribute("mesas-response", "No Hay mesas");
//						request.setAttribute("error", "No se seleccionaron mesas");
//						request.getRequestDispatcher("/error.jsp").forward(request, response);
//					}
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//			
//			Set<MesaDTO> listaMesas = new LinkedHashSet<MesaDTO>();
//			listaMesas.add(new MesaSimpleDTO(1, 11, 4, new EstadoMesaDTO("LIBRE")));
//			listaMesas.add(new MesaSimpleDTO(2, 12, 6, new EstadoMesaDTO("OCUPADA")));
//			listaMesas.add(new MesaSimpleDTO(3, 13, 2, new EstadoMesaDTO("RESERVADA")));
//			listaMesas.add(new MesaSimpleDTO(5, 15, 6, new EstadoMesaDTO("LIBRE")));
//
//			if (listaMesas.size() == 0) {
//				request.setAttribute("mesas-response", "No Hay mesas");
//			}else{
//				request.setAttribute("mesas-response", "Hay " + listaMesas.size() + " mesas");
//			}
//			
//			request.setAttribute("lista-mesas", listaMesas);

//			/* Despachar request a la pagina abrir_mesa.jsp para renderizar */
			request.getRequestDispatcher("/mesas.jsp").forward(request, response);
		}else if(accion.equals("abrir_mesa")){
			
			String id_mesa = request.getParameter("id_mesa");
			if(id_mesa != null){
				System.out.println("## mesa seleccionada para abrir : " + id_mesa);
			}else{
				System.out.println("## NO se selecciono mesa para abrir");
			}
			String cantidad_comensales = request.getParameter("cantidad_comensales");
			String legajo_mozo = request.getParameter("legajo_mozo");
			
//			if (stub.srOnline()){
//				System.out.println("## STUB ONLINE");
//				try {
////					MozoDTO mozoDTO = new MozoDTO();
////					mozoDTO.setId(Integer.parseInt(legajo_mozo));
////					List<MesaSimpleDTO> mesasSimpleDTOs = new ArrayList<MesaSimpleDTO>();
////					MesaSimpleDTO mesaSimpleDTO = new MesaSimpleDTO();
////					mesaSimpleDTO.setId(Integer.parseInt(id_mesa));
////					mesasSimpleDTOs.add(mesaSimpleDTO);
////										
////					MesaDTO mesaAbierta = stub.getSistemaRemoto().abrirMesa(restaurantDTO, mozoDTO, mesasSimpleDTOs, Integer.parseInt(cantidad_comensales));
////					if(null != mesaAbierta){
////						stub.getSistemaRemoto().crearComanda(mozoDTO, mesaAbierta, Integer.parseInt(cantidad_comensales));
////					}
//					
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//			//Redirigir nuevamente a abrir mesa
			request.getRequestDispatcher("/action?action=mesas_view").forward(request, response);
		}else if(accion.equals("abrir_mesa_compuesta")){
			
			String mesas_seleccionadas[]= request.getParameterValues("seleccion_mesa");
			if(mesas_seleccionadas != null){
				for(String mesa_seleccionada : mesas_seleccionadas)
				{
					System.out.println("## mesas seleccionada: " + mesa_seleccionada);
				}
			}else{
				System.out.println("## NO se seleccionaron mesas");
				request.setAttribute("error", "No se seleccionaron mesas");
				request.getRequestDispatcher("/error.jsp").forward(request, response);
			}

			String cantidad_comensales = request.getParameter("cantidad_comensales");
			String legajo_mozo = request.getParameter("legajo_mozo");
			
//			if (stub.srOnline()){
//				System.out.println("## STUB ONLINE");
//				try {
//					MozoDTO mozoDTO = new MozoDTO();
//					mozoDTO.setId(Integer.parseInt(legajo_mozo));
//					List<MesaSimpleDTO> mesasSimpleDTOs = new ArrayList<MesaSimpleDTO>();
//					for(String mesa_seleccionada : mesas_seleccionadas)
//					{
//						MesaSimpleDTO mesaSimpleDTO = new MesaSimpleDTO();
//						mesaSimpleDTO.setId(Integer.parseInt(mesa_seleccionada));
//						mesasSimpleDTOs.add(mesaSimpleDTO);
//					}
//
//					MesaDTO mesaAbierta = stub.getSistemaRemoto().abrirMesa(restaurantDTO, mozoDTO, mesasSimpleDTOs, Integer.parseInt(cantidad_comensales));
//					if(null != mesaAbierta){
//						stub.getSistemaRemoto().crearComanda(mozoDTO, mesaAbierta, Integer.parseInt(cantidad_comensales));	
//					}
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
			request.getRequestDispatcher("/action?action=mesas_view").forward(request, response);
		}else if(accion.equals("cerrar_mesa")){
			
			String id_mesa = request.getParameter("id_mesa");
//			if (stub.srOnline()){
//				System.out.println("## STUB ONLINE");
//				try {
////					MesaSimpleDTO mesaSimpleDTO = new MesaSimpleDTO();
////					mesaSimpleDTO.setId(Integer.parseInt(id_mesa));
////					
////					FacturaDTO facturaDTO = stub.getSistemaRemoto().cerrarMesa(restaurantDTO, mesaSimpleDTO);
////					if(null != facturaDTO){
////						request.getRequestDispatcher("/action?action=mesas_view").forward(request, response);						
////					}
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
			request.getRequestDispatcher("/action?action=mesas_view").forward(request, response);
		}else if(accion.equals("liberar_mesa")){
			
			String id_mesa = request.getParameter("id_mesa");
			
//			if (stub.srOnline()){
//				System.out.println("## STUB ONLINE");
//				try {
////					MesaSimpleDTO mesaSimpleDTO = new MesaSimpleDTO();
////					mesaSimpleDTO.setId(Integer.parseInt(id_mesa));
////
////					MozoDTO mozoDTO = new MozoDTO();
////					mozoDTO.setId(Integer.parseInt("1"));
////					stub.getSistemaRemoto().liberarMesa(restaurantDTO, mozoDTO, mesaSimpleDTO);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//			
			//Redirigir nuevamente a abrir mesa
			request.getRequestDispatcher("/action?action=mesas_view").forward(request, response);
		}else if(accion.equals("reservar_mesa")){
			
			String cantidad_comensales = request.getParameter("cantidad_comensales");
//			if (stub.srOnline()){
//				System.out.println("## STUB ONLINE");
//				try {
//					MesaDTO mesaReservada = stub.getSistemaRemoto().reservarMesaPorCantidadComensales(restaurantDTO, Integer.parseInt(cantidad_comensales));
//					if(null != mesaReservada){
//						request.getRequestDispatcher("/action?action=mesas_view").forward(request, response);						
//					}else{
//						request.getRequestDispatcher("error.jsp").forward(request, response);
//					}
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
		}else if(accion.equals("listar_articulos")){
			List<ArticuloDTO> listaArticulos = administradorArticulos.listar();
			if (listaArticulos != null && 0 <= listaArticulos.size())
			{
				request.setAttribute("lista-articulos-response", "Hay " + listaArticulos.size() + " articulos");
				request.setAttribute("lista-articulos", listaArticulos);
			}else{
				request.setAttribute("lista-articulos-response", "No hay articulos");
				request.setAttribute("error", "No hay articulos");
				request.getRequestDispatcher("/error.jsp").forward(request, response);
			}
			
//			request.getRequestDispatcher("/articulos.jsp?area=" + area).forward(request, response);
			request.getRequestDispatcher("/articulos.jsp").forward(request, response);
		}else if(accion.equals("listar_ordenesdespacho")){
			List<OrdenDespachoDTO> listaOrdenesDespacho = administradorOrdenesDespacho.listar();
			if (listaOrdenesDespacho != null && 0 <= listaOrdenesDespacho.size())
			{
				request.setAttribute("lista-ordenesdespacho-response", "Hay " + listaOrdenesDespacho.size() + " ordenes de despacho");
				request.setAttribute("lista-ordenesdespacho", listaOrdenesDespacho);
			}else{
				request.setAttribute("lista-ordenesdespacho-response", "No hay ordenes de despacho");
				request.setAttribute("error", "No hay ordenes de despacho");
				request.getRequestDispatcher("/error.jsp").forward(request, response);
			}
			
			request.getRequestDispatcher("/ordenesdespacho.jsp").forward(request, response);
		}else if(accion.equals("listar_solicitudesarticulos")){
			List<SolicitudArticuloDTO> listaSolicitudesArticulos = administradorSolicitudesArticulo.listar();
			if (listaSolicitudesArticulos != null && 0 <= listaSolicitudesArticulos.size())
			{
				request.setAttribute("lista-solicitudesarticulos-response", "Hay " + listaSolicitudesArticulos.size() + " solicitudes de articulos");
				request.setAttribute("lista-solicitudesarticulos", listaSolicitudesArticulos);
			}else{
				request.setAttribute("lista-solicitudesarticulos-response", "No hay solicitudes de articulos");
				request.setAttribute("error", "No hay solicitudes de articulos");
				request.getRequestDispatcher("/error.jsp").forward(request, response);
			}
			
			request.getRequestDispatcher("/solicitudesarticulos.jsp").forward(request, response);
		}else if(accion.equals("item_pendiente_listo")){
			String area = request.getParameter("area");
			String id_item_comanda = request.getParameter("id_item_comanda");
			String estado = request.getParameter("estado");
			
//			if (stub.srOnline()){
//				System.out.println("## STUB ONLINE");
//				try {
////					Set<ItemComandaDTO> itemsComandaDTOs = new LinkedHashSet<ItemComandaDTO>();
////					ItemComandaDTO itemComandaDTO = new ItemComandaDTO();
////					itemComandaDTO.setId(Integer.parseInt(id_item_comanda));
////					itemsComandaDTOs.add(itemComandaDTO);
////					stub.getSistemaRemoto().cambiarEstadoItemsComanda(itemsComandaDTOs, new EstadoItemComandaDTO(estado));
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
			request.getRequestDispatcher("/action?action=listar_items_pendientes&area=" + area).forward(request, response);
		}else if(accion.equals("item_pendiente_entregado")){
			String area = request.getParameter("area");
			String id_item_comanda = request.getParameter("id_item_pedido");
			String estado = request.getParameter("estado");
			
//			if (stub.srOnline()){
//				System.out.println("## STUB ONLINE");
//				try {
////					Set<ItemComandaDTO> itemsComandaDTOs = new LinkedHashSet<ItemComandaDTO>();
////					ItemComandaDTO itemComandaDTO = new ItemComandaDTO();
////					itemComandaDTO.setId(Integer.parseInt(id_item_comanda));
////					itemsComandaDTOs.add(itemComandaDTO);
////					stub.getSistemaRemoto().cambiarEstadoItemsComanda(itemsComandaDTOs, new EstadoItemComandaDTO(estado));
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
			request.getRequestDispatcher("/action?action=listar_pedido").forward(request, response);
		}else if(accion.equals("listar_pedido")){
			
			String id_mesa = request.getParameter("id_mesa");
//			if (stub.srOnline()){
//				System.out.println("## STUB ONLINE");
//				try {
//					
////					MesaDTO mesaDto = new MesaSimpleDTO();
////					mesaDto.setId(Integer.parseInt(id_mesa));
////					ComandaDTO comandaDTO = stub.getSistemaRemoto().buscarComandaPorMesa(mesaDto);
////					if(null != comandaDTO){
////						request.setAttribute("comanda", comandaDTO);
////					}
////					List<ItemCartaDTO> itemCartaDTOs = stub.getSistemaRemoto().obtenerItemsCarta();
////					if(null != itemCartaDTOs){
////						request.setAttribute("items_carta", itemCartaDTOs);
////					}
//					request.setAttribute("id_mesa", id_mesa);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
			request.getRequestDispatcher("/items_pedido.jsp").forward(request, response);
		}else if(accion.equals("validar_almacen_item_pedido")){
		
			String id_item_carta= request.getParameter("id_item_carta");
			String cantidad_platos= request.getParameter("cantidad_platos");
			String id_mesa= request.getParameter("id_mesa");
//			if (stub.srOnline()){
//				System.out.println("## STUB ONLINE");
//				try {
//					ItemCartaDTO itemCartaDto = new ItemCartaCocinaDTO();
//					itemCartaDto.setId(Integer.parseInt(id_item_carta));
//					
//					MesaDTO mesaDTO = new MesaSimpleDTO();
//					mesaDTO.setId(Integer.parseInt(id_mesa));
//					ItemCartaDTO iteCartaDTO = new ItemCartaCocinaDTO(Integer.parseInt(id_item_carta));
//					
//					boolean agregarItemComanda = false;
//					
//					boolean hayStockArea = stub.getSistemaRemoto().hayStockItemCartaenArea(restaurantDTO, itemCartaDto, Integer.parseInt(cantidad_platos));
//					if(true == hayStockArea){
//						agregarItemComanda = true;
//					}else{
//						boolean hayStockDeposito = stub.getSistemaRemoto().hayStockItemCartaEnDeposito(restaurantDTO, itemCartaDto, Integer.parseInt(cantidad_platos));
//						if(true == hayStockDeposito){
//							agregarItemComanda = true;
//						}else{
////							stub.getSistemaRemoto().crearSolicitudRepoInstantanea(restaurantDTO, areaDto, producto, calidad, cantidad)
//						}
//					}
//					if(agregarItemComanda){
//						stub.getSistemaRemoto().agregarItemComanda(restaurantDTO, mesaDTO, itemCartaDto, Integer.parseInt(cantidad_platos));
////						request.getRequestDispatcher("/action?action=listar_pedido").forward(request, response);
//					}else{
//						request.setAttribute("error", "No hay stock en area productiva");												
//					}
					request.getRequestDispatcher("/action?action=listar_pedido").forward(request, response);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//			request.getRequestDispatcher("/items_pedido.jsp").forward(request, response);
		}else if(accion.equals("distribuir_pedido")){
			
			String id_mesa = request.getParameter("id_mesa");
//			if (stub.srOnline()){
//				System.out.println("## STUB ONLINE");
//				try {
//					
//					MesaDTO mesaDto = new MesaSimpleDTO();
//					mesaDto.setId(Integer.parseInt(id_mesa));
//					ComandaDTO comandaDTO = stub.getSistemaRemoto().buscarComandaPorMesa(mesaDto);
//					stub.getSistemaRemoto().distribuirPedido(restaurantDTO, comandaDTO);
//					request.setAttribute("id_mesa", id_mesa);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
			request.getRequestDispatcher("/action?action=listar_pedido").forward(request, response);
		}

		System.out.println("## FIN doGet #####################################");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("## INICIO doPost #####################################");
		
//		ActionController actionController = ActionController.getInstance();
//		
//		String action = req.getParameter("action");
//				
//		/* Si la accion enviada por el jsp es "cargar-xml" */
//		if(action.equals("cargar-xml")){
//
//			boolean isXML = true;
//			boolean isMultipart = ServletFileUpload.isMultipartContent(req);
//			File xmlFile = null;
//			
//			if (isMultipart) { 
//				// Create a factory for disk-based file items 
//				FileItemFactory factory = new DiskFileItemFactory(); 
//				// Create a new file upload handler 
//				ServletFileUpload upload = new ServletFileUpload(factory); 
//				
//				try { 
//					// Parse the request 
//					List /* FileItem */ items = upload.parseRequest(req); 
//					Iterator iterator = items.iterator(); 
//					while (iterator.hasNext()) { 
//						FileItem item = (FileItem) iterator.next(); 
//						if (!item.isFormField()) {
//							String fileName = item.getName();
//							if(!fileName.endsWith(".xml")){
//								isXML = false;
//								break;
//							}
//							String root = getServletContext().getRealPath("/");
//							File path = new File(root + "/xmlconsumos");
//							if (!path.exists()) {
//								boolean status = path.mkdirs();
//							}
//							File uploadedFile = new File(path + "/" + fileName);
//							System.out.println(uploadedFile.getAbsolutePath());
//							item.write(uploadedFile);
//							xmlFile = uploadedFile;
//						}
//					}
//				} catch (FileUploadException e) {
//					e.printStackTrace();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//				
//			} 
//			
//			if(isXML == false){
//				req.setAttribute("servicio-response", "NO es un archivo XML");
//			}
//			else if(!actionController.cargarConsumosXML(xmlFile)){
//				req.setAttribute("servicio-response", "NO se cargo el XML correctamente");	
//			} else {
//				req.setAttribute("servicio-response", "Se cargo el XML exitosamente!");	
//			}
//			
//			req.getRequestDispatcher("servicios.jsp?tipo-servicio=alta-consumos-xml").forward(req, resp);
//		}  else {
//			/* Despachar request a la pagina index.jsp (home) por default */
//			req.getRequestDispatcher("/index.jsp").forward(req, resp);	
//		}
//		
		System.out.println("## FIN doPost #####################################");
	}
}