package infoart_3_zad;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public interface sendHTTPRequest {

	public static String sendGETRequest(){
		  HttpClient client = HttpClient.newHttpClient();
		  HttpRequest request = HttpRequest.newBuilder()
				    .uri(URI.create("https://www.hnb.hr/tecajn-eur/htecajn.htm"))
				    .build();
		  HttpResponse<String> response = null;
		  try {
			response = client.send(request,
			HttpResponse.BodyHandlers.ofString());

		  } catch (IOException e) {
			e.printStackTrace();
		  } catch (InterruptedException e) {
			e.printStackTrace();
		  }
		  
		  return response.body();
	}
}
