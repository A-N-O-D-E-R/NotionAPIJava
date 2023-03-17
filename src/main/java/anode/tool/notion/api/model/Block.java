package anode.tool.notion.api.model;

public class Block {
    public static final String OBJECT_TYPE = "block";
    private UUID id;
    private String type;
    private Time createdTime;
    private User createdBy;
    private Time lastEditedTime;
    private User lastEditedBy;
    private boolean archived;
    private boolean has_children;
    private NotionObject parent;
}
