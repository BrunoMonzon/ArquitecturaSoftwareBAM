import java.util.HashSet;
import java.util.Set;

//CONTEXTO
class Usuario {
    private Set<String> roles = new HashSet<>();
    private Set<String> permisos = new HashSet<>();

    public void agregarRol(String rol) {
        roles.add(rol);
    }

    public void agregarPermiso(String permiso) {
        permisos.add(permiso);
    }

    public boolean tieneRol(String rol) {
        return roles.contains(rol);
    }

    public boolean tienePermiso(String permiso) {
        return permisos.contains(permiso);
    }
}

interface Expresion {
    boolean interpretar(Usuario usuario);
}

// Expresión terminal para verificar roles de usuario
class ExpresionRol implements Expresion {
    private String rol;

    public ExpresionRol(String rol) {
        this.rol = rol;
    }

    @Override
    public boolean interpretar(Usuario usuario) {
        return usuario.tieneRol(rol);
    }
}

// Expresión terminal para verificar permisos de usuario
class ExpresionPermiso implements Expresion {
    private String permiso;

    public ExpresionPermiso(String permiso) {
        this.permiso = permiso;
    }

    @Override
    public boolean interpretar(Usuario usuario) {
        return usuario.tienePermiso(permiso);
    }
}

// Expresión no terminal para 'AND'
class ExpresionAnd implements Expresion {
    private Expresion expr1;
    private Expresion expr2;

    public ExpresionAnd(Expresion expr1, Expresion expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public boolean interpretar(Usuario usuario) {
        return expr1.interpretar(usuario) && expr2.interpretar(usuario);
    }
}

// Expresión no terminal para 'OR'
class ExpresionOr implements Expresion {
    private Expresion expr1;
    private Expresion expr2;

    public ExpresionOr(Expresion expr1, Expresion expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public boolean interpretar(Usuario usuario) {
        return expr1.interpretar(usuario) || expr2.interpretar(usuario);
    }
}

// Expresión no terminal para 'NOT'
class ExpresionNot implements Expresion {
    private Expresion expr;

    public ExpresionNot(Expresion expr) {
        this.expr = expr;
    }

    @Override
    public boolean interpretar(Usuario usuario) {
        return !expr.interpretar(usuario);
    }
}

public class PatronInterpreter2 {
    public static void main(String[] args) {
        // Creamos un usuario con ciertos roles y permisos
        Usuario usuario = new Usuario();
        usuario.agregarRol("admin");
        usuario.agregarPermiso("leer_informes");

        // Definimos las expresiones para evaluar
        Expresion esAdmin = new ExpresionRol("admin");
        Expresion puedeLeerInformes = new ExpresionPermiso("leer_informes");
        Expresion esGuest = new ExpresionRol("guest");
        Expresion puedeEditarUsuarios = new ExpresionPermiso("editar_usuarios");

        // Combinamos las expresiones usando operadores lógicos
        Expresion condicion1 = new ExpresionAnd(esAdmin, puedeLeerInformes); // "Es admin y puede leer informes"
        Expresion condicion2 = new ExpresionOr(new ExpresionNot(esGuest), puedeEditarUsuarios); // "No es guest o puede editar usuarios"

        // Evaluamos las expresiones
        System.out.println("¿Es admin y puede leer informes?: " + condicion1.interpretar(usuario)); // true
        System.out.println("¿No es guest o puede editar usuarios?: " + condicion2.interpretar(usuario)); // true
    }
}
