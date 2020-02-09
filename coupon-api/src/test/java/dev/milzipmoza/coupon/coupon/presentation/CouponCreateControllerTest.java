package dev.milzipmoza.coupon.coupon.presentation;

import dev.milzipmoza.coupon.coupon.dto.CouponCreateRequestDto;
import dev.milzipmoza.coupon.utils.JsonPrettier;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.LocalDateTime;

@Slf4j
@AutoConfigureWebTestClient
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CouponCreateControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    @DisplayName("POST /v1/coupons, 쿠폰 생성")
    void 쿠폰_생성() {
        CouponCreateRequestDto requestDto = CouponCreateRequestDto.builder()
                .name("루피가 사는 커피 쿠폰")
                .description("루피에게 커피를 조르세요 !")
                .usableStartTime(LocalDateTime.now().plusDays(1L))
                .usableEndTime(LocalDateTime.now().plusDays(2L))
                .createUserId(1L)
                .createUserName("루피")
                .build();

        this.webTestClient
                .post()
                .uri("/v1/coupons")
                .header("Tecobrary-User-Id", "1")
                .header("Tecobrary-User-Name", "루피")
                .bodyValue(requestDto)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .consumeWith(response -> log.info("response body - {}", JsonPrettier.parse(response)))
                .jsonPath("$.message").isEqualTo("쿠폰 생성 성공")
                .jsonPath("$.data.name").isEqualTo("루피가 사는 커피 쿠폰")
                .jsonPath("$.data.description").isEqualTo("루피에게 커피를 조르세요 !")
                .jsonPath("$.data.usableStartTime").isNotEmpty()
                .jsonPath("$.data.usableEndTime").isNotEmpty()
                .jsonPath("$.statusCode").isEqualTo(200)
                ;
    }
}