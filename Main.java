import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HardwareRadio hardwareRadio = new HardwareRadio();
        Telefono telefono = new Telefono(hardwareRadio);
        Reproduccion reproduccion = new Reproduccion();
        Productividad productividad = new Productividad();
        Radio radio = new Radio();

        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 5) {
            System.out.println("""
            \n======= MENU PRINCIPAL ========
            (1) Encender/Apagar radio
            (2) Cambiar volumen
            (3) Cambiar modo
            (4) Mostrar estado de la radio
            (5) Salir
            =================================""");
            System.out.print(">>> ");
            opcion = scanner.nextInt();

            if (opcion == 1) {
                System.out.print("¿Encender (1) / Apagar (0)?");
                int estado = scanner.nextInt();
                hardwareRadio.encenderApagar(estado == 1);
                System.out.println(estado == 1 ? "Radio encendida" : "Radio apagada");
            }

            if (opcion == 2) {
                System.out.print("Volumen (0-100): ");
                int nuevoVolumen = scanner.nextInt();
                hardwareRadio.cambiarVolumen(nuevoVolumen);
                System.out.println("Volumen ajustado a: " + hardwareRadio.getVolumen());
            }

            if (opcion == 3) {
                if (!hardwareRadio.isEncendido()) {
                    System.out.println("La radio está apagada.");
                    continue;
                }

                System.out.println("""
                ++++++++++ MODOS ++++++++++
                (1) Teléfono
                (2) Reproducción
                (3) Productividad
                (4) Radio""");
                System.out.print(">>> ");
                int modoSeleccionado = scanner.nextInt();

                if (modoSeleccionado == 1) {
                    hardwareRadio.modo(telefono);
                    System.out.println("Modo Teléfono activado");
                    subMenuTelefono(scanner, telefono);
                }

                if (modoSeleccionado == 2) {
                    hardwareRadio.modo(reproduccion);
                    System.out.println("Modo Reproducción activado");
                    subMenuReproduccion(scanner, reproduccion);
                }

                if (modoSeleccionado == 3) {
                    hardwareRadio.modo(productividad);
                    System.out.println("Modo Productividad activado");
                    subMenuProductividad(scanner, productividad);
                }

                if (modoSeleccionado == 4) {
                    hardwareRadio.modo(radio);
                    System.out.println("Modo Radio activado");
                    subMenuRadio(scanner, radio);
                }
            }

            if (opcion == 4) {
                System.out.println(String.format("""
                \n------------ Estado de la Radio ------------
                Estado: %
                Volumen: %
                Modo actual: %
                """,
                (hardwareRadio.isEncendido() ? "Encendida" : "Apagada"),
                hardwareRadio.getVolumen(),
                (hardwareRadio.getModoActual() != null ? hardwareRadio.getModoActual().getNombre() : "Ninguno")
                ));
            }
        }

        System.out.println("Saliendo...");
        scanner.close();
    }

    private static void subMenuTelefono(Scanner scanner, Telefono telefono) {
        int opcion;
        do {
            System.out.println("""
                \n~~~~~~~~~~~~~~~~ Teléfono ~~~~~~~~~~~~~~~~
                (1) Conectar/Desconectar
                (2) Mostrar contactos
                (3) Agregar contacto
                (4) Regresar al menú principal""");
            System.out.print(">>> ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 1) {
                System.out.println(telefono.conectarDesconectar());
            }
            if (opcion == 2) {
                System.out.println(telefono.mostrarContactos());
            }
            if (opcion == 3) {
                System.out.print("Nombre del contacto: ");
                String nombre = scanner.nextLine();
                System.out.print("Número de teléfono: ");
                String numero = scanner.nextLine();
                telefono.agregarContacto(new Contacto(nombre, numero));
                System.out.println("Contacto agregado.");
            }
        } while (opcion != 4);
    }

    private static void subMenuReproduccion(Scanner scanner, Reproduccion reproduccion) {
        int opcion;
        do {
            System.out.println("""
                \n~~~~~~~~~~~~~~~~ Reproducción ~~~~~~~~~~~~~~~~
                (1) Mostrar canción actual
                (2) Cambiar canción
                (3) Regresar al menú principal""");
            System.out.print(">>> ");
            opcion = scanner.nextInt();

            if (opcion == 1) {
                System.out.println(reproduccion.mostrarCancionActual());
            }
            if (opcion == 2) {
                System.out.println(reproduccion.cambiarCancion());
            }
        } while (opcion != 3);
    }

    private static void subMenuProductividad(Scanner scanner, Productividad productividad) {
        int opcion;
        do {
            System.out.println("""
                \n~~~~~~~~~~~~~~~~ Productividad ~~~~~~~~~~~~~~~~
                (1) Obtener pronóstico del clima
                (2) Regresar al menú principal""");
            System.out.print(">>> ");
            opcion = scanner.nextInt();

            if (opcion == 1) {
                System.out.println(productividad.obtenerPronostico());
            }
        } while (opcion != 2);
    }

    private static void subMenuRadio(Scanner scanner, Radio radio) {
        int opcion;
        do {
            System.out.println("""
                \n~~~~~~~~~~~~~~~~ Radio ~~~~~~~~~~~~~~~~
                (1) Cambiar emisora
                (2) Guardar emisora
                (3) Cargar emisora
                (4) Regresar al menú principal""");
            System.out.print(">>> ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 1) {
                System.out.print("Cambiar frecuencia (1 subir / -1 bajar): ");
                int cambio = scanner.nextInt();
                radio.cambiarEmisora(cambio);
                System.out.println("Frecuencia actual: " + radio.getFrecuencia());
            }
            if (opcion == 2) {
                System.out.print("Nombre de la emisora: ");
                String nombre = scanner.nextLine();
                System.out.print("Frecuencia: ");
                double frecuencia = scanner.nextDouble();
                radio.guardarEmisora(nombre, frecuencia);
                System.out.println("Emisora guardada.");
            }
            if (opcion == 3) {
                System.out.print("Frecuencia a cargar: ");
                double frecuencia = scanner.nextDouble();
                radio.cargarEmisora(frecuencia);
                System.out.println("Frecuencia actual: " + radio.getFrecuencia());
            }
        } while (opcion != 4);
    }
}