package anode.tool.notion.api.service;

import java.lang.module.ModuleDescriptor.Version;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import anode.tool.notion.api.auth.SessionManagerSingleton;
import anode.tool.notion.api.auth.Transaction;
import anode.tool.notion.api.exception.SessionException;
import anode.tool.notion.api.mapper.NotionPropertyDeserialiser;
import anode.tool.notion.api.mapper.NotionUserDeserialiser;
import anode.tool.notion.api.model.Database;
import anode.tool.notion.api.model.NotionProperty;
import anode.tool.notion.api.model.Page;
import anode.tool.notion.api.model.user.NotionUser;

public class DatabaseService extends GenericService<Database> {
    public DatabaseService() {
        super(Database.class);
    }

    public Database getById(UUID id) throws SessionException {
        Database db = super.getById(id);
        SessionManagerSingleton.getInstance().newTransaction();
        Transaction transcation = SessionManagerSingleton.getInstance().getTransaction();
        transcation.setUrl("databases/" + id + "/query");
        transcation.post();
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule("CustomPropertyDeserializer");
        module.addDeserializer(NotionProperty.class, new NotionPropertyDeserialiser());
        module.addDeserializer(NotionUser.class, new NotionUserDeserialiser());
        objectMapper.registerModule(module);
        try {
            final Map<String, Object> result = objectMapper.readValue(SessionManagerSingleton.getInstance().commit(),
                    Map.class);
            db.setElements((List<Page>) result.get("results"));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return db;
    }
}
