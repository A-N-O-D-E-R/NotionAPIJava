package anode.tool.notion.api.model.user;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NotionUser {
    String userType;
    @Override
    public String toString() {
        return "NotionUser [userType=" + userType + ", name=" + name + ", avatarUrl=" + avatarUrl + "]";
    }
    String name;
    String avatarUrl;


}
