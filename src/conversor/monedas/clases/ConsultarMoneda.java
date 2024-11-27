package conversor.monedas.clases;
import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarMoneda {
    // URL base y clave API como constantes
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/";
    private static final String API_KEY = "9e9afa7d7e141d63a98ad88c";

    public Coin buscarCoin(String usuarioMoneda){

        URI direccion = URI.create(API_URL + API_KEY + "/latest/" + usuarioMoneda);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            // Enviar la solicitud y obtener la respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            // Convertir el JSON en un objeto Coin
            return new Gson().fromJson(response.body(), Coin.class);
        } catch (Exception e) {
            // Manejo de errores
            throw new RuntimeException("No encontro la moneda revisar la documentacion https://en.wikipedia.org/wiki/ISO_4217");
        }

    }

}
