package com.kneeonbelly.attendance.member.repository

import com.kneeonbelly.attendance.member.entity.Attendance
import com.kneeonbelly.attendance.member.entity.Member
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDateTime

interface AttendanceRepository: JpaRepository<Attendance, Long> {

    //특정 날짜 이후로 조회
    fun findByAttendanceTimeAfter(todayTime: LocalDateTime):List<Attendance>

    //오늘 출석 했는지 조회
    fun findByMemberAndAttendanceTimeAfter(member: Member, todayTime: LocalDateTime): List<Attendance>
}