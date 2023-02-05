package hamburguesasTaller2.uniandes.dppo.taller2.consola;

import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import hamburguesasTaller2.uniandes.dppo.taller2.modelo.Combo;
import hamburguesasTaller2.uniandes.dppo.taller2.modelo.Ingrediente;
import hamburguesasTaller2.uniandes.dppo.taller2.modelo.Producto;
import hamburguesasTaller2.uniandes.dppo.taller2.modelo.Restaurante;

public class Aplicacion {
	private static Restaurante menu;
	public static void main(String[] args) {
		System.out.println("Estadísticas sobre los Juegos Olímpicos\n");
		try {
			menu = new Restaurante();
			//menu.cargarMenu();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenu();
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
				if(opcion_seleccionada == 1) {
					cargarDatos();
				}
				else if (opcion_seleccionada == 2) {
					System.out.println("Intentaré cargar los datos :D");
					mostrarData();
					
				}else if (opcion_seleccionada == 3) {
					System.out.println("Chaolin pin pín	");
					continuar = false;
				}
				else
				{
					System.out.println("Por favor seleccione una opción válida.");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			}
		}
	}
	private static void cargarDatos() {
		try {
			menu.cargarRestaurante();
        	System.out.println("¡Se han cargado los datos de forma exitosa!");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	private static void mostrarData() {
        System.out.println("Primero van los productos del Menú");
        ArrayList<Producto> bobolon = menu.getMenuBase();
        for (Producto producto : bobolon) {
        	System.out.println(producto);
        }
        
        System.out.println("Ahora van los ingredientes");

        List<Ingrediente> ingredientes = menu.getIngredientes();
        for (Ingrediente ingrediente : ingredientes) {
        	System.out.println(ingrediente);
        }
        
        System.out.println("Ahora van los combos");
        List<Combo> combos = menu.getCombos();
        for (Combo combo : combos) {
        	System.out.println(combo);
        }
	}
	public static void mostrarMenu()
	{
		System.out.println("\nOpciones de la aplicación\n");
		System.out.println("1. Cargar Datos");
		System.out.println("2. Mostrar Datos");
		System.out.println("3. Salir de la aplicación\n");
	}

	public static String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}

}
