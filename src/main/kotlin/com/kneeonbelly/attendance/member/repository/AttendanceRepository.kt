package com.kneeonbelly.attendance.member.repository

import com.kneeonbelly.attendance.member.entity.Attendance
import org.springframework.data.jpa.repository.JpaRepository

interface AttendanceRepository: JpaRepository<Attendance, Long> {
}