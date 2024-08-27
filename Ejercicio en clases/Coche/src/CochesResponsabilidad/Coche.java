package cochesresponsabilidad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Coche {
    private String marca;
    private int modelo;
    private String placa;
    private String color;
    private int cilindrada;

    // Constructor
    public Coche(String marca, int modelo, String placa, String color, int cilindrada) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.color = color;
        this.cilindrada = cilindrada;
    }

    public void GuardarBd() {
        String url = "jdbc:mysql://localhost:3306/bd_coches"; // Cambia la URL si es necesario
        String user = "root"; // Cambia el usuario si es necesario
        String password = ""; // Cambia la contraseña si es necesario

        try (Connection conexion = DriverManager.getConnection(url, user, password)) {
            String sql = "INSERT INTO coches (marca, modelo, placa, color, cilindrada) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement instruccion = conexion.prepareStatement(sql)) {
                instruccion.setString(1, marca);
                instruccion.setInt(2, modelo);
                instruccion.setString(3, placa);
                instruccion.setString(4, color);
                instruccion.setInt(5, cilindrada);
                instruccion.executeUpdate();
                System.out.println("Coche guardado exitosamente.");
            }
        } catch (SQLException ex) {
            System.out.println("Error al guardar el coche: " + ex.getMessage());
        }
    }

    // Getters y setters (opcional)
    // ...
}
