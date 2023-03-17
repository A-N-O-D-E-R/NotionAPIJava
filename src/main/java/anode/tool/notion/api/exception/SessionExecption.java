package anode.tool.notion.api.exception;

public class SessionExecption extends RuntimeException{
    public SessionExecption(String msg, Throwable cause){
        super(msg, cause);
    }

    public SessionExecption(String msg){
        super(msg);
    }
}
