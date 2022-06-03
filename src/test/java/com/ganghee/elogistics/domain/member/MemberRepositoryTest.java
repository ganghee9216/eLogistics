package com.ganghee.elogistics.domain.member;

import com.ganghee.elogistics.domain.address.Address;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @AfterEach
    public void cleanUp(){
        memberRepository.deleteAll();
    }

    @Test
    public void testMember(){
        String name = "홍길동";
        String email = "example@naver.com";
        Address address = Address.builder().city("서울").detail_addr("강남구").build();

        memberRepository.save(Member.builder().name(name).password("xsd211de").email(email).address(address).build());

        List<Member> memberList = memberRepository.findAll();

        Member member = memberList.get(0);
        assertThat(member.getName()).isEqualTo(name);
        assertThat(member.getEmail()).isEqualTo(email);
        assertThat(member.getAddress().getCity()).isEqualTo(address.getCity());
    }
}
