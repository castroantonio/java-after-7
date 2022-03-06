package novidades.java11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.concurrent.CompletableFuture;

public class HttpClientApi {

	public static void main(String[] args) throws Exception {
		final String URI_GOOGLE = "https://www.google.com/";
		
// Modo antigo.
		URL url = new URL(URI_GOOGLE);
		URLConnection urlConnection = url.openConnection();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

		StringBuffer pagina = new StringBuffer();
		
		String linha = bufferedReader.readLine();
		while (linha != null) {
			pagina.append(linha + System.lineSeparator());
			linha = bufferedReader.readLine();
		}
		
		System.out.println(pagina);
		
// Nova HTTP 2 / Client API
		HttpClient client = HttpClient.newHttpClient();
		
		HttpRequest request = HttpRequest.newBuilder(new URI(URI_GOOGLE)).GET().build();
		
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

		System.out.println("Versão do HTTP: " + response.version());
		System.out.println("Código da resposta: " + response.statusCode());
		System.out.println(response.body());
		
		

		// Fazendo requisições assíncronas:
		
		HttpClient httpClient = HttpClient.newHttpClient();
		
		HttpRequest httpRequest = HttpRequest.newBuilder(new URI(URI_GOOGLE)).GET().build();
		
		CompletableFuture<HttpResponse<String>> httpResponse = httpClient.sendAsync(httpRequest, BodyHandlers.ofString());
		httpResponse.whenComplete((s, t) -> System.out.println(s.body()));  // quando tiver completado a ação, imprima o conteúdo
		
	}

}
