package com.mycompany.minisupermercado;




import java.util.ArrayList;
import java.util.Scanner;

public class Tienda {
    static ArrayList<Cliente> clientes = new ArrayList<>();
    static ArrayList<Producto> productos = new ArrayList<>();
    static ArrayList<Venta> ventas = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("1. Registrar Cliente");
            System.out.println("2. Registrar Producto");
            System.out.println("3. Registrar Venta");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    registrarCliente();
                    break;
                case 2:
                    registrarProducto();
                    break;
                case 3:
                    registrarVenta();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 4);
    }

    private static void registrarCliente() {
        System.out.print("Ingrese ID del cliente: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese nombre del cliente: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese email del cliente: ");
        String email = scanner.nextLine();

        Cliente cliente = new Cliente(id, nombre, email);
        clientes.add(cliente);
        System.out.println("Cliente registrado exitosamente.");
    }

    private static void registrarProducto() {
        System.out.print("Ingrese ID del producto: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese precio del producto: ");
        double precio = scanner.nextDouble();

        Producto producto = new Producto(id, nombre, precio);
        productos.add(producto);
        System.out.println("Producto registrado exitosamente.");
    }

    private static void registrarVenta() {
        System.out.print("Ingrese ID del cliente: ");
        int clienteId = scanner.nextInt();
        Cliente cliente = buscarCliente(clienteId);
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.print("Ingrese ID del producto: ");
        int productoId = scanner.nextInt();
        Producto producto = buscarProducto(productoId);
        if (producto == null) {
            System.out.println("Producto no encontrado.");
            return;
        }

        System.out.print("Ingrese cantidad: ");
        int cantidad = scanner.nextInt();

        Venta venta = new Venta(ventas.size() + 1, cliente, producto, cantidad);
        ventas.add(venta);

        System.out.print("Seleccione método de pago (1. Efectivo, 2. Tarjeta): ");
        int metodoPago = scanner.nextInt();
        if (metodoPago == 1) {
            System.out.println("Pago en efectivo registrado.");
        } else if (metodoPago == 2) {
            System.out.println("Pago con tarjeta registrado.");
        } else {
            System.out.println("Método de pago no válido.");
        }

        System.out.println("Venta registrada exitosamente.");
    }

    private static Cliente buscarCliente(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.id == id) {
                return cliente;
            }
        }
        return null;
    }

    private static Producto buscarProducto(int id) {
        for (Producto producto : productos) {
            if (producto.id == id) {
                return producto;
            }
        }
        return null;
    }
}
