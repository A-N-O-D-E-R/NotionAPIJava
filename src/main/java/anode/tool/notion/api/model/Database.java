package anode.tool.notion.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Database extends NotionObject{
    public static final String OBJECT_TYPE = "database";

    @Override
    public String toString() {
        return "Database [id=" + super.getId() + ", createdTime=" + super.getCreatedTime() + ", createdBy=" + super.getCreatedBy()
        + ", lastEditedTime=" + super.getLastEditedTime() + ", lastEditedBy=" + super.getLastEditedBy() + ", archived=" + super.isArchived()
        + ", icon=" + super.getIcon() + ", cover=" + super.getCover() + ", properties=" + super.getProperties() + ", parent=" + super.getParent() + ", url="
        + super.getUrl() + "]";
    }
}
