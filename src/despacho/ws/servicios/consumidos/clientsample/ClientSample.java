package despacho.ws.servicios.consumidos.clientsample;

import despacho.ws.servicios.consumidos.*;

public class ClientSample {

	public static void main(String[] args) {
	        System.out.println("***********************");
	        System.out.println("Create Web Service Client...");
	        ServidorEstadoEntregaBeanService service1 = new ServidorEstadoEntregaBeanService();
	        System.out.println("Create Web Service...");
	        ServidorEstadoEntregaBean port1 = service1.getServidorEstadoEntregaBeanPort();
	        System.out.println("Call Web Service Operation...");
	        System.out.println("Server said: " + port1.notificarEntregaDespacho(57));
	        System.out.println("Create Web Service...");
	        ServidorEstadoEntregaBean port2 = service1.getServidorEstadoEntregaBeanPort();
	        System.out.println("Call Web Service Operation...");
	        System.out.println("Server said: " + port2.notificarEntregaDespacho(92));
	        System.out.println("***********************");
	        System.out.println("Call Over!");
	}
}
