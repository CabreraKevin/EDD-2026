public class Facultad {
    
    private String nombre;
    private String decano;

    // CONSTRUCTOR
    public Facultad(String nombre, String decano) {
        this.nombre = nombre;
        this.decano = decano;
    }

    // MOSTRAR INFORMACION
    public void mostrarFacultad() {
        System.out.println("Facultad: " + nombre + " | Decano: " + decano);
    }

    // GETTERS Y SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDecano() {
        return decano;
    }

    public void setDecano(String decano) {
        this.decano = decano;
    }
}