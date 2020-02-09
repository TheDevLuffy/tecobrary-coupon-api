package dev.milzipmoza.coupon.common;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiResponse {

    private String message;
    private Object data;
    private int statusCode;

    public static ApiResponse ok(final String message, final Object data) {
        return new ApiResponse(message, data, 200);
    }
}
