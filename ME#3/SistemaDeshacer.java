import java.util.Stack;

public class SistemaDeshacer {

    private Stack<Operacion> pilaDeshacer;
    private Stack<Operacion> pilaRehacer;

    public SistemaDeshacer() {
        pilaDeshacer = new Stack<>();
        pilaRehacer = new Stack<>();
    }

    public void agregarOperacion(Operacion operacion) {
        pilaDeshacer.push(operacion);
        pilaRehacer.clear();
        System.out.println("Operacion guardada.");
    }

    // METODÓ: Lanza excepción si la pila está vacía
    public void deshacer() throws PilaDeshacerVaciaException {
        if (pilaDeshacer.isEmpty()) {
            throw new PilaDeshacerVaciaException("No hay operaciones para deshacer.");
        }

        Operacion operacion = pilaDeshacer.pop();
        pilaRehacer.push(operacion);

        System.out.println("\nDESHACIENDO OPERACION...");
        operacion.mostrarOperacion();
    }

    //METODÓ: Lanza excepción si la pila está vacía
    public void rehacer() throws PilaDeshacerVaciaException {
        if (pilaRehacer.isEmpty()) {
            throw new PilaDeshacerVaciaException("No hay operaciones para rehacer.");
        }

        Operacion operacion = pilaRehacer.pop();
        pilaDeshacer.push(operacion);

        System.out.println("\nREHACIENDO OPERACION...");
        operacion.mostrarOperacion();
    }

    public void mostrarPilaDeshacer() {
        System.out.println("\nPILA DESHACER:");
        for (Operacion operacion : pilaDeshacer) {
            operacion.mostrarOperacion();
        }
    }

    public void mostrarPilaRehacer() {
        System.out.println("\nPILA REHACER:");
        for (Operacion operacion : pilaRehacer) {
            operacion.mostrarOperacion();
        }
    }

    public Stack<Operacion> getPilaDeshacer() { return pilaDeshacer; }
    public Stack<Operacion> getPilaRehacer() { return pilaRehacer; }
}