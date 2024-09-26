//package Tareas.Tarea2;

// La interfaz o clase abstracta "Expression"
interface Expresion {
    int interpretar();
}

// Expresión terminal que representa números
class Numero implements Expresion {
    private int numero;

    public Numero(int numero) {
        this.numero = numero;
    }

    public int interpretar() {
        return numero;
    }
}

// Expresión no terminal para sumar
class Sumar implements Expresion {
    private Expresion izquierda;
    private Expresion derecha;

    public Sumar(Expresion izquierda, Expresion derecha) {
        this.izquierda = izquierda;
        this.derecha = derecha;
    }

    public int interpretar() {
        return izquierda.interpretar() + derecha.interpretar();
    }
}

// Expresión no terminal para restar
class Restar implements Expresion {
    private Expresion izquierda;
    private Expresion derecha;

    public Restar(Expresion izquierda, Expresion derecha) {
        this.izquierda = izquierda;
        this.derecha = derecha;
    }

    public int interpretar() {
        return izquierda.interpretar() - derecha.interpretar();
    }
}

public class PatronInterpreter1 {
    public static void main(String[] args) {
        // Construimos la expresión 3 + 7 - 2
        Expresion tres = new Numero(3);
        Expresion siete = new Numero(7);
        Expresion dos = new Numero(2);

        // Sumar 3 y 7
        Expresion suma = new Sumar(tres, siete);

        // Restar 2 de la suma anterior
        Expresion resta = new Restar(suma, dos);

        // Interpretamos la expresión completa
        int resultado = resta.interpretar();
        System.out.println("Resultado: " + resultado);  // Resultado: 8
    }
}
