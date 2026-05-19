import java.util.Stack;

public class SistemaDeshacer {

    // PILAS OBLIGATORIAS
    private Stack<Operacion> pilaDeshacer;

    private Stack<Operacion> pilaRehacer;

    // CONSTRUCTOR
    public SistemaDeshacer() {

        pilaDeshacer = new Stack<>();

        pilaRehacer = new Stack<>();
    }

    // AGREGAR OPERACION
    public void agregarOperacion(
            Operacion operacion
    ) {

        pilaDeshacer.push(operacion);

        // LIMPIAR REHACER
        // CUANDO HAY NUEVA OPERACION
        pilaRehacer.clear();

        System.out.println(
                "Operacion guardada."
        );
    }

    // DESHACER
    public void deshacer() {

        if (pilaDeshacer.isEmpty()) {

            System.out.println(
                    "No hay operaciones para deshacer."
            );

            return;
        }

        Operacion operacion =
                pilaDeshacer.pop();

        pilaRehacer.push(operacion);

        System.out.println(
                "\nDESHACIENDO OPERACION..."
        );

        operacion.mostrarOperacion();
    }

    // REHACER
    public void rehacer() {

        if (pilaRehacer.isEmpty()) {

            System.out.println(
                    "No hay operaciones para rehacer."
            );

            return;
        }

        Operacion operacion =
                pilaRehacer.pop();

        pilaDeshacer.push(operacion);

        System.out.println(
                "\nREHACIENDO OPERACION..."
        );

        operacion.mostrarOperacion();
    }

    // MOSTRAR PILA DESHACER
    public void mostrarPilaDeshacer() {

        System.out.println(
                "\nPILA DESHACER:"
        );

        for (Operacion operacion
                : pilaDeshacer) {

            operacion.mostrarOperacion();
        }
    }

    // MOSTRAR PILA REHACER
    public void mostrarPilaRehacer() {

        System.out.println(
                "\nPILA REHACER:"
        );

        for (Operacion operacion
                : pilaRehacer) {

            operacion.mostrarOperacion();
        }
    }

    // GETTERS

    public Stack<Operacion>
    getPilaDeshacer() {

        return pilaDeshacer;
    }

    public Stack<Operacion>
    getPilaRehacer() {

        return pilaRehacer;
    }
}