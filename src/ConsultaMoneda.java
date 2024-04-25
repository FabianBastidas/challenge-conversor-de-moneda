import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class ConsultaMoneda {

    private ArrayList<Historial> listaDeConversiones = new ArrayList<>();

    public Conversor consultaApi(String monedaBase, String monedaAConvertir, double valor) {


        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/20e053085e8ef3d084dfa199/pair/"+monedaBase + "/"+monedaAConvertir+"/"+valor);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try{
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), Conversor.class);

        }catch (Exception e){
            throw new RuntimeException("No se pudo realizar la conversion");
        }

    }

    public void historialDeConversiones(Historial conversion){
        this.listaDeConversiones.add(conversion);

    }

    public ArrayList<Historial> getListaDeConversiones() {
        return listaDeConversiones;
    }
}
