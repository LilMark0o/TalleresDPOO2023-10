package hamburguesasTaller2.uniandes.dppo.taller2.modelo;

public class Producto {
	private String nombre;
	private int precioBase;
	
	public Producto(String nombrePar, int precioBasePar) {
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
	
}
