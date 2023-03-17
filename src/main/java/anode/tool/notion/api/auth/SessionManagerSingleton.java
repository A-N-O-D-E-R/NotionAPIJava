package anode.tool.notion.api.auth;

public class SessionManagerSingleton {
    private static Session session;

    private SessionManagerSingleton() {
        // constructor of the SessionManagerSingleton class
     }
    public static Session getInstance(){
        if(session == null){
            session = SessionFactory.generatedDefaultSession();
        }
        return session;
    }
}
