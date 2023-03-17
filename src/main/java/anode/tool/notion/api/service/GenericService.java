package anode.tool.notion.api.service;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import anode.tool.notion.api.auth.SessionManagerSingleton;
import anode.tool.notion.api.auth.Transaction;
import anode.tool.notion.api.model.Database;
import anode.tool.notion.api.model.NotionObject;

import java.util.UUID;

abstract class  GenericService <T extends NotionObject> {
    
    private GenericService(){}  


    @SuppressWarnings("unchecked")
    public  List<T> getAll() throws JsonProcessingException {
        Transaction transcation = SessionManagerSingleton.getInstance().getTransaction();
        transcation.setUrl("search");
        transcation.post();
        transcation.setBody("{\"page_size\":100}");
        ObjectMapper objectMapper = new ObjectMapper();
        final Map<String, String> result = objectMapper.readValue(SessionManagerSingleton.getInstance().commit(),
                Map.class);
        return objectMapper.readValue(result.get("results"), List.class);
    }

    /**
     * @param id
     * @return NotionObject 
     * @throws JsonProcessingException
     */
    @SuppressWarnings("unchecked")
    public T getById(UUID id) throws JsonProcessingException {
        SessionManagerSingleton.getInstance().newTransaction();
        Transaction transcation = SessionManagerSingleton.getInstance().getTransaction();
        transcation.setUrl(T.OBJECT_TYPE+"/"+id);
        transcation.get();
        ObjectMapper objectMapper = new ObjectMapper();
        final Map<String, String> result = objectMapper.readValue(SessionManagerSingleton.getInstance().commit(),
                Map.class);
        return (T) result.get("results");
    }


    public T getByName(String name) throws JsonProcessingException {
        SessionManagerSingleton.getInstance().newTransaction();
        Transaction transcation = SessionManagerSingleton.getInstance().getTransaction();
        transcation.setUrl(T.OBJECT_TYPE+"/"+id);
        transcation.get();
        ObjectMapper objectMapper = new ObjectMapper();
        final Map<String, String> result = objectMapper.readValue(SessionManagerSingleton.getInstance().commit(),
                Map.class);
        return (T) result.get("results");
    }
}
