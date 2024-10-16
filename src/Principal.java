import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConversorDeMoneda conversor = new ConversorDeMoneda();

        int opcion;

        do {
            // Mostrar el menú
            System.out.println("*****************************************************");
            System.out.println("¡Sea bienvenido/a al conversor de Moneda =]");
            System.out.println("");
            System.out.println("1) Dólar =>> Peso argentino");
            System.out.println("2) Peso argentino =>> Dólar");
            System.out.println("3) Dólar =>> Real brasileño");
            System.out.println("4) Real brasileño =>> Dólar");
            System.out.println("5) Dólar =>> Sol peruano");
            System.out.println("6) Sol peruano =>> Dólar");
            System.out.println("7) Salir");
            System.out.println("Elija una opción válida: ");
            System.out.println("*****************************************************");
            System.out.print(">>> ");
            opcion = scanner.nextInt();

            // Variable para almacenar el monto a convertir
            double monto;

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el monto en Dólares: ");
                    monto = scanner.nextDouble();
                    double pesosArgentinos = conversor.convertir("USD", "ARS", monto);
                    System.out.printf("%.2f Dólares son equivalentes a %.2f Pesos argentinos.%n", monto, pesosArgentinos);
                    break;
                case 2:
                    System.out.print("Ingrese el monto en Pesos argentinos: ");
                    monto = scanner.nextDouble();
                    double dolares = conversor.convertir("ARS", "USD", monto);
                    System.out.printf("%.2f Pesos argentinos son equivalentes a %.2f Dólares.%n", monto, dolares);
                    break;
                case 3:
                    System.out.print("Ingrese el monto en Dólares: ");
                    monto = scanner.nextDouble();
                    double reales = conversor.convertir("USD", "BRL", monto);
                    System.out.printf("%.2f Dólares son equivalentes a %.2f Reales brasileños.%n", monto, reales);
                    break;
                case 4:
                    System.out.print("Ingrese el monto en Reales brasileños: ");
                    monto = scanner.nextDouble();
                    double dolaresDeReales = conversor.convertir("BRL", "USD", monto);
                    System.out.printf("%.2f Reales brasileños son equivalentes a %.2f Dólares.%n", monto, dolaresDeReales);
                    break;
                case 5:
                    System.out.print("Ingrese el monto en Dólares: ");
                    monto = scanner.nextDouble();
                    double soles = conversor.convertir("USD", "PEN", monto);
                    System.out.printf("%.2f Dólares son equivalentes a %.2f Soles peruanos.%n", monto, soles);
                    break;
                case 6:
                    System.out.print("Ingrese el monto en Soles peruanos: ");
                    monto = scanner.nextDouble();
                    double dolaresDeSoles = conversor.convertir("PEN", "USD", monto);
                    System.out.printf("%.2f Soles peruanos son equivalentes a %.2f Dólares.%n", monto, dolaresDeSoles);
                    break;
                case 7:
                    System.out.println("Saliendo del conversor. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, elija una opción válida.");
            }
        } while (opcion != 7); // Continúa hasta que el usuario elija salir

        scanner.close(); // Cerrar el escáner

    }
}
