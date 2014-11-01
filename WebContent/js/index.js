$(document).ready(function(){
	var validarSubmitAperturaMesaSimple = function(){
		if( '' == $('#legajo_mozo').val() || false == $.isNumeric( $('#legajo_mozo').val() ) ||  
			'' == $('#cantidad_comensales').val() || false == $.isNumeric( $('#legajo_mozo').val() ) )
		{
			alert("Debe ingresar lejago del mozo (numerico) y cantidad de comensales (numerico)");
			return false;
		}
		return true;
	}
	var validarSubmitAperturaMesaCompuesta = function(){
		if( '' == $('#legajo_mozo').val() || false == $.isNumeric( $('#legajo_mozo').val() ) ||  
			'' == $('#cantidad_comensales').val() || false == $.isNumeric( $('#legajo_mozo').val() ) ||
			1 >= $('input:checkbox[name="seleccion_mesa"]:checked').length)
		{
			alert("Debe ingresar lejago del mozo (numerico), cantidad de comensales (numerico) y seleccionar mas de una mesa");
			return false;
		}

		return true;
	}
	
	var validarSubmitReservaMesaSimple = function(){
		if( '' == $('#cantidad_comensales').val() || false == $.isNumeric( $('#cantidad_comensales').val() ) )
		{
			alert("Debe ingresar cantidad de comensales (numerico)");
			return false;
		}
		return true;
	}
	
	var validarSubmitValidarItemPedidoAlmacen = function(){
		if( '' == $('#cantidad_platos').val() || false == $.isNumeric( $('#cantidad_platos').val() ) || '' == $('#select_items_carta').val())
		{
			alert("Debe seleccionar un plato e ingresar la cantidad (numerico)");
			return false;
		}
		return true;
	}
	
	var submitMesaAction = function (action, id_mesa){
		var mesas_form = $('#mesas_form');
		mesas_form.append('<input type="hidden" name="action" value="' + action + '">' );
		mesas_form.append('<input type="hidden" name="id_mesa" value="' + id_mesa + '">' );
		mesas_form.submit();
	};
	
	$(".js_accion_mesa").click(function(){
		if('abrir_mesa' == $(this).attr('action')){
			if(false == validarSubmitAperturaMesaSimple()){
				return false;
			}
		}
		if('abrir_mesa_compuesta' == $(this).attr('action')){
			if(false == validarSubmitAperturaMesaCompuesta()){
				return false;
			}
		}
		if('reservar_mesa' == $(this).attr('action')){
			if(false == validarSubmitReservaMesaSimple()){
				return false;
			}
		}
		var id_mesa = $(this).parents('tr').first().attr('id_mesa');
		submitMesaAction($(this).attr('action'), id_mesa);
	})
	
	var submitItemsPendientesAction = function (action, id_item_comanda){
		var items_pendientes_form = $('#items_pendientes_form');
		items_pendientes_form.append('<input type="hidden" name="action" value="' + action + '">' );
		items_pendientes_form.append('<input type="hidden" name="id_item_comanda" value="' + id_item_comanda + '">' );
		if('item_pendiente_listo' == action){
			items_pendientes_form.append('<input type="hidden" name="estado" value="' + "LISTO" + '">' );
		}
		if('item_pendiente_entregado' == action){
			items_pendientes_form.append('<input type="hidden" name="estado" value="' + "ENTREGADO" + '">' );
		}
		
		items_pendientes_form.submit();
	};
	
	$(".js_accion_item_pendiente").click(function(){
		var id_item_comanda = $(this).parents('tr').first().attr('id_item_comanda');
		submitItemsPendientesAction($(this).attr('action'), id_item_comanda);
	})
	
	var submitItemsPedidoAction = function (action, id_item_pedido, id_mesa){
		var items_pendientes_form = $('#mesas_form');
		items_pendientes_form.append('<input type="hidden" name="action" value="' + action + '">' );
		items_pendientes_form.append('<input type="hidden" name="id_item_pedido" value="' + id_item_pedido + '">' );
		items_pendientes_form.append('<input type="hidden" name="id_mesa" value="' + id_mesa + '">' );
		items_pendientes_form.submit();
	};
	
	var submitItemsPedidoAction2 = function (action, id_item_pedido, id_item_carta, cantidad_platos, id_mesa){
		var items_pendientes_form = $('#items_pedido_form');
		items_pendientes_form.append('<input type="hidden" name="action" value="' + action + '">' );
		items_pendientes_form.append('<input type="hidden" name="id_item_pedido" value="' + id_item_pedido + '">' );
		items_pendientes_form.append('<input type="hidden" name="id_item_carta" value="' + id_item_carta + '">' );
		items_pendientes_form.append('<input type="hidden" name="cantidad_platos" value="' + cantidad_platos + '">' );
		items_pendientes_form.append('<input type="hidden" name="id_mesa" value="' + id_mesa + '">' );
		if('item_pendiente_entregado' == action){
			items_pendientes_form.append('<input type="hidden" name="estado" value="' + "ENTREGADO" + '">' );
		}
		items_pendientes_form.submit();
	};
	
	$(".js_accion_item_pedido").click(function(){

		if("validar_almacen_item_pedido" == $(this).attr('action')){
			if(!validarSubmitValidarItemPedidoAlmacen()){
				return false;
			}
			var cantidad_platos = $('#cantidad_platos').val(); 
			var id_item_carta = $('#select_items_carta').val();
			
			//agregar_item_pedido
			submitItemsPedidoAction2($(this).attr('action'), '', id_item_carta, cantidad_platos);
			return;
		}
			
		var id_item_pedido = $(this).parents('tr').first().attr('id_item_pedido');
		
		if("item_pendiente_entregado" == $(this).attr('action')){
			submitItemsPedidoAction2($(this).attr('action'), id_item_pedido);
			return;
		}
		submitItemsPedidoAction($(this).attr('action'), id_item_pedido,'', id_item_carta, cantidad_platos);
	})
	
	$(".js_accion_pedido").click(function(){
		var id_mesa = $(this).parents('tr').first().attr('id_mesa');
		
		if("distribuir_pedido" == $(this).attr('action')){
			submitItemsPedidoAction2($(this).attr('action'), '', '', '', id_mesa);
			return;
		}
		//var id_item_pedido = $(this).parents('tr').first().attr('id_item_pedido');
		submitItemsPedidoAction($(this).attr('action'), '', id_mesa);
		//submitMesaAction($(this).attr('action'), id_mesa);
	})
	
});


//LOGIN
jQuery(document).ready(function(){
	jQuery("#cmdIngresar").click(function(){
		if (jQuery("#username").val() == ""){
			alert("Debe llenar los campos para ingresar.");
			return false;
		}
		
		if (jQuery("#password").val() == ""){
			alert("Debe llenar los campos para ingresar.");
			return false;
		}
	});
});

//Valor de un parametro del request
//$.urlParam = function(name){
//    var results = new RegExp('[\\?&]' + name + '=([^&#]*)').exec(window.location.href);
//    if(results == null){
//    	return 0;
//    }
//    //return results[1] || 0;
//    return results[1];
//}
