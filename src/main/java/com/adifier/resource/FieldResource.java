package com.adifier.resource;

/**
 * 描述:
 * create Resource
 *
 * @author StevenWu
 * @create 2019-02-06-22:53
 */
public class FieldResource {
    private String resource;
    private String field;
    private String code;
    private String message;

    public FieldResource(String resource, String field, String code, String message) {
        this.resource = resource;
        this.field = field;
        this.code = code;
        this.message = message;
    }

    public String getResource() {
        return resource;
    }

    public String getField() {
        return field;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
