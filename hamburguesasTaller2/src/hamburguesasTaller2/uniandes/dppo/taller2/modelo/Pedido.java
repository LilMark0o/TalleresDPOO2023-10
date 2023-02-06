package hamburguesasTaller2.uniandes.dppo.taller2.modelo;

import java.io.FileWriter;
import java.io.IOException;
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
	
	public String facturaBase() {
		String text = "";
		text += String.format("--- factura de la compra con ID: %d ---\n",idPedido);
		text += String.format("Factura emitida a nombre de: %s\n",nombreCliente);
		text += String.format("Envio hecho hacia la dirección: %s\n",direccionCliente);
		return text;
	}
	public String facturaFinal() {
		String text = "";
		text += String.format("\nEl precio neto de la compra es: $%d\n",getPrecioNetoPedido());
		text += String.format("El precio del IVA de la compra es: $%f\n",getPrecioIVAPedido());
		text += String.format("El precio final de la compra es: $%f\n",getPrecioTotalPedido());

		return text;
	}
	public String textoFacturaTodo() {
		String text="";
		text+= facturaBase();
		for (Producto producto:itemsPedido) {
			text+= producto.getTextoFactura();
			text+="\n";	
		}
		text+=facturaFinal();
		return text;
	}
	
	public void guardarFactura() throws IOException {
		String text = textoFacturaTodo();
		String idPedidoString = Integer.toString(idPedido);
		String archivo = System.getProperty("user.dir")+"/data/"+"facturaID"+idPedidoString+".txt";

		FileWriter writer = new FileWriter(archivo);
		writer.write(text);
		writer.close();
	}
	
	public Pedido buscarPedidoPorid(int ID) {
		Pedido pedido = historialPedidos.get(ID);
		return pedido;
	}
}
