package anode.tool.notion.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FileObject {
    String url;
    @JsonProperty("expiry_time")
    Time expiryTime;
    @Override
    public String toString() {
        return "FileObject [url=" + url + ", expiry_time=" + expiryTime + "]";
    }
}
