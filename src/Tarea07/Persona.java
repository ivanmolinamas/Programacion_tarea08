package Tarea07;

/**
 *
 * @author ivanm
 */
public class Persona implements Imprimible {
       
    private String nombre;
    private String apellidos;
    private String DNI;
    /**
     * @param nombre = Nombre de la persona titular
     * @param apellidos = Apellidos de la persona titular
     * @param DNI = DNI de la persona titular.
    */
    public Persona(String nombre, String apellidos, String DNI) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    @Override
    public String devolverInfoString() {
        return "Persona{" + "nombre= " + nombre + ", apellidos= " + apellidos + ", DNI= " + DNI + '}';
    }  
}
