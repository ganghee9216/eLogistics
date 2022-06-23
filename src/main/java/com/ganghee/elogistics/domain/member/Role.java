package com.ganghee.elogistics.domain.member;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    PROVIDER("ROLE_PROVIDER", "공급업체"),
    RETAIL("ROLE_RETAIL", "마트"),
    LOGISTICS("ROLE_LOGISTICS", "물류업체");

    private final String key;
    private final String title;
}
