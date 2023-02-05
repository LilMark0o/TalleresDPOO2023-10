package hamburguesasTaller2.uniandes.dppo.taller2.modelo;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Restaurante {
	private static List<ProductoMenu> menuBase;
	private static List<Ingrediente> ingredientes;
	private static List<Combo> combos;
	private Pedido pedido;
	
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
	private void cargarMenu() throws FileNotFoundException {
		String archivo = System.getProperty("user.dir")+"/data/"+"menu.txt";
		File file = new File(archivo);
		Scanner scan = new Scanner(file);
		while (scan.hasNextLine()) {
			String linea = scan.nextLine();
			String[] partes = linea.split(";");
			String nombre = partes[0];
			int precio = Integer.parseInt(partes[1]);
			ProductoMenu producto = new ProductoMenu(nombre, precio);
			menuBase.add(producto);
		}
		scan.close();
	}
	private void cargarIngredientes() throws FileNotFoundException {
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
	private void cargarCombos() throws FileNotFoundException {
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
				ProductoMenu producto = buscarProducto(partes[index]);
				combo.agregarItemAlCombo(producto);
			}
			combos.add(combo);
		}
		scan.close();
	}
	public ProductoMenu buscarProducto(String nombre) {
		for(ProductoMenu producto:menuBase) {
			if (producto.getNombre().equals(nombre)) {
				return producto;
			}
		}
		return null;
	}
	
	public void iniciarPedido(String nombreCliente, String direccionCliente) {
		pedido = new Pedido(nombreCliente,direccionCliente);	
	}
	
	public Pedido getPedidoEnCurso() {
		return pedido;
	}
	
	public void cerrarPedido() {
		Pedido.cerrarYGuardarPedido(pedido);
	}
	
	public List<ProductoMenu> getMenuBase() {
		return menuBase;
	}
	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}
	public List<Combo> getCombos() {
		return combos;
	}
	public ProductoMenu buscarProductoMenuPorIndice(int index) {
		return menuBase.get((index-1)); //el menos uno es porque el usuario ve la lista de 1 a size(), y no de 0 a size()
	}
	public Ingrediente buscarIngredientePorIndice(int index) {
		return ingredientes.get((index-1)); //el menos uno es porque el usuario ve la lista de 1 a size(), y no de 0 a size()
	}
	public Combo buscarComboPorIndice(int index) {
		return combos.get((index-1)); //el menos uno es porque el usuario ve la lista de 1 a size(), y no de 0 a size()
	}
}
