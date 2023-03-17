package anode.tool.notion.api.model;

import java.net.URL;
import java.util.List;
import java.util.UUID;
import javax.tools.FileObject;


public abstract class NotionObject {
    public static final String OBJECT_TYPE = "unknown";
    public static final UUID OBJECT_TYPET = null;
    private UUID id;
    private Time createdTime;
    private User createdBy;
    private Time lastEditedTime;
    private User lastEditedBy;
    private boolean archived;
    private FileObject icon; 
    private FileObject cover;
    private List<NotionProperty> properties; 
    private NotionObject parent;
    private URL url;
}
