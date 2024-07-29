package com.kneeonbelly.attendance.member.repository

import com.kneeonbelly.attendance.member.entity.Attendance
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDateTime

interface AttendanceRepository: JpaRepository<Attendance, Long> {

    //특정 날짜 이후로 조회
    fun findByAttendanceTimeAfter(attendanceTime: LocalDateTime):List<Attendance>
}