import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Reproduccion reproduccion = new Reproduccion();
        int opcion;

        do {
            // Mostrar la canción actual
            System.out.println(reproduccion.mostrarCancionActual());
            
            // Mostrar el menú de opciones
            opcion = menu(scanner);
            switch (opcion) {
                case 1:
                    // Cambiar de canción
                    reproduccion.cambiarCancion();
                    break;
                case 2:
                    System.out.println("Cambiando de modo...");
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 3);
        
        scanner.close(); // Cerrar el scanner
    }

    // Método para mostrar el menú
    public static int menu(Scanner scanner) {
        System.out.println("\nOpciones:");
        System.out.println("1. Cambiar canción");
        System.out.println("2. Cambiar modo");
        System.out.println("3. Salir");
        System.out.print("Ingrese una opción: ");
        return obtenerNumeroValido(scanner);
    }

    // Método para obtener un número válido
    public static int obtenerNumeroValido(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, ingrese un número válido.");
            scanner.next();  // Descartar la entrada inválida
        }
        int numero = scanner.nextInt();
        scanner.nextLine();  // Descartar el salto de línea sobrante
        return numero;
    }
}
