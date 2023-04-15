package anode.tool.notion.api.mapper;

import java.io.IOException;
import java.util.UUID;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import anode.tool.notion.api.model.user.NotionUser;

public class NotionUserDeserialiser extends StdDeserializer<NotionUser> {
    public NotionUserDeserialiser() {
        this(null);
    }

    public NotionUserDeserialiser(Class<?> vc) {
        super(vc);
    }

    @Override
    public NotionUser deserialize(JsonParser parser, DeserializationContext deserializer) throws IOException {
        NotionUser notionUser = new NotionUser();
        ObjectCodec codec = parser.getCodec();
        final JsonNode node = codec.readTree(parser);
        //NotionUser
        notionUser.setId(UUID.fromString(node.get("id").asText()));
        return notionUser;
    }
}