package com.ganghee.elogistics.dto.member;

import com.ganghee.elogistics.domain.address.Address;
import com.ganghee.elogistics.domain.member.Member;
import com.ganghee.elogistics.domain.member.Role;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberResponseDto {

    private Long id;

    private String name;

    private String password;

    private String email;

    private Address address;

    private Role role;

    @Builder
    public MemberResponseDto(Member member){
        this.id = member.getId();
        this.name = member.getName();
        this.password = member.getPassword();
        this.email = member.getEmail();
        this.address = member.getAddress();
        this.role = member.getRole();
    }
}
