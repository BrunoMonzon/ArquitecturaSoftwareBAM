/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.animal;

public class FabricaMamifero implements FabricaAbstracta {

    @Override
    public Animal crearAnimal(String tipo) {
        switch (tipo.toLowerCase()) {
            case "leon":
                return new Mamifero("Leon", 37.5, 4, "Amarillo");
            case "oso":
                return new Mamifero("Oso", 36.5, 4, "Marrón");
            case "mono":
                return new Mamifero("Mono", 37.0, 2, "Negro");
            default:
                System.out.println("Tipo de mamífero no válido");
                return null;
        }
    }
}

