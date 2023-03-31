package anode.tool.notion.api.auth;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import anode.tool.notion.api.exception.SessionException;

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
        try {
        HttpRequest request=HttpRequest.newBuilder()
        .uri(URI.create(this.baseURL + "/"+this.transaction.getUrl()))
        .header("accept", "application/json")
        .header("Notion-Version", this.version)
        .header("Authorization", "Bearer "+secret)
        .header("content-type", "application/json")
        .method(this.transaction.getMethod(), HttpRequest.BodyPublishers.noBody())
        .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
        } catch (IOException e) {
            throw  new SessionException("unable to commit change", e);
        }
        catch(InterruptedException e){
            throw  new SessionException("The thread have been interrupted", e);
        }
       
    }

}
