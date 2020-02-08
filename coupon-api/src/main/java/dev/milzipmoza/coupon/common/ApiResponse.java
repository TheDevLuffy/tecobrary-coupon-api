package dev.milzipmoza.coupon.common;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiResponse {

    private String message;
    private Object data;
    private String statusCode;

    public static ApiResponse ok(final String message, final Map<?, ?> data) {
        return new ApiResponse(message, data, "200");
    }

    public static ApiResponse ok(final String message, final Object data) {
        return new ApiResponse(message, data, "200");
    }
}
