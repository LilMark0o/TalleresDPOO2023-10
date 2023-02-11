package hamburguesasTaller2.uniandes.dppo.taller2.consola;

import java.io.FileNotFoundException;
import java.util.List;

import hamburguesasTaller2.uniandes.dppo.taller2.modelo.Combo;
import hamburguesasTaller2.uniandes.dppo.taller2.modelo.Ingrediente;
import hamburguesasTaller2.uniandes.dppo.taller2.modelo.ProductoAjustado;
import hamburguesasTaller2.uniandes.dppo.taller2.modelo.ProductoMenu;
import hamburguesasTaller2.uniandes.dppo.taller2.modelo.Restaurante;

public class Producto {
	private String nombre;
	private int precioTotal;
	private String textoFactura;
	
	public Producto(ProductoMenu producto) {
		nombre = producto.getNombre();
		precioTotal = producto.getPrecioBase();
		textoFactura = producto.toFactura();

	}
	public Producto(ProductoAjustado producto) {
		nombre = producto.getNombre();
		precioTotal = producto.getPrecio();
		textoFactura = producto.toFactura();
	}
	public Producto (Combo combo) {
		nombre= combo.getNombreCombo();
		precioTotal = (int) combo.getPrecio();
		textoFactura = combo.toFactura();

	}
	public String getNombre() {
		return nombre;
	}
	public int getPrecio() {
		return precioTotal;
	}
	public String getTextoFactura() {
		return textoFactura;
	}
	
	public static void mostrarProductosMenu(Restaurante restaurante) throws FileNotFoundException {
		List<ProductoMenu> listaMenu = restaurante.getMenuBase();
		for (int index=0;index<listaMenu.size();index++) {
			System.out.printf("\n%d. %s",(index+1),listaMenu.get(index));
		}
	}
	public static void mostrarIngredientes(Restaurante restaurante) throws FileNotFoundException {
		List<Ingrediente> listaIngredientes = restaurante.getIngredientes();
		for (int index=0;index<listaIngredientes.size();index++) {
			System.out.printf("\n%d. %s",(index+1),listaIngredientes.get(index));
		}
	}
	public static void mostrarProductosCombos(Restaurante restaurante) throws FileNotFoundException {
		List<Combo> listaCombos = restaurante.getCombos();
		for (int index=0;index<listaCombos.size();index++) {
			System.out.printf("\n%d. %s",(index+1),listaCombos.get(index));
		}
	}
	
}
