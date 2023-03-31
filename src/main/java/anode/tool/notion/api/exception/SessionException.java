package anode.tool.notion.api.exception;

public class SessionException extends RuntimeException{
    public SessionException(String msg, Throwable cause){
        super(msg, cause);
    }

    public SessionException(String msg){
        super(msg);
    }
}
