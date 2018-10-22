package demo.main;

import java.util.List;
import java.util.Scanner;

import demo.def.Facade;
import demo.imple.FacadeImple;
import demo.mapping.Producto;

public class Main
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingresar id de cliente:");
		int idCliente = scanner.nextInt();
		Facade fac = new FacadeImple();
		List<Producto> productos = fac.obtenerProductosXCliente(idCliente);
		for (Producto cli:productos)
		{
			System.out.println(cli.toStringLindo());
			System.out.println("__");
		}
		System.out.println("--------");
		
		scanner.close();
	}
}
