package anode.tool.notion.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NotionProperty {
    private String id;
    private String name;
    private String type;
    private Object option;

    @Override
    public String toString() {
        return "NotionProperty [id=" + id + ", name=" + name + ", type=" + type + ", " + type + "= " + option + "]";
    }
}
