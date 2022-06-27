package com.ganghee.elogistics.domain.order;

import com.ganghee.elogistics.domain.item.QItem;
import com.ganghee.elogistics.domain.member.QMember;
import com.ganghee.elogistics.domain.orderItem.QOrderItem;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderQueryRepository {

    private final JPAQueryFactory queryFactory;

    private final QMember member = new QMember("member1");

    private final QOrder order = new QOrder("order1");

    private final QItem item = new QItem("item1");

    private final QOrderItem orderItem = new QOrderItem("orderItem1");


    public List<Order> findAllOrdersDesc(Long memberId){
        return queryFactory
                .select(order).from(order).join(order.member, member)
                .leftJoin(order.orderItems, orderItem)
                .leftJoin(orderItem.item, item)
                .where(memberIdEq(memberId))
                .orderBy(order.id.desc())
                //조회 대상이 여러건일 경우, 컬렉션 반환
                .fetch();
    }
    private BooleanExpression memberIdEq(Long memberId) {
        return memberId != null ? member.id.eq(memberId) : null;
    }
}
