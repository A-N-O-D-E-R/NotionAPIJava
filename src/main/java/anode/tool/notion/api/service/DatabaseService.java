package anode.tool.notion.api.service;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import anode.tool.notion.api.auth.SessionManagerSingleton;
import anode.tool.notion.api.auth.Transaction;
import anode.tool.notion.api.model.Database;
import java.util.UUID;

class DatabaseService {
    private DatabaseService() {
    }

    @SuppressWarnings("unchecked")
    public static List<Database> getAllDatabases() throws JsonProcessingException {
        Transaction transcation = SessionManagerSingleton.getInstance().getTransaction();
        transcation.setUrl("search");
        transcation.post();
        transcation.setBody("{\"page_size\":100}");
        ObjectMapper objectMapper = new ObjectMapper();
        final Map<String, String> result = objectMapper.readValue(SessionManagerSingleton.getInstance().commit(),
                Map.class);
        return objectMapper.readValue(result.get("results"), List.class);
    }

    @SuppressWarnings("unchecked")
    public static Database getById(UUID id) throws JsonProcessingException {
        SessionManagerSingleton.getInstance().newTransaction();
        Transaction transcation = SessionManagerSingleton.getInstance().getTransaction();
        transcation.setUrl("databases/"+id);
        transcation.get();
        ObjectMapper objectMapper = new ObjectMapper();
        final Map<String, String> result = objectMapper.readValue(SessionManagerSingleton.getInstance().commit(),
                Map.class);
        return objectMapper.readValue(result.get("results"), Database.class);
    }
}
