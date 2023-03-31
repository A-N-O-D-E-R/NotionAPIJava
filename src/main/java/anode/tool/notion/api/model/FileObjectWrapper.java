package anode.tool.notion.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FileObjectWrapper {
    String type;
    FileObject file;
    @Override
    public String toString() {
        return "FileObjectWrapper [type=" + type + ", file=" + file + "]";
    }
}
