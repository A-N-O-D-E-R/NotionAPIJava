package anode.tool.notion.api.auth;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class Session {
    //secret_CyVp2y5PO95Ly2IfTYElNGmSngIcQqgbHjr7U3ts2XZ
    private String baseURL;
    private String version;
    private String secret;
    private Transaction transaction;

    public Session(String token){
        this.baseURL = "https://api.notion.com/v1";
        this.version = "2022-06-28";
        this.secret= token;
        this.transaction = new Transaction();
    }

    public Transaction getTransaction() {
        return this.transaction;
    }

    public void newTransaction() {
        this.transaction = new Transaction();
    }

    public String commit(){
        HttpRequest request=HttpRequest.newBuilder()
        .uri(URI.create(this.baseURL + "/"+this.transaction.getUrl()))
        .header("accept", "application/json")
        .header("Notion-Version", this.version)
        .header("Bearer", secret)
        .header("content-type", "application/json")
        .method(this.transaction.getMethod(), HttpRequest.BodyPublisher.noBody())
        .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

}
