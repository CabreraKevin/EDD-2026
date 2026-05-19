public class ExamenFinal extends Evaluacion {

    // ATRIBUTO ESPECIFICO
    private int duracion;

    // CONSTRUCTOR
    public ExamenFinal(
            String nombre,
            double nota,
            double porcentaje,
            int duracion
    ) {

        // CONSTRUCTOR DE LA CLASE PADRE
        super(nombre, nota, porcentaje);

        this.duracion = duracion;
    }

    // IMPLEMENTACION DEL METODO ABSTRACTO
    @Override
    public void mostrarInformacion() {

        System.out.println(
                "\n=== INFORMACION DEL EXAMEN FINAL ==="
        );

        System.out.println(
                "Nombre: " + nombre
        );

        System.out.println(
                "Nota: " + nota
        );

        System.out.println(
                "Porcentaje: "
                + porcentaje + "%"
        );

        System.out.println(
                "Duracion: "
                + duracion + " minutos"
        );
    }

    // GETTERS Y SETTERS

    public int getDuracion() {

        return duracion;
    }

    public void setDuracion(
            int duracion
    ) {

        this.duracion = duracion;
    }
}