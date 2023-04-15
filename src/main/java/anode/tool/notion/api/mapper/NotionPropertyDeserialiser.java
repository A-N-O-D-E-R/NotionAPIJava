package anode.tool.notion.api.mapper;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import anode.tool.notion.api.model.NotionProperty;

public class NotionPropertyDeserialiser extends StdDeserializer<NotionProperty> {
    public NotionPropertyDeserialiser() {
        this(null);
    }

    public NotionPropertyDeserialiser(Class<?> vc) {
        super(vc);
    }

    @Override
    public NotionProperty deserialize(JsonParser parser, DeserializationContext deserializer) throws IOException {
        NotionProperty notionProperty = new NotionProperty();
        ObjectCodec codec = parser.getCodec();
        final JsonNode node = codec.readTree(parser);
        notionProperty.setId(node.get("id").asText());
        notionProperty.setName(node.get("name").asText());
        notionProperty.setType(node.get("type").asText());
        notionProperty.setOption(node.get(notionProperty.getType()));
        return notionProperty;
    }
}