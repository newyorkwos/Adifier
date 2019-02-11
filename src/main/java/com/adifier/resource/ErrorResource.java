package com.adifier.resource;

/**
 * 描述:
 * create ErrorResource
 *
 * @author StevenWu
 * @create 2019-01-28-15:38
 */
public class ErrorResource {

    private String message;

    public ErrorResource(String message){
        this.message=message;
    }

    public String getMessage() {
        return message;
    }
}
