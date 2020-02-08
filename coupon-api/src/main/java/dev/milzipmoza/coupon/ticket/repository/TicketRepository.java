package dev.milzipmoza.coupon.ticket.repository;

import dev.milzipmoza.coupon.domains.ticket.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
