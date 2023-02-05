package hamburguesasTaller2.uniandes.dppo.taller2.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import hamburguesasTaller2.uniandes.dppo.taller2.consola.Producto;

public class Pedido {
	private static int numeroPedido = 0;
	private static HashMap<Integer, Pedido> historialPedidos;

	private int idPedido;
	private String nombreCliente;
	private String direccionCliente;
	private List<Producto> itemsPedido;
	private static double iva = 0.19;
	
	public Pedido(String nombreClientePar, String direccionClientePar) {
		nombreCliente = nombreClientePar;
		direccionCliente = direccionClientePar;
		numeroPedido +=1;
		idPedido = numeroPedido;
		itemsPedido = new ArrayList<>();
		
	}

	public static int getNumeroPedido() {
		return numeroPedido;
	}
	
	public void agregarItemAlPedido(Producto nuevoItem) {
		itemsPedido.add(nuevoItem);
	}


	public int getIdPedido() {
		return idPedido;
	}


	public String getNombreCliente() {
		return nombreCliente;
	}


	public String getDireccionCliente() {
		return direccionCliente;
	}
	
	private int getPrecioNetoPedido() {
		int precioTotal =0;
		for (Producto producto:itemsPedido) {
			precioTotal+= producto.getPrecio();
		}
		return precioTotal;
	}
	private float getPrecioIVAPedido() {
		return (float) (getPrecioNetoPedido()*iva);
	}
	private float getPrecioTotalPedido() {
		return (float) (getPrecioNetoPedido()+getPrecioIVAPedido());
	}
	
	
	public static void cerrarYGuardarPedido(Pedido pedido) {
		historialPedidos.put(pedido.getIdPedido(), pedido);
		//! FALTA GUARDAR UN ARCHIVO CON EL RECIBO
	}
	public Pedido buscarPedidoPorid(int ID) {
		Pedido pedido = historialPedidos.get(ID);
		return pedido;
	}
}
