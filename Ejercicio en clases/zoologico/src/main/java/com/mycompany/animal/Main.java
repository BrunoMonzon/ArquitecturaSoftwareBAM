/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.animal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Zoologico zoologico = new Zoologico("Zoo Nacional", "Calle Principal", "123456");

        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Añadir Mamífero");
            System.out.println("2. Añadir Ave");
            System.out.println("3. Añadir Pez");
            System.out.println("4. Mostrar Mamíferos");
            System.out.println("5. Mostrar Aves");
            System.out.println("6. Mostrar Peces");
            System.out.println("7. Mostrar Zoológico");
            System.out.println("8. Mostrar acción de un animal");  // Nueva opción para ver qué está haciendo el animal
            System.out.println("9. Salir");
            System.out.print("Elija una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar buffer

            switch (opcion) {
                case 1:
                    FabricaAbstracta fabricaMamifero = new FabricaMamifero();
                    System.out.print("Ingrese el tipo de mamífero: ");
                    String mamifero = scanner.nextLine();
                    Animal animalMamifero = fabricaMamifero.crearAnimal(mamifero);
                    if (animalMamifero != null) {
                        Jaula jaulaMamifero = new Jaula(animalMamifero, 2.5, 3.0, 4.0);
                        zoologico.aniadirJaula(jaulaMamifero);
                        System.out.println(mamifero + " añadido al zoológico.");
                    } else {
                        System.out.println("Mamífero no reconocido.");
                    }
                    break;
                case 2:
                    FabricaAbstracta fabricaAve = new FabricaAve();
                    System.out.print("Ingrese el tipo de ave: ");
                    String ave = scanner.nextLine();
                    Animal animalAve = fabricaAve.crearAnimal(ave);
                    if (animalAve != null) {
                        Jaula jaulaAve = new Jaula(animalAve, 2.0, 3.5, 2.5);
                        zoologico.aniadirJaula(jaulaAve);
                        System.out.println(ave + " añadida al zoológico.");
                    } else {
                        System.out.println("Ave no reconocida.");
                    }
                    break;
                case 3:
                    FabricaAbstracta fabricaPez = new FabricaPez();
                    System.out.print("Ingrese el tipo de pez: ");
                    String pez = scanner.nextLine();
                    Animal animalPez = fabricaPez.crearAnimal(pez);
                    if (animalPez != null) {
                        Jaula jaulaPez = new Jaula(animalPez, 1.0, 2.0, 1.5);
                        zoologico.aniadirJaula(jaulaPez);
                        System.out.println(pez + " añadido al zoológico.");
                    } else {
                        System.out.println("Pez no reconocido.");
                    }
                    break;
                case 4:
                    zoologico.mostrarMamiferos();
                    break;
                case 5:
                    zoologico.mostrarAves();
                    break;
                case 6:
                    zoologico.mostrarPeces();
                    break;
                case 7:
                    zoologico.mostrarZoologico();
                    break;
                case 8:  // Nueva funcionalidad para mostrar la acción del animal
                    System.out.println("Animales en el zoológico:");
                    zoologico.mostrarZoologico();  // Muestra los animales
                    System.out.print("Ingrese el nombre del animal para ver qué está haciendo: ");
                    String nombreAnimal = scanner.nextLine();
                    Animal animal = zoologico.buscarAnimalPorNombre(nombreAnimal);  // Método para buscar animal
                    if (animal != null) {
                        System.out.println(animal.accion());  // Muestra la acción del animal
                    } else {
                        System.out.println("Animal no encontrado.");
                    }
                    break;
                case 9:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }

        scanner.close();
    }
}
