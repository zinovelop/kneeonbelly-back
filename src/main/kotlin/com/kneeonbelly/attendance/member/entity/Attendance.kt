package com.kneeonbelly.attendance.member.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
class Attendance{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long = 0

    @ManyToOne
    var member: Member? = null

    val attendanceTime: LocalDateTime = LocalDateTime.now()
}
