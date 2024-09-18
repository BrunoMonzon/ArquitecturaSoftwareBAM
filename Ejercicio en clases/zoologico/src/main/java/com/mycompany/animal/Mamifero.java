/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.animal;

public class Mamifero implements Animal {
    private String nombre;
    private double temperatura;
    private int nroPatas;
    private String color;

    public Mamifero(String nombre, double temperatura, int nroPatas, String color) {
        this.nombre = nombre;
        this.temperatura = temperatura;
        this.nroPatas = nroPatas;
        this.color = color;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public int getNroPatas() {
        return nroPatas;
    }

    public String getColor() {
        return color;
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
        return nombre + " está caminando.";  // Acción específica de mamíferos
    }

    @Override
    public String toString() {
        return "Mamífero [nombre=" + nombre + ", temperatura=" + temperatura + ", nroPatas=" + nroPatas + ", color=" + color + "]";
    }
}
