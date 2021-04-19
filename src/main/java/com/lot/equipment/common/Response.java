package com.lot.equipment.common;

import lombok.Data;

@Data
public class Response {

    private static final Response SUCC = new Response("200", "success");

    private String code;
    private String message;
    private Object data;

    public Response() {
    }

    public Response(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public Response(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static Response succ() {
        return SUCC;
    }

    public static <T> Response succ(T data) {
        return new Response("200", "success", data);
    }
}
