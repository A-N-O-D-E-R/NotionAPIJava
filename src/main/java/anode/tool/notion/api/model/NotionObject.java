package anode.tool.notion.api.model;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import anode.tool.notion.api.model.user.NotionUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class NotionObject {
    public static final String OBJECT_TYPE = "unknown";
    public static final UUID OBJECT_TYPET = null;
    private UUID id;
    private Time createdTime;
    private NotionUser createdBy;
    private Time lastEditedTime;
    private NotionUser lastEditedBy;
    private boolean archived;
    private FileObjectWrapper icon; 
    private FileObjectWrapper cover;
    private Map<String, NotionProperty> properties; 
    private NotionObject parent;
    private URL url;
    @Override
    public String toString() {
        return "NotionObject [id=" + id + ", createdTime=" + createdTime + ", createdBy=" + createdBy
                + ", lastEditedTime=" + lastEditedTime + ", lastEditedBy=" + lastEditedBy + ", archived=" + archived
                + ", icon=" + icon + ", cover=" + cover + ", properties=" + properties + ", parent=" + parent + ", url="
                + url + "]";
    }


}
