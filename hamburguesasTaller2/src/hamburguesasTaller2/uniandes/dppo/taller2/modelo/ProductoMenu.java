package hamburguesasTaller2.uniandes.dppo.taller2.modelo;

public class ProductoMenu {
	private String nombre;
	private int precioBase;
	
	public ProductoMenu(String nombrePar, int precioBasePar) {
		nombre = nombrePar;
		precioBase = precioBasePar;
	}

	public String getNombre() {
		return nombre;
	}

	public int getPrecioBase() {
		return precioBase;
	}

	public String toString() {
		return String.format("El producto %s tiene el precio: $%d", this.nombre,this.precioBase);
	}
	public String toFactura() {
		String text ="";
		text+= String.format("1 unidad del producto: %s\n", nombre);
		text+= String.format("Tiene un precio de: %d\n", precioBase);
		return text;
	}
	
}
