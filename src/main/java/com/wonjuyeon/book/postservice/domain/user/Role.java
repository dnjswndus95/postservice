package com.wonjuyeon.book.postservice.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    /**
     * Spring Security에선 ROLE_이 앞에 있어야 키 값으로 인식한다.
     */
    GUEST("ROLE_GUEST", "손님"),
    USER("ROLE_USER", "사용자");

    private final String key;
    private final String title;
}
