package anode.tool.notion.api.service;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import anode.tool.notion.api.auth.SessionManagerSingleton;
import anode.tool.notion.api.auth.Transaction;
import anode.tool.notion.api.exception.SessionException;
import anode.tool.notion.api.model.NotionObject;

import java.util.UUID;

import javax.management.RuntimeErrorException;

public class  GenericService <T extends NotionObject> {
    
    protected GenericService(Class<T> clazz) {
        this.clazz = clazz;
    }
    private final Class<T> clazz;


    @SuppressWarnings("unchecked")
    public  List<T> getAll() throws JsonProcessingException {
        Transaction transcation = SessionManagerSingleton.getInstance().getTransaction();
        transcation.setUrl("search");
        transcation.post();
        transcation.setBody("{\"page_size\":100}");
        ObjectMapper objectMapper = new ObjectMapper();
        String res =SessionManagerSingleton.getInstance().commit();
        final Map<String, Object> result = objectMapper.readValue(res,Map.class);
        return (List) result.get("results");
    }

    /**
     * @param id
     * @return NotionObject 
     * @throws JsonProcessingException
     */
    @SuppressWarnings("unchecked")
    public T getById(UUID id) throws SessionException {
        try {
            SessionManagerSingleton.getInstance().newTransaction();
            Transaction transcation = SessionManagerSingleton.getInstance().getTransaction();
            transcation.setUrl(plural((String)clazz.getField("OBJECT_TYPE").get(null))+"/"+id);
            transcation.get();
            System.out.println(SessionManagerSingleton.getInstance().commit());
            return new ObjectMapper().readValue(SessionManagerSingleton.getInstance().commit(),clazz);
        } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException | JsonProcessingException e) {
            throw new SessionException("Error during the quering", e);
        }
        
    }


    public T getByName(String name) throws JsonProcessingException {
        SessionManagerSingleton.getInstance().newTransaction();
        Transaction transcation = SessionManagerSingleton.getInstance().getTransaction();
        transcation.setUrl(plural(T.OBJECT_TYPE)+"/"+name);
        transcation.get();
        ObjectMapper objectMapper = new ObjectMapper();
        final Map<String, String> result = objectMapper.readValue(SessionManagerSingleton.getInstance().commit(),
                Map.class);
        return  objectMapper.readValue(result.get("results"), clazz);
    }


    private String plural(String name){
        return name+"s";
    }
}
