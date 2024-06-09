package org.example.helloworld.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {
    private Integer code;
    private String message;
    private T data;

    public static <T> Response<T> success(T data) {
        return new Response<>(0, "ok", data);
    }

    public static <T> Response<T> success() {
        return new Response<>(0, "ok", null);
    }

    public static <T> Response<T> error(String message) {
        return new Response<>(1, message, null);
    }
}
