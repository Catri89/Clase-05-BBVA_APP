package demo.mapping;

import java.util.List;
import java.util.Scanner;

public class Test
{
	public static void main(String[] args)
	{
		Conexion.abreConexion();
		try
		{
			procesa();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	public static void procesa()
	{
		int idcli = 0; 
		String nombre = null; 
		String direccion = null; 
		int tipocli = 0; 

		Scanner scanner = new Scanner(System.in);
		String resp = "";
		while (!resp.equals("esc"))
		{
			resp = menu(scanner);
			switch (resp)
			{
				case "1":
					buscarTodos();
					break;
				case "2":
					System.out.println("Ingresar id de cliente:");
					buscar(scanner.nextInt());
					break;
				case "3":
					System.out.println("Ingresar id de cliente a modificar:");
					idcli = scanner.nextInt(); 
					nombre = scanner.nextLine(); 
					System.out.println("Ingresar nuevo nombre:");
					nombre = scanner.nextLine(); 
					System.out.println("Ingresar nueva direccion:");
					direccion = scanner.nextLine(); 
					System.out.println("Ingresar nuevo tipo de cliente:");
					tipocli = scanner.nextInt(); 
					modificar(idcli, nombre, direccion, tipocli);
					break;
				case "4":
					System.out.println("Ingresar id de cliente a crear:");
					idcli = scanner.nextInt(); 
					System.out.println("Ingresar nuevo nombre:");
					nombre = scanner.nextLine(); 
					System.out.println("Ingresar nueva direccion:");
					direccion = scanner.nextLine(); 
					System.out.println("Ingresar nuevo tipo de cliente:");
					tipocli = scanner.nextInt(); 
					insertar(idcli, nombre, direccion, tipocli);
					break;
				default:
			}
		}
		scanner.close();
		System.out.println("nosvimo");
	}

	public static void buscarTodos()
	{
		ClienteDAOImple dao = new ClienteDAOImple();
		//Cliente c = null;
		System.out.println("__");
		List<Cliente> clientes = dao.buscarTodos();
		for (Cliente cli:clientes)
		{
			System.out.println(cli.toStringLindo());
			System.out.println("__");
		}
		System.out.println("--------");
	}

	public static void buscar(int idCliente)
	{
		ClienteDAOImple dao = new ClienteDAOImple();
		Cliente c = dao.buscar(idCliente);
		System.out.println(c.toStringLindo());
		System.out.println("--------");
	}

	public static void modificar(int idCliente, String nombre, String direccion, int tipoCliente)
	{
		ClienteDAOImple dao = new ClienteDAOImple();
		int res = dao.update(idCliente,nombre,direccion,tipoCliente);
		if (res == 0){
			System.out.println("No se encontro el id " + idCliente);
		}else{
			System.out.println("Cliente actualizado:\n");
			buscar(idCliente);
		}
		System.out.println("--------");
	}

	public static void insertar(int idCliente, String nombre, String direccion, int tipoCliente)
	{
		ClienteDAOImple dao = new ClienteDAOImple();
		int res = dao.insert(idCliente,nombre,direccion,tipoCliente);
		if (res == 0){
			System.out.println("No se pudo dar de alta");
		}else{
			System.out.println("Cliente insertado:\n");
			buscar(idCliente);
		}
		System.out.println("--------");
	}

	public static String menu(Scanner scanner)
	{
		System.out.println("Menu"
				+ "\n(1)Buscar todos"
				+ "\n(2)Buscar uno"
				+ "\n(3)Update uno"
				+ "\n(4)Insert uno"
				+ "\n(esc) Salir");
		String res = scanner.next();
		return res;
	}
}