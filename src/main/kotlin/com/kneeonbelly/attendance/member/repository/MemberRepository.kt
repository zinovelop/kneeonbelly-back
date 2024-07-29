package com.kneeonbelly.attendance.member.repository

import com.kneeonbelly.attendance.member.entity.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository: JpaRepository<Member, Long> {
    fun findByNumber(number:String):Member?
}