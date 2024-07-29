package com.kneeonbelly.attendance.member.service

import com.kneeonbelly.attendance.member.entity.Attendance
import com.kneeonbelly.attendance.member.entity.Member
import com.kneeonbelly.attendance.member.repository.AttendanceRepository
import com.kneeonbelly.attendance.member.repository.MemberRepository
import org.springframework.stereotype.Service

@Service
class AttendanceService(
    val attendanceRepository: AttendanceRepository,
    val memberRepository: MemberRepository
) {
    fun findAll(): List<Attendance> = attendanceRepository.findAll()

    fun save(param :Map<String, String>): Attendance {

        val number:String = param["number"]?:throw Exception("Number is not exist")
        //TODO member=null 체크
        val member:Member = memberRepository.findByNumber(number)?:throw Exception("Member not found")

        val attendance = Attendance()
        attendance.member = member

        return attendanceRepository.save(attendance)
    }
//
//    fun findByMember(memberId: Long): List<Attendance>? {
//        //TODO member=null 체크
//        val member = memberRepository.findById(memberId).get()
//        return member.attendance
//    }

}
