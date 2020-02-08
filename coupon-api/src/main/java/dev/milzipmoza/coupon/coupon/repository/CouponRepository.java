package dev.milzipmoza.coupon.coupon.repository;

import dev.milzipmoza.coupon.domains.coupon.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {

    List<Coupon> findAllByInfoCreateUserIdAndInfoCreateUserName(Long createUserId, String createUserName);
}
