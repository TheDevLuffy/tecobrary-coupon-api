package dev.milzipmoza.coupon.common;

import dev.milzipmoza.coupon.exceptions.AlreadySoftDeletedException;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.util.Objects;

@MappedSuperclass
@Getter
public class DeletableEntity {

    @Column(name = "create_date_time",
            updatable = false,
            nullable = false)
    @CreationTimestamp
    private LocalDateTime createDateTime;

    @Column(name = "update_date_time",
            nullable = false)
    @UpdateTimestamp
    private LocalDateTime updateDateTime;

    @Column(name = "delete_date_time")
    private LocalDateTime deleteDateTime;

    protected void softDelete() {
        if (Objects.isNull(deleteDateTime)) {
            deleteDateTime = LocalDateTime.now();
        }
        throw new AlreadySoftDeletedException();
    }
}
