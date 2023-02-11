package hamburguesasTaller2.uniandes.dppo.taller2.modelo;

public class Ingrediente {
	private String nombre;
	private int costoAdicional;
	
	public Ingrediente(String nombrePar, int costoAdicionalPar) {
		nombre = nombrePar;
		costoAdicional = costoAdicionalPar;
	}

	public String getNombre() {
		return nombre;
	}

	public int getCostoAdicional() {
		return costoAdicional;
	}

	public String toString() {
		return String.format("El ingrediente %s tiene el precio: $%d", nombre,costoAdicional);
	}
}
