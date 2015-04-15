package org.talangsoft.userrealm.api;


import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorDTO {

    private String code;

    public ErrorDTO(@JsonProperty("code") String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
