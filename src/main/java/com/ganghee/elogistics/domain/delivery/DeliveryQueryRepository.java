package com.ganghee.elogistics.domain.delivery;

import com.ganghee.elogistics.domain.item.QItem;
import com.ganghee.elogistics.domain.member.QMember;
import com.ganghee.elogistics.domain.order.QOrder;
import com.ganghee.elogistics.domain.orderItem.QOrderItem;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class DeliveryQueryRepository {

    private final JPAQueryFactory queryFactory;

    private final QDelivery delivery = new QDelivery("delivery1");

    private final QMember member = new QMember("member1");

    private final QOrder order = new QOrder("order1");

    private final QItem item = new QItem("item1");

    private final QOrderItem orderItem = new QOrderItem("orderItem1");


    public List<Delivery> findAllDeliveryDesc(Long orderId){
        return queryFactory
                .select(delivery).from(delivery)
                .join(delivery.order, order)
                .where(orderIdEq(orderId))
                .orderBy(delivery.id.desc())
                .fetch();
    }
    private BooleanExpression orderIdEq(Long orderId) {
        return orderId != null ? order.id.eq(orderId) : null;
    }
}
