import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class ConsultaTasaDeCambio {
    private final String apiKey = "44af044fffe9869c5dc9dd74"; // Reemplaza con tu API key
    private final String urlApi = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/USD";

    // Método para realizar la consulta a la API de tasas de cambio
    public String obtenerTasaDeCambio(String urlApi) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(this.urlApi))
                .build();


    }
}
