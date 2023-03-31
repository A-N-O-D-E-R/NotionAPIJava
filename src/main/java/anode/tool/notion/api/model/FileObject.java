package anode.tool.notion.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FileObject {
    String url;
    Time expiry_time;
    @Override
    public String toString() {
        return "FileObject [url=" + url + ", expiry_time=" + expiry_time + "]";
    }
}
