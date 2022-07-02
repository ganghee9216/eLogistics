package com.ganghee.elogistics.domain.item;

import com.ganghee.elogistics.domain.category.QCategory;
import com.ganghee.elogistics.domain.member.QMember;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemQueryRepository {
    private final JPAQueryFactory queryFactory;

    private final QMember member = new QMember("member1");

    private final QCategory category = new QCategory("category1");

    private final QItem item = new QItem("item1");


    public List<Item> findAllStockDesc(Long memberId) {
        return queryFactory
                .select(item).from(item).join(item.provider, member)
                .join(item.category, category)
                .where(memberIdEq(memberId))
                .orderBy(item.id.desc())
                //조회 대상이 여러건일 경우, 컬렉션 반환
                .fetch();
        }
    private BooleanExpression memberIdEq(Long memberId){
        return memberId != null ? member.id.eq(memberId) : null;
    }
}
