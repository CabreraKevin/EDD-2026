public class Parcial extends Evaluacion {

    // ATRIBUTO ESPECIFICO
    private String temasEvaluados;

    // CONSTRUCTOR
    public Parcial(
            String nombre,
            double nota,
            double porcentaje,
            String temasEvaluados
    ) {

        // CONSTRUCTOR DE LA CLASE PADRE
        super(nombre, nota, porcentaje);

        this.temasEvaluados =
                temasEvaluados;
    }

    // IMPLEMENTACION DEL METODO ABSTRACTO
    @Override
    public void mostrarInformacion() {

        System.out.println(
                "\n=== INFORMACION DEL PARCIAL ==="
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
                "Temas evaluados: "
                + temasEvaluados
        );
    }

    // GETTERS Y SETTERS

    public String getTemasEvaluados() {

        return temasEvaluados;
    }

    public void setTemasEvaluados(
            String temasEvaluados
    ) {

        this.temasEvaluados =
                temasEvaluados;
    }
}