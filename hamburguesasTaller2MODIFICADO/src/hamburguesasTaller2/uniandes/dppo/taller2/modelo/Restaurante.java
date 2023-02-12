package hamburguesasTaller2.uniandes.dppo.taller2.modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Restaurante {
	private static List<ProductoMenu> menuBase;
	private static List<Ingrediente> ingredientes;
	private static List<Combo> combos;
	private static List<Bebida> bebidas;
	private static Pedido pedido;

	public Restaurante() throws FileNotFoundException {
		menuBase = new ArrayList<>();
		ingredientes = new ArrayList<>();
		combos = new ArrayList<>();
		bebidas = new ArrayList<>();
	}

	public void cargarRestaurante() throws FileNotFoundException {
		cargarMenu();
		cargarIngredientes();
		cargarBebibas();
		cargarCombos();
	}

	private void cargarMenu() throws FileNotFoundException {
		String archivo = System.getProperty("user.dir") + "/data/" + "menu.txt";
		File file = new File(archivo);
		Scanner scan = new Scanner(file);
		while (scan.hasNextLine()) {
			String linea = scan.nextLine();
			String[] partes = linea.split(";");
			String nombre = partes[0];
			int precio = Integer.parseInt(partes[1]);
			int calorias = Integer.parseInt(partes[2]);
			ProductoMenu producto = new ProductoMenu(nombre, precio, calorias);
			menuBase.add(producto);
		}
		scan.close();
	}

	private void cargarBebibas() throws FileNotFoundException {
		String archivo = System.getProperty("user.dir") + "/data/" + "bebidas.txt";
		File file = new File(archivo);
		Scanner scan = new Scanner(file);
		while (scan.hasNextLine()) {
			String linea = scan.nextLine();
			String[] partes = linea.split(";");
			String nombre = partes[0];
			int precio = Integer.parseInt(partes[1]);
			int calorias = Integer.parseInt(partes[2]);
			Bebida bebida = new Bebida(nombre, precio, calorias);
			bebidas.add(bebida);
		}
		scan.close();
	}

	private void cargarIngredientes() throws FileNotFoundException {
		String archivo = System.getProperty("user.dir") + "/data/" + "ingredientes.txt";
		File file = new File(archivo);
		Scanner scan = new Scanner(file);
		while (scan.hasNextLine()) {
			String linea = scan.nextLine();
			String[] partes = linea.split(";");
			String nombre = partes[0];
			int precio = Integer.parseInt(partes[1]);
			int calorias = Integer.parseInt(partes[2]);
			Ingrediente ingrediente = new Ingrediente(nombre, precio, calorias);
			ingredientes.add(ingrediente);
		}
		scan.close();
	}

	private void cargarCombos() throws FileNotFoundException {
		String archivo = System.getProperty("user.dir") + "/data/" + "combos.txt";
		File file = new File(archivo);
		Scanner scan = new Scanner(file);
		while (scan.hasNextLine()) {
			String linea = scan.nextLine();
			String[] partes = linea.split(";");
			String nombre = partes[0];
			double precio = Double.parseDouble(partes[1].replace("%", "")) / 100;
			Combo combo = new Combo(nombre, precio);
			for (int index = 2; index < partes.length; index++) {
				if (index != (partes.length - 1)) {
					ProductoMenu producto = buscarProducto(partes[index]);
					combo.agregarItemAlCombo(producto);
				} else {
					Bebida bebida = buscarBebida(partes[index]);
					combo.agregarItemAlCombo(bebida);
				}
			}
			combos.add(combo);
		}
		scan.close();
	}

	public ProductoMenu buscarProducto(String nombre) {
		for (ProductoMenu producto : menuBase) {
			if (producto.getNombre().equals(nombre)) {
				return producto;
			}
		}
		return null;
	}

	public Bebida buscarBebida(String nombre) {
		for (Bebida bebida : bebidas) {
			if (bebida.getNombre().equals(nombre)) {
				return bebida;
			}
		}
		return null;
	}

	public void iniciarPedido(String nombreCliente, String direccionCliente) {
		pedido = new Pedido(nombreCliente, direccionCliente);
	}

	public Pedido getPedidoEnCurso() {
		return pedido;
	}

	public void actualizarPedido(Pedido pedidoNuevo) {
		pedido = pedidoNuevo;
	}

	public void cerrarPedido() throws IOException {
		pedido.guardarFactura();
		pedido.guardarPedidoEnHistorial(pedido);
	}

	public boolean hayPedidoIgual() {
		return pedido.hayPedidosIguales(pedido);
	}

	public ArrayList<Integer> listaDePedidosIguales() {
		return pedido.buscarPedidoIgual(pedido);
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

	public List<Bebida> getBebidas() {
		return bebidas;
	}

	public ProductoMenu buscarProductoMenuPorIndice(int index) {
		return menuBase.get((index - 1)); // el menos uno es porque el usuario ve la lista de 1 a size(), y no de 0 a
											// size()
	}

	public Ingrediente buscarIngredientePorIndice(int index) {
		return ingredientes.get((index - 1)); // el menos uno es porque el usuario ve la lista de 1 a size(), y no de 0
												// a size()
	}

	public Combo buscarComboPorIndice(int index) {
		return combos.get((index - 1)); // el menos uno es porque el usuario ve la lista de 1 a size(), y no de 0 a
										// size()
	}

	public Bebida buscarBebidaPorIndice(int index) {
		return bebidas.get((index - 1)); // el menos uno es porque el usuario ve la lista de 1 a size(), y no de 0 a
											// size()
	}
}
