package hamburguesasTaller2.uniandes.dppo.taller2.modelo;

import java.util.ArrayList;
import java.util.List;

public class ProductoAjustado {
	private String nombre;
	private int precio;
	private List<Ingrediente> agregados;
	private List<Ingrediente> quitados;

	public ProductoAjustado(ProductoMenu productoBase) {
		nombre = productoBase.getNombre();
		precio = productoBase.getPrecioBase();
		agregados = new ArrayList<>();
		quitados = new ArrayList<>();
	}
	public void agregarIngrediente(Ingrediente ingrediente){
		agregados.add(ingrediente);
		precio += ingrediente.getCostoAdicional();
	}
	public void quitarIngrediente(Ingrediente ingrediente){
		quitados.add(ingrediente);	
	}
	public String getNombre() {
		return nombre;
	}
	public int getPrecio() {
		return precio;
	}
	public List<Ingrediente> getAgregados() {
		return agregados;
	}
	public List<Ingrediente> getQuitados() {
		return quitados;
	}
}