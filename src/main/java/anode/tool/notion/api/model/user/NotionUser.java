package anode.tool.notion.api.model.user;

import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class NotionUser {
    String userType;
    UUID id;
    String name;
    String avatarUrl;

    @Override
    public String toString() {
        return "NotionUser [userType=" + userType + ", name=" + name + ", avatarUrl=" + avatarUrl + "]";
    }


}
