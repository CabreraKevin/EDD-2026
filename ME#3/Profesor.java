public class Profesor extends Persona {

    // ATRIBUTOS
    private String especialidad;

    private double salario;

    private String facultad;

    // CONSTRUCTOR
    public Profesor(
            String id,
            String nombre,
            String email,
            String especialidad,
            double salario,
            String facultad
    ) {

        // CONSTRUCTOR DE LA CLASE ESTUDIANTE
        super(id, nombre, email);

        this.especialidad = especialidad;

        this.salario = salario;

        this.facultad = facultad;
    }

    // IMPLEMENTACION DEL METODO ABSTRACTO
    @Override
    public void mostrarInformacion() {

        System.out.println(
                "\n=== INFORMACION DEL PROFESOR ==="
        );

        System.out.println(
                "ID: " + id
        );

        System.out.println(
                "Nombre: " + nombre
        );

        System.out.println(
                "Email: " + email
        );

        System.out.println(
                "Especialidad: "
                + especialidad
        );

        System.out.println(
                "Salario: "
                + salario
        );

        System.out.println(
                "Facultad: "
                + facultad
        );
    }

    // GETTERS Y SETTERS

    public String getEspecialidad() {

        return especialidad;
    }

    public void setEspecialidad(
            String especialidad
    ) {

        this.especialidad =
                especialidad;
    }

    public double getSalario() {

        return salario;
    }

    public void setSalario(
            double salario
    ) {

        this.salario = salario;
    }

    public String getFacultad() {

        return facultad;
    }

    public void setFacultad(
            String facultad
    ) {

        this.facultad = facultad;
    }
}