/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.animal;


public class Pez implements Animal {
    private String nombre;
    private double longitud;

    public Pez(String nombre, double longitud) {
        this.nombre = nombre;
        this.longitud = longitud;
    }

    public double getLongitud() {
        return longitud;
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
        return nombre + " está nadando.";  // Acción específica de peces
    }


    @Override
    public String toString() {
        return "Pez [nombre=" + nombre + ", longitud=" + longitud + "]";
    }
}


