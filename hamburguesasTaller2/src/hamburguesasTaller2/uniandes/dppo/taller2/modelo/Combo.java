package hamburguesasTaller2.uniandes.dppo.taller2.modelo;

import java.lang.Math;

import java.util.ArrayList;
import java.util.List;

public class Combo {
	private String nombreCombo;
	private double descuento;
	private List<ProductoMenu> itemsCombo;

	
	public Combo(String nombre, double descuentoPar) {
		nombreCombo=nombre;
		descuento=descuentoPar;
		itemsCombo = new ArrayList<>();
	}

	public String getNombreCombo() {
		return nombreCombo;
	}

	public double getDescuento() {
		return descuento;
	}
	public void agregarItemAlCombo(ProductoMenu producto) {
		itemsCombo.add(producto);
	}
	public double getPrecio() {
		int precioTotal = 0;
		for(ProductoMenu producto : itemsCombo) {
			precioTotal += producto.getPrecioBase();
		}
		return (precioTotal*(1-descuento));
	}
	public String toString() {
		int discount = (int) (descuento*100);
		int price = (int) Math.round(getPrecio());
		return String.format("El combo %s tiene un descuento del: %d%% y un precio de: %d", nombreCombo,discount,price);
	}
	
	public String toFactura() {
		String text= "";
		text += String.format("1 unidad del combo: %s, el combo contiene:\n",nombreCombo);

		for (ProductoMenu producto: itemsCombo) {
			text += String.format("\t- %s\n",producto.getNombre());
		}
		
		text += String.format("Al combo se le aplicó un descuento del: %f%%\n",descuento*100);
		text += String.format("El precio total del combo es de: $%f\n",getPrecio());
		return text;
	}

	
}
