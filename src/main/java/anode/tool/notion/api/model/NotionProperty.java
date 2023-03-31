package anode.tool.notion.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class NotionProperty {
    private String id;
    private String name;
    private String type;
    @Override
    public String toString() {
        return "NotionProperty [id=" + id + ", name=" + name + ", type=" + type + "]";
    }  
}
