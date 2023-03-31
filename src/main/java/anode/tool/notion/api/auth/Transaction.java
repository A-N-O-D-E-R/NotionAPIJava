package anode.tool.notion.api.auth;

import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublisher;

public class Transaction {
    
    private String url;
    private String method;
    private BodyPublisher body = HttpRequest.BodyPublishers.noBody();

    public Transaction(String url, String method, BodyPublisher body){
        this.url=url;
        this.method=method;
        this.body=body;
    }

    public Transaction(){
        // Empty constructor the Object is aim to be 
        // instantiate by the Transaction Builder
    }

    public void setUrl(String url){
        this.url=url;
    }

    private void setMethod(String method){
        this.method=method;
    }

    public void setBody(String body){
        this.body=HttpRequest.BodyPublishers.ofString(body);
    }

    public void clearBody(){
        this.body=HttpRequest.BodyPublishers.noBody();
    }

    public String getUrl(){
        return this.url;
    }

    public String getMethod(){
        return this.method;
    }

    public BodyPublisher getBody(){
        return this.body;
    }

    public void post(){
        this.setMethod("POST");
    }

    public void get(){
        this.setMethod("GET");
    }

    public void update(){
        this.setMethod("UPDATE");
    }

}
