package anode.tool.notion.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Page extends NotionObject {
    public static final String OBJECT_TYPE = "page";

    public Page() {
        super();
    }

    @Override
    public String toString() {
        return "Page [id=" + super.getId() + ", createdTime=" + super.getCreatedTime() + ", createdBy="
                + super.getCreatedBy()
                + ", lastEditedTime=" + super.getLastEditedTime() + ", lastEditedBy=" + super.getLastEditedBy()
                + ", archived=" + super.isArchived()
                + ", icon=" + super.getIcon() + ", cover=" + super.getCover() + ", properties=" + super.getProperties()
                + ", parent=" + super.getParent() + ", url="
                + super.getUrl() + "]";
    }

}