package anode.tool.notion.api.model;

import java.util.UUID;

import anode.tool.notion.api.model.user.NotionUser;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@NoArgsConstructor
@Getter
@Setter
public class Block {
    public static final String object = "block";
    private UUID id;
    private String type;
    private Time createdTime;
    private NotionUser createdBy;
    private Time lastEditedTime;
    private NotionUser lastEditedBy;
    private boolean archived;
    private boolean has_children;
    private NotionObject parent;
}
