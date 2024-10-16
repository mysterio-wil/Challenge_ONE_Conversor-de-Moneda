import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ConversorDeMoneda {
    private ConsultaTasaDeCambio consultaTasaDeCambio;

    public ConversorDeMoneda() {
        consultaTasaDeCambio = new ConsultaTasaDeCambio();
    }
}
