package com.kneeonbelly.attendance.member.service

import com.kneeonbelly.attendance.member.entity.Member
import com.kneeonbelly.attendance.member.repository.MemberRepository
import org.springframework.stereotype.Service

@Service
class MemberService(
    val memberRepository: MemberRepository
) {
    fun findAll(): List<Member> = memberRepository.findAll();

    fun findById(id: Long): Member? = memberRepository.findById(id).orElse(null)

    fun save(member: Member): Member {
        return memberRepository.save(member);
    }
}