package hamburguesasTaller2.uniandes.dppo.taller2.modelo;

import java.lang.Math;

import java.util.ArrayList;
import java.util.List;

public class Combo {
	private String nombreCombo;
	private double descuento;
	private List<Producto> itemsCombo;

	
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
	public void agregarItemAlCombo(Producto producto) {
		itemsCombo.add(producto);
	}
	public double getPrecio() {
		int precioTotal = 0;
		for(Producto producto : itemsCombo) {
			precioTotal += producto.getPrecioBase();
		}
		return (precioTotal*(1-descuento));
	}
	public String toString() {
		int discount = (int) (descuento*100);
		int price = (int) Math.round(getPrecio());
		return String.format("El combo %s tiene un descuento del: %d%% y un precio de: %d", nombreCombo,discount,price);
	}
	
}
