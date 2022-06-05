package com.ganghee.elogistics.domain.member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

     public Optional<Member> findByEmail(String email);
}
