package com.ganghee.elogistics.domain.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("SELECT o FROM Order o INNER JOIN OrderItem oi " +
            "on o.id = oi.id INNER JOIN Item i " +
            "on oi.id = i.id ORDER BY o.id DESC ")
    List<Order> findAllOrderDesc();
}
