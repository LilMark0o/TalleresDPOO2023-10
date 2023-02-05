package hamburguesasTaller2.uniandes.dppo.taller2.modelo;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Restaurante {
	private List<Producto> menuBase;
	private List<Ingrediente> ingredientes;
	private List<Combo> combos;
	
	public Restaurante() throws FileNotFoundException{
		menuBase = new ArrayList<>();
		ingredientes = new ArrayList<>();
		combos = new ArrayList<>();
	}
	public void cargarRestaurante() throws FileNotFoundException {
		cargarMenu();
		cargarIngredientes();
		cargarCombos();
	}
	public void cargarMenu() throws FileNotFoundException {
		String archivo = System.getProperty("user.dir")+"/data/"+"menu.txt";
		File file = new File(archivo);
		Scanner scan = new Scanner(file);
		while (scan.hasNextLine()) {
			String linea = scan.nextLine();
			String[] partes = linea.split(";");
			String nombre = partes[0];
			int precio = Integer.parseInt(partes[1]);
			Producto producto = new Producto(nombre, precio);
			menuBase.add(producto);
		}
		scan.close();
	}
	public void cargarIngredientes() throws FileNotFoundException {
		String archivo = System.getProperty("user.dir")+"/data/"+"ingredientes.txt";
		File file = new File(archivo);
		Scanner scan = new Scanner(file);
		while (scan.hasNextLine()) {
			String linea = scan.nextLine();
			String[] partes = linea.split(";");
			String nombre = partes[0];
			int precio = Integer.parseInt(partes[1]);
			Ingrediente ingrediente = new Ingrediente(nombre, precio);
			ingredientes.add(ingrediente);
		}
		scan.close();
	}
	public void cargarCombos() throws FileNotFoundException {
		String archivo = System.getProperty("user.dir")+"/data/"+"combos.txt";
		File file = new File(archivo);
		Scanner scan = new Scanner(file);
		while (scan.hasNextLine()) {
			String linea = scan.nextLine();
			String[] partes = linea.split(";");
			String nombre = partes[0];
			double precio = Double.parseDouble(partes[1].replace("%", ""))/100;
			Combo combo = new Combo(nombre, precio);
			for (int index=2;index<partes.length;index++){
				Producto producto = buscarProducto(partes[index]);
				combo.agregarItemAlCombo(producto);
			}
			combos.add(combo);
		}
		scan.close();
	}
	public Producto buscarProducto(String nombre) {
		for(Producto producto:menuBase) {
			if (producto.getNombre().equals(nombre)) {
				return producto;
			}
		}
		return null;
	}
	
	public ArrayList<Producto> getMenuBase() {
		return (ArrayList<Producto>) menuBase;
	}
	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}
	public List<Combo> getCombos() {
		return combos;
	}
}
