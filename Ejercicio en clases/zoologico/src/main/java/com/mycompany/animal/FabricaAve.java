/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.animal;

public class FabricaAve implements FabricaAbstracta {

    @Override
    public Animal crearAnimal(String tipo) {
        switch (tipo.toLowerCase()) {
            case "loro":
                return new Ave("Loro", 1.0, 0.5);
            case "aguila":
                return new Ave("Águila", 6.0, 2.0);
            case "condor":
                return new Ave("Cóndor", 12.0, 3.0);
            default:
                System.out.println("Tipo de ave no válido");
                return null;
        }
    }
}
