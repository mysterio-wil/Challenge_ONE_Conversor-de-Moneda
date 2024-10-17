# Conversor de Moneda

## Versión 1.0

## Descripción General
Esta aplicación permite a los usuarios convertir montos de una moneda a otra utilizando tasas de cambio en tiempo real obtenidas de la API de ExchangeRate. Las tasas se basan en el Dólar estadounidense (USD) y permiten la conversión entre varias monedas, como Peso argentino (ARS), Real brasileño (BRL), y Sol peruano (PEN).

---

## Clases y Funcionalidades

### 1. `ConsultaTasaDeCambio`

Esta clase se encarga de interactuar con la API de ExchangeRate para obtener las tasas de cambio más recientes.

#### Atributos:

- **`apiKey`**: Es la clave de API necesaria para autenticar las solicitudes a la API de tasas de cambio.
- **`urlApi`**: Es la URL de la API que se utiliza para obtener las tasas de cambio basadas en el dólar estadounidense.
- Puedes obtener la **`apiKey`** y la **`urlApi`** [ExchangeRate-API](https://www.exchangerate-api.com/)

#### Métodos:

- **`obtenerTasaDeCambio(String urlApi)`**:
    - Realiza una solicitud HTTP a la API para obtener las tasas de cambio en formato JSON.
    - Retorna el cuerpo de la respuesta como una cadena de texto en formato JSON.
    - En caso de error, lanza una `RuntimeException`.

- **`getUrlApi()`**:
    - Devuelve la URL de la API que se utiliza para realizar las consultas de tasas de cambio.

#### Ejemplo de Uso:
```java
ConsultaTasaDeCambio consulta = new ConsultaTasaDeCambio();
String json = consulta.obtenerTasaDeCambio(consulta.getUrlApi());
```
### 2. `ConversorDeMoneda`
Esta clase se encarga de convertir montos de una moneda a otra utilizando las tasas de cambio obtenidas de la clase `ConsultaTasaDeCambio`.

#### Atributos:
- **`consultaTasaDeCambio`**: Instancia de la clase `ConsultaTasaDeCambio` que se utiliza para obtener las tasas de cambio desde la API.

#### Métodos:
- **`convertir(String monedaOrigen, String monedaDestino, double monto)`**:
    - Toma como parámetros el código de la moneda de origen, el código de la moneda de destino y el monto a convertir.
    - Realiza la conversión utilizando las tasas de cambio de la API.
    - Devuelve el monto convertido en la moneda de destino.

#### Proceso Interno:
1. Realiza una solicitud a la API para obtener las tasas de cambio en formato JSON.
2. Extrae las tasas de las monedas especificadas.
3. Calcula el monto convertido dividiendo el monto original entre la tasa de la moneda de origen y multiplicándolo por la tasa de la moneda de destino.

#### Ejemplo de Uso:
```java
ConversorDeMoneda conversor = new ConversorDeMoneda();
double resultado = conversor.convertir("USD", "ARS", 100);
System.out.println("100 USD son " + resultado + " ARS");
```
### 3. `HistorialConversiones`

La clase `HistorialConversiones` gestiona un historial de conversiones realizadas, permitiendo agregar entradas y mostrarlas en un formato tabular.

### Código de la Clase

```java
import java.util.ArrayList;
import java.util.List;

public class HistorialConversiones {
  private List<String> historial;

  public HistorialConversiones() {
    historial = new ArrayList<>();
  }

  // Agregar una entrada al historial
  public void agregarConversion(String monedaOrigen, String monedaDestino, double montoOrigen, double montoDestino) {
    String timestamp = java.time.LocalDateTime.now().toString();
    String entrada = String.format("%s: %f %s => %f %s", timestamp, montoOrigen, monedaOrigen, montoDestino, monedaDestino);
    historial.add(entrada);
  }

  // Mostrar el historial de conversiones
  public void mostrarHistorial() {
    System.out.println("Historial de Conversiones:");
    System.out.printf("%-25s %-20s %-20s %-20s%n", "Fecha y Hora", "Monto Origen", "Moneda Origen", "Moneda Destino");
    System.out.println("---------------------------------------------------------------------------");
    for (String entrada : historial) {
      String[] partes = entrada.split(": ");
      String timestamp = partes[0];
      String[] conversion = partes[1].split(" => ");
      String[] montoOrigen = conversion[0].trim().split(" ");
      String[] montoDestino = conversion[1].trim().split(" ");
      System.out.printf("%-25s %-20s %-20s %-20s%n", timestamp, montoOrigen[0], montoOrigen[1], montoDestino[1]);
    }
  }
}
```

### 4. `Principal`
Esta clase contiene el método `main`, que gestiona la interacción con el usuario y proporciona un menú para seleccionar las conversiones de moneda.

#### Funcionalidad:
Muestra un menú con opciones de conversión de moneda, tales como:
- Dólar a Peso argentino.
- Peso argentino a Dólar.
- Dólar a Real brasileño.
- Real brasileño a Dólar.
- Dólar a Sol peruano.
- Sol peruano a Dólar.

Dependiendo de la opción seleccionada por el usuario, solicita un monto para convertir y llama al método `convertir` de la clase `ConversorDeMoneda`.

El ciclo continúa hasta que el usuario seleccione la opción de salir.

#### Ejemplo de Flujo:
1. El usuario selecciona "1" para convertir de Dólar a Peso argentino.
2. El programa solicita un monto (por ejemplo, 100 USD).
3. El programa realiza la conversión y muestra el resultado.

#### Ejemplo de Código:
```java
public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConversorDeMoneda conversor = new ConversorDeMoneda();

        int opcion;
        do {
            // Menú de opciones
            System.out.println("1) Dólar => Peso argentino");
            System.out.println("2) Peso argentino => Dólar");
            System.out.println("3) Dólar => Real brasileño");
            System.out.println("4) Real brasileño => Dólar");
            System.out.println("5) Dólar => Sol peruano");
            System.out.println("6) Sol peruano => Dólar");
            System.out.println("7) Mostrar historial de conversiones");
            System.out.println("8) Salir");
             System.out.println("Elija una opción válida: ");
            System.out.println("*****************************************************");
            System.out.printl(">>> ");
            opcion = scanner.nextInt();

            double monto;
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el monto en Dólares: ");
                    monto = scanner.nextDouble();
                    double pesos = conversor.convertir("USD", "ARS", monto);
                    System.out.println(monto + " USD son " + pesos + " ARS");
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 7);
        scanner.close();
    }
}
```
## Características
- Conversión entre múltiples monedas.
- Historial de conversiones.
- Soporte para tasas de cambio actualizadas.

## Requisitos
- JDK 11 o superior.
- Conexión a Internet para acceder a la API de tasas de cambio.

## Instalación
1. Clonar el repositorio:
   ```bash
   git clone git@github.com:mysterio-wil/Challenge_ONE_Conversor-de-Moneda.git
   ```
 ## Compilación

Para compilar el proyecto, utiliza el siguiente comando:

```bash
javac -cp ".;lib/gson.jar" -d out src/*.java
```
## Ejecución

Para ejecutar la aplicación, utiliza el siguiente comando:

```bash
java -cp "out;lib/gson.jar" Principal
```
## Ejemplos

- Convertir 100 USD a ARS.
- Ver historial de conversiones.

## Estructura del Proyecto

- `ConsultaTasaDeCambio.java`: Maneja las solicitudes a la API.
- `ConversorDeMoneda.java`: Realiza las conversiones de moneda.
- `Principal.java`: Interfaz de usuario en consola.

## Contribuciones

Las contribuciones son bienvenidas. Por favor, abre un issue o envía un pull request.

## Licencia

Este proyecto está bajo la Licencia MIT.

## Contacto

Desarrollado por: [mysterio-wil](https://github.com/mysterio-wil)

## Créditos

API de [ExchangeRate-API](https://exchangerate-api.com)