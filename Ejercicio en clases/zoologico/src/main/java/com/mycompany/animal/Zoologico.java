package com.mycompany.animal;

import java.util.ArrayList;
import java.util.List;

public class Zoologico {
    private String nombre;
    private List<Jaula> jaulas;
    private String direccion;
    private String telefono;

    public Zoologico(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.jaulas = new ArrayList<>();
    }

    public void aniadirJaula(Jaula jaula) {
        jaulas.add(jaula);
    }

    public void mostrarZoologico() {
        System.out.println("Zoologico: " + nombre + " Dirección: " + direccion + " Teléfono: " + telefono);
        for (Jaula j : jaulas) {
            System.out.println(j);
        }
    }

    public void mostrarMamiferos() {
        System.out.println("Mamíferos:");
        for (Jaula j : jaulas) {
            if (j.getAnimal() instanceof Mamifero) {
                System.out.println(j);
            }
        }
    }

    public void mostrarAves() {
        System.out.println("Aves:");
        for (Jaula j : jaulas) {
            if (j.getAnimal() instanceof Ave) {
                System.out.println(j);
            }
        }
    }

    public void mostrarPeces() {
        System.out.println("Peces:");
        for (Jaula j : jaulas) {
            if (j.getAnimal() instanceof Pez) {
                System.out.println(j);
            }
        }
    }

    // Método para buscar un animal por nombre
    public Animal buscarAnimalPorNombre(String nombre) {
        for (Jaula jaula : jaulas) {
            if (jaula.getAnimal().getNombre().equalsIgnoreCase(nombre)) {
                return jaula.getAnimal();
            }
        }
        return null;  // Si no se encuentra el animal
    }

    // Método para mostrar la acción del animal
    public void mostrarAccionDeAnimal(String nombreAnimal) {
        Animal animal = buscarAnimalPorNombre(nombreAnimal);
        if (animal != null) {
            System.out.println(animal.accion());  // Mostrar la acción que está haciendo el animal
        } else {
            System.out.println("Animal no encontrado.");
        }
    }
}
