package com.ganghee.elogistics.config.auth.dto;

import com.ganghee.elogistics.domain.member.Member;
import com.ganghee.elogistics.domain.member.Role;
import lombok.Getter;

import java.io.Serializable;

@Getter
//SessionUser에는 인증된 사용자 정보만 필요하기 때문에 name,email,picture만 필드로 선언한다.
public class SessionMember implements Serializable {

    private Long id;
    private String name;
    private String email;
    private String picture;

    private Role role;

    public SessionMember(Member member){
        this.id = member.getId();
        this.name = member.getName();
        this.email = member.getEmail();
        this.picture = member.getPicture();
        this.role = member.getRole();
    }
}
