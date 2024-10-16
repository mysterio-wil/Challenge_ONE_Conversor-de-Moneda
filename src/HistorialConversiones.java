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
}
