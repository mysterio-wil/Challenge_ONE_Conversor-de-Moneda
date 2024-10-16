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
