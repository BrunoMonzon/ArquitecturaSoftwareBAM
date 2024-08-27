package cochesresponsabilidad;


import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuCoches {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Agregar un nuevo coche");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    String marca = "";
                    int modelo = 0;
                    String placa = "";
                    String color = "";
                    int cilindrada = 0;

                    // Obtener detalles del coche
                    try {
                        System.out.print("Marca: ");
                        marca = scanner.nextLine();
                        
                        System.out.print("Modelo: ");
                        modelo = scanner.nextInt();
                        scanner.nextLine(); // Limpiar el buffer

                        System.out.print("Placa: ");
                        placa = scanner.nextLine();

                        System.out.print("Color: ");
                        color = scanner.nextLine();

                        System.out.print("Cilindrada: ");
                        cilindrada = scanner.nextInt();
                        scanner.nextLine(); // Limpiar el buffer

                        // Crear el coche y guardarlo en la base de datos
                        Coche coche = new Coche(marca, modelo, placa, color, cilindrada);
                        coche.GuardarBd();
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                        scanner.nextLine(); // Limpiar el buffer
                    }
                    break;

                case 2:
                    System.out.println("Saliendo...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}
