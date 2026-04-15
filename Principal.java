import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Puerto puerto = new Puerto();
        int opcion;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Registrar Contenedor");
            System.out.println("2. Ver Peso Total");
            System.out.println("3. Ver Patio");
            System.out.println("4. Procesar Inspección");
            System.out.println("5. Ver Buque");
            System.out.println("6. Eliminar de Buque");
            System.out.println("7. Salir");

            System.out.print("Opción: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    sc.nextLine();

                    System.out.print("ID: ");
                    String id = sc.nextLine();

                    System.out.print("Peso (en toneladas): ");
                    double peso = sc.nextDouble();

                    System.out.print("Prioridad (1 normal / 2 alta): ");
                    int prioridad = sc.nextInt();

                    Contenedor c = new Contenedor(id, peso, prioridad);
                    puerto.registrarContenedor(c);
                    break;

                case 2:
                    System.out.println("Peso total: " + puerto.pesoTotal() + " ton");
                    break;

                case 3:
                    puerto.mostrarPatio();
                    break;

                case 4:
                    puerto.procesarInspeccion();
                    break;

                case 5:
                    puerto.mostrarBuque();
                    break;

                case 6:
                    sc.nextLine();
                    System.out.print("ID a eliminar: ");
                    String idEliminar = sc.nextLine();
                    puerto.eliminarDeBuque(idEliminar);
                    break;

                case 7:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 7);

        sc.close();
    }
}