package com.ganghee.elogistics.domain.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query("SELECT i FROM Item i INNER JOIN CategoryItem ci " +
            "on i.id = ci.id INNER JOIN Category c " +
            "on ci.id = c.id ORDER BY i.id DESC ")
    List<Item> findAllItemDesc();

    @Query("SELECT i.name FROM Order o INNER JOIN OrderItem oi " +
            "on o.id = oi.id INNER JOIN Item i " +
            "on oi.id = i.id ORDER BY o.id DESC")
    List<String> findItemName();
}
