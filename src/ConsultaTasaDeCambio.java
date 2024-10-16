import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaTasaDeCambio {
    private final String apiKey = "44af044fffe9869c5dc9dd74"; // Reemplaza con tu API key
    private final String urlApi = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/USD";

    // Método para realizar la consulta a la API de tasas de cambio
    public String obtenerTasaDeCambio(String urlApi) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(this.urlApi))
                .build();

        try {
            // Enviar solicitud y obtener la respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new IOException("Error en la respuesta de la API. Código de estado: " + response.statusCode());
            }

            return response.body();  // Devolver el cuerpo de la respuesta en formato JSON
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error al consultar la API de tasas de cambio: " + e.getMessage(), e);
        }
    }
}
