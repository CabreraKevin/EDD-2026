public class GrafoCampus {

    // ATRIBUTOS
    private String[] edificios;

    // MATRIZ DE ADYACENCIA
    private int[][] distancias;

    private int cantidadEdificios;

    // CONSTRUCTOR
    public GrafoCampus(
            int cantidadEdificios
    ) {

        this.cantidadEdificios =
                cantidadEdificios;

        edificios =
                new String[cantidadEdificios];

        distancias =
                new int[cantidadEdificios]
                        [cantidadEdificios];

        // INICIALIZAR MATRIZ
        for (int i = 0;
             i < cantidadEdificios;
             i++) {

            for (int j = 0;
                 j < cantidadEdificios;
                 j++) {

                if (i == j) {

                    distancias[i][j] = 0;

                } else {

                    distancias[i][j] =
                            Integer.MAX_VALUE;
                }
            }
        }
    }

    // AGREGAR EDIFICIO
    public void agregarEdificio(
            int indice,
            String nombre
    ) {

        edificios[indice] = nombre;
    }

    // AGREGAR CONEXION
    public void agregarConexion(
            int origen,
            int destino,
            int distancia
    ) {

        // GRAFO NO DIRIGIDO
        distancias[origen][destino] =
                distancia;

        distancias[destino][origen] =
                distancia;
    }

    // ALGORITMO DE DIJKSTRA
    public void dijkstra(
            int origen,
            int destino
    ) {

        int[] distanciaMinima =
                new int[cantidadEdificios];

        boolean[] visitado =
                new boolean[cantidadEdificios];

        int[] anterior =
                new int[cantidadEdificios];

        // INICIALIZAR
        for (int i = 0;
             i < cantidadEdificios;
             i++) {

            distanciaMinima[i] =
                    Integer.MAX_VALUE;

            visitado[i] = false;

            anterior[i] = -1;
        }

        distanciaMinima[origen] = 0;

        // RECORRIDO
        for (int i = 0;
             i < cantidadEdificios - 1;
             i++) {

            int nodoActual =
                    obtenerMinimo(
                            distanciaMinima,
                            visitado
                    );

            visitado[nodoActual] =
                    true;

            for (int j = 0;
                 j < cantidadEdificios;
                 j++) {

                if (!visitado[j]
                        &&
                        distancias[nodoActual][j]
                                != Integer.MAX_VALUE
                        &&
                        distanciaMinima[nodoActual]
                                != Integer.MAX_VALUE
                        &&
                        distanciaMinima[nodoActual]
                                + distancias[nodoActual][j]
                                < distanciaMinima[j]) {

                    distanciaMinima[j] =
                            distanciaMinima[nodoActual]
                                    +
                                    distancias[nodoActual][j];

                    anterior[j] =
                            nodoActual;
                }
            }
        }

        // MOSTRAR RESULTADO
        System.out.println(
                "\n=== RUTA MAS CORTA ==="
        );

        mostrarRuta(
                anterior,
                destino
        );

        System.out.println(
                "\nDistancia total: "
                + distanciaMinima[destino]
                + " metros"
        );
    }

    // OBTENER DISTANCIA MINIMA
    private int obtenerMinimo(
            int[] distancia,
            boolean[] visitado
    ) {

        int minimo =
                Integer.MAX_VALUE;

        int indiceMinimo = -1;

        for (int i = 0;
             i < cantidadEdificios;
             i++) {

            if (!visitado[i]
                    &&
                    distancia[i] < minimo) {

                minimo = distancia[i];

                indiceMinimo = i;
            }
        }

        return indiceMinimo;
    }

    // MOSTRAR RUTA
    private void mostrarRuta(
            int[] anterior,
            int actual
    ) {

        if (actual == -1) {

            return;
        }

        mostrarRuta(
                anterior,
                anterior[actual]
        );

        System.out.print(
                edificios[actual]
                + " -> "
        );
    }

    // MOSTRAR EDIFICIOS
    public void mostrarEdificios() {

        System.out.println(
                "\n=== EDIFICIOS ==="
        );

        for (int i = 0;
             i < edificios.length;
             i++) {

            System.out.println(
                    i + ": "
                    + edificios[i]
            );
        }
    }
}