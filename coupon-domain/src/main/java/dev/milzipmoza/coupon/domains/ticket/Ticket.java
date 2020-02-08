package dev.milzipmoza.coupon.domains.ticket;

import dev.milzipmoza.coupon.enums.TicketStatus;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode(of = "ticketNo", callSuper = false)
@Table(name = "TICKET")
@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_no")
    private Long ticketNo;

    @Embedded
    private TicketInfo ticketInfo;

    @Embedded
    private TicketOwner ticketOwner;

    @Enumerated(EnumType.STRING)
    @Column(name = "ticket_status")
    private TicketStatus ticketStatus;

    @Builder
    public Ticket(final Long userId,
                  final String userName,
                  final Long couponNo,
                  final String couponName) {
        this.ticketInfo = TicketInfo.builder()
                .couponNo(couponNo)
                .couponName(couponName)
                .build();
        this.ticketOwner = TicketOwner.builder()
                .userId(userId)
                .userName(userName)
                .build();
        this.ticketStatus = TicketStatus.UNUSED;
    }
}
