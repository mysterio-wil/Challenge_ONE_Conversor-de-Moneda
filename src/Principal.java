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
        } while (opcion != 7); // Continúa hasta que el usuario elija salir
    }
}
