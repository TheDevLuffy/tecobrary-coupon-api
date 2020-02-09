package dev.milzipmoza.coupon.utils;

import org.springframework.test.web.reactive.server.EntityExchangeResult;

/**
 * TODO: 좀 더 연구가 필요합니다. depth 가 깊어지는 부분에 대해서는 처리가 불가능 합니다.
 */
public class JsonPrettier {

    public static String parse(EntityExchangeResult<byte[]> response) {
        return response.toString()
                .replace(",", ",\n\t")
                .replace("{", "{\n\t")
                .replace("}", "\n}");
    }
}
