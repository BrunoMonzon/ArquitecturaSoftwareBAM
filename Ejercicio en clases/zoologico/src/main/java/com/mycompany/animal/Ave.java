/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.animal;

public class Ave implements Animal {
    private String nombre;
    private double peso;
    private double tamañoAlas;

    public Ave(String nombre, double peso, double tamañoAlas) {
        this.nombre = nombre;
        this.peso = peso;
        this.tamañoAlas = tamañoAlas;
    }

    public double getPeso() {
        return peso;
    }

    public double getTamañoAlas() {
        return tamañoAlas;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
     @Override
    public String accion() {
        return nombre + " está volando.";  // Acción específica de aves
    }

    @Override
    public String toString() {
        return "Ave [nombre=" + nombre + ", peso=" + peso + ", tamañoAlas=" + tamañoAlas + "]";
    }
}

