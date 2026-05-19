public class Persona {
    // ATRIBUTOS
    // Se declaran como 'protected' para que las subclases (como Estudiante) 
    // puedan acceder a ellos directamente.
    protected String id;
    protected String nombre;
    protected String email;

    // CONSTRUCTOR
    public Persona(String id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    // MÉTODOS GETTERS
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    // MÉTODOS SETTERS
    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    // MÉTODO GENÉRICO PARA MOSTRAR INFORMACIÓN
    // Este método está pensado para ser sobrescrito (@Override) en las subclases
    public void mostrarInformacion() {
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Email: " + email);
    }
}