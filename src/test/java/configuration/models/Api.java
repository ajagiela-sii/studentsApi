package configuration.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.LinkedHashMap;
import java.util.Map;

public class Api {
    Map<String, Object> properties = new LinkedHashMap<>();

    @JsonAnySetter
    void setApiProperties(String key, Object value) { properties.put(key, value); }

    @JsonAnyGetter
    public Map<String, Object> getApiProperties() { return properties; }
}
