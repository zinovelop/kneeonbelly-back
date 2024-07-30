package com.kneeonbelly.attendance.member.service

import com.kneeonbelly.attendance.member.entity.Attendance
import com.kneeonbelly.attendance.member.entity.Member
import com.kneeonbelly.attendance.member.repository.AttendanceRepository
import com.kneeonbelly.attendance.member.repository.MemberRepository
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

@Service
class AttendanceService(
    val attendanceRepository: AttendanceRepository,
    val memberRepository: MemberRepository
) {
    fun findAll(): List<Attendance> = attendanceRepository.findAll()

    fun save(param :Map<String, String>): Attendance {

        //파라미터 제대로 들어왔는지 확인
        val number:String = param["number"]?:throw Exception("Number is not exist")
        //번호로 멤버 조회
        val member:Member = memberRepository.findByNumber(number)?:throw Exception("Member not found")
        //오늘 출석 했는지 조화
        val today: LocalDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.MIN)
        if(attendanceRepository.findByMemberAndAttendanceTimeAfter(member, today).isNotEmpty()) {
             throw Exception("This Member is already Attendance")
        }
        //출석 객체 생성 후 찾은 멤버 Insert
        val attendance = Attendance()
        attendance.member = member

        //저장
        return attendanceRepository.save(attendance)
    }

    fun findToday(): List<Attendance> {
        val today: LocalDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.MIN)
        return attendanceRepository.findByAttendanceTimeAfter(today)
    }

//
//    fun findByMember(memberId: Long): List<Attendance>? {
//        //TODO member=null 체크
//        val member = memberRepository.findById(memberId).get()
//        return member.attendance
//    }

}
