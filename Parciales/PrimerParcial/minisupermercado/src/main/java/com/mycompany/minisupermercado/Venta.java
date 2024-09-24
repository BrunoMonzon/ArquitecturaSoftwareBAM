/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.minisupermercado;

/**
 *
 * @author Bruno
 */
public class Venta {
    int id;
    Cliente cliente;
    Producto producto;
    int cantidad;
    double total;

    public Venta(int id, Cliente cliente, Producto producto, int cantidad) {
        this.id = id;
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
        this.total = producto.precio * cantidad;
    }
}
