package dev.milzipmoza.coupon.domains.coupon;

import dev.milzipmoza.coupon.exceptions.IllegalCouponConditionException;
import dev.milzipmoza.coupon.exceptions.InvalidCouponUsablePeriodException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CouponTest {

    private static final String VALID_COUPON_NAME = "루피의 커피 쿠폰";
    private static final String VALID_COUPON_DESC = "루피가 사는 커피 쿠폰";
    private static final LocalDateTime VALID_USABLE_START_TIME = LocalDateTime.now().plusDays(1L);
    private static final LocalDateTime VALID_USABLE_END_TIME = LocalDateTime.now().plusDays(2L);

    @Test
    @DisplayName("Coupon 성공적으로 생성")
    void 성공적으로_생성() {
        assertDoesNotThrow(() -> Coupon.builder()
                .name(VALID_COUPON_NAME)
                .description(VALID_COUPON_DESC)
                .usableStartTime(VALID_USABLE_START_TIME)
                .usableEndTime(VALID_USABLE_END_TIME)
                .build());
    }

    @Test
    @DisplayName("Coupon 생성 실패 이름 글자수 제한")
    void 생성_실패_이름_제한() {
        assertThrows(IllegalCouponConditionException.class, () -> Coupon.builder()
                .name("글자수가삼" +
                        "십자가넘어" +
                        "가면생성에" +
                        "실패하는쿠" +
                        "폰입니다그" +
                        "러므로글자" +
                        "ㅇ")
                .description(VALID_COUPON_DESC)
                .usableStartTime(VALID_USABLE_START_TIME)
                .usableEndTime(VALID_USABLE_END_TIME)
                .build());
    }

    @Test
    @DisplayName("Coupon 생성 실패 설명 글자수 제한")
    void 생성_실패_설명_제한() {
        assertThrows(IllegalCouponConditionException.class, () -> Coupon.builder()
                .name(VALID_COUPON_NAME)
                .description("설명의글자수가넘어가" +
                        "면안되는조건입니다설" +
                        "명은백글자미만으로구" +
                        "성되어야합니다이글자" +
                        "수제한은채우기가너무" +
                        "힘들기때문에아무말대" +
                        "잔치로대체하겠습니다" +
                        "그치만또말이되는경우" +
                        "도있을것같지만또꼭그" +
                        "렇지만은않아요화이팅" +
                        "ㅇ")
                .usableStartTime(VALID_USABLE_START_TIME)
                .usableEndTime(VALID_USABLE_END_TIME)
                .build());
    }

    @Test
    @DisplayName("Coupon 생성 실패 시작 시간이 현재 시간 이전")
    void 사용_가능_시작_시간_제한() {
        assertThrows(InvalidCouponUsablePeriodException.class, () -> Coupon.builder()
                .name(VALID_COUPON_NAME)
                .description(VALID_COUPON_DESC)
                .usableStartTime(LocalDateTime.now().minusDays(1L))
                .usableEndTime(LocalDateTime.now())
                .build());
    }

    @Test
    @DisplayName("Coupon 생성 실패 종료 시간이 현재 시간 이전, 시작 시간 보다 이른 종료 시간")
    void 사용_가능_종료_시간_제한() {
        assertThrows(InvalidCouponUsablePeriodException.class, () -> Coupon.builder()
                .name(VALID_COUPON_NAME)
                .description(VALID_COUPON_DESC)
                .usableStartTime(LocalDateTime.now())
                .usableEndTime(LocalDateTime.now().minusDays(1L))
                .build());
    }
}