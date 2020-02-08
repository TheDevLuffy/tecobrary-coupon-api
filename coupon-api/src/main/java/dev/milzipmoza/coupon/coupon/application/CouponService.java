package dev.milzipmoza.coupon.coupon.application;

import dev.milzipmoza.coupon.coupon.dto.CouponCreateRequestDto;
import dev.milzipmoza.coupon.coupon.repository.CouponRepository;
import dev.milzipmoza.coupon.domains.coupon.Coupon;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class CouponService {

    private final CouponRepository couponRepository;

    List<Coupon> readByUserInfo(final Long userId,
                                final String userName) {
        return couponRepository.findAllByInfoCreateUserIdAndInfoCreateUserName(userId, userName);
    }

    Coupon create(final Long userId, final String userName, final CouponCreateRequestDto requestDto) {
        Coupon coupon = Coupon.builder()
                .name(requestDto.getName())
                .description(requestDto.getDescription())
                .usableStartTime(requestDto.getUsableStartTime())
                .usableEndTime(requestDto.getUsableEndTime())
                .createUserId(userId)
                .createUserName(userName)
                .build();
        return couponRepository.save(coupon);
    }

    Coupon delete(final Long userId, final Long couponNo) {
        Coupon savedCoupon = couponRepository.findById(couponNo)
                .orElseThrow(NotFoundCouponException::new);
        savedCoupon.checkUserId(userId);
        couponRepository.delete(savedCoupon);
        return savedCoupon;
    }
}
