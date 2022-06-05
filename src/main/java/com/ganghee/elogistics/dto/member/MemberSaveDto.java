package com.ganghee.elogistics.dto.member;

import com.ganghee.elogistics.domain.address.Address;
import com.ganghee.elogistics.domain.member.Member;
import com.ganghee.elogistics.domain.member.Role;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberSaveDto {

    private String name;

    private String password;

    private String email;

    private Address address;

    private Role role;

    @Builder
    public MemberSaveDto(String name, String password, String email, Address address, Role role){
        this.name = name;
        this.password = password;
        this.email = email;
        this.address = address;
        this.role = role;
    }

    public Member toEntity(){
        return Member.builder().name(this.name).password(this.password)
                .email(this.email).address(this.address).role(role).build();
    }
}
