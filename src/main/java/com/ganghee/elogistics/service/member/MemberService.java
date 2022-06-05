package com.ganghee.elogistics.service.member;

import com.ganghee.elogistics.domain.member.MemberRepository;
import com.ganghee.elogistics.dto.member.MemberSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public Long resist(MemberSaveDto memberSaveDto){
        if(memberRepository.findByEmail(memberSaveDto.getEmail()) == null){
            return memberRepository.save(memberSaveDto.toEntity()).getId();
        }
        else return 0L;
    }
}
