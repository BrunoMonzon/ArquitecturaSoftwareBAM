/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.animal;

public class FabricaPez implements FabricaAbstracta {

    @Override
    public Animal crearAnimal(String tipo) {
        switch (tipo.toLowerCase()) {
            case "pacu":
                return new Pez("Pacu", 0.5);
            case "sabalo":
                return new Pez("Sábalo", 1.0);
            default:
                System.out.println("Tipo de pez no válido");
                return null;
        }
    }
}


