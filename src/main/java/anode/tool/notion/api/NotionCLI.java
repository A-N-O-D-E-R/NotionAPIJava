package anode.tool.notion.api;


import java.util.UUID;

import com.fasterxml.jackson.core.JsonProcessingException;

import anode.tool.notion.api.service.DatabaseService;

class NotionCLI {

    public static void main(String[] args) throws JsonProcessingException {
        DatabaseService databaseService = new DatabaseService();
        System.out.println(databaseService.getById(UUID.fromString("66546a3a-87e2-43dc-8bf3-63a50db5ef8e")));
    }

}
