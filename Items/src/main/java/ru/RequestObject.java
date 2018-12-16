package ru;

import java.util.Arrays;
import java.util.List;

public class RequestObject {

    private String values;

    public RequestObject() {}

    public RequestObject(List<String> values) {
        this.values = String.join(",", values);
    }

    public String getString() {
        return values;
    }

    public void setString(String values) {
        this.values = values;
    }

    public List<String> toList() {
        return Arrays.asList(values.split(","));
    }

    public String toJSON() {
        return "{\"values\":\""+ values +"\"}";
    }
}
