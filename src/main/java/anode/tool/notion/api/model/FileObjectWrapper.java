package anode.tool.notion.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FileObjectWrapper {
    String type;
    FileObject file;
    @Override
    public String toString() {
        return "FileObjectWrapper [type=" + type + ", file=" + file + "]";
    }
}
