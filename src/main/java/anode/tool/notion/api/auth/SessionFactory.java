package anode.tool.notion.api.auth;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import anode.tool.notion.api.exception.SessionException;

public class SessionFactory {

    private SessionFactory(){}
    
    public static Session generatedSession(String sessionType){
        try (InputStream input = new FileInputStream(sessionType+".properties")) {
            Properties prop = new Properties();
            prop.load(input);
            return new Session(prop.getProperty("session.token"));
        } catch (IOException ex) {
            throw new SessionException("Unable to implement methods", ex);
        }
    }

    public static Session generatedDefaultSession(){
        try (InputStream input = new FileInputStream("default.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            return new Session(prop.getProperty("session.token"));
        } catch (IOException ex) {
            throw new SessionException("Unable to implement methods", ex);
        }
        
    }

}
