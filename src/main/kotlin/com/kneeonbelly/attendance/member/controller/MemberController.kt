package com.kneeonbelly.attendance.member.controller

import com.kneeonbelly.attendance.member.entity.Attendance
import com.kneeonbelly.attendance.member.entity.Member
import com.kneeonbelly.attendance.member.service.AttendanceService
import com.kneeonbelly.attendance.member.service.MemberService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MemberController(
    val memberService: MemberService,
    val attendanceService: AttendanceService
) {
    /* 멤버 */
    //전체 멤버 조회
    @GetMapping("/members")
    fun getAllMembers(): List<Member> = memberService.findAll()
    //특정 멤버 조회
    @GetMapping("/members/{id}")
    fun getMemberById(@PathVariable id:Long) = memberService.findById(id)
    //멤버 등록
    @PostMapping("/members")
    fun saveMember(@RequestBody member: Member) = memberService.save(member)


    /* 출석 */
    //출석 전체
    @GetMapping("/attendances")
    fun getAllAttendances():List<Attendance> = attendanceService.findAll()

    //멤버 출석 리스트
//    @GetMapping("/members/{member_id}/attendances")
//    fun getAttendancesById(@PathVariable member_id: Long):List<Attendance>? = attendanceService.findByMember(member_id)

    //출석하기
    @PostMapping("/attendances")
    fun saveAttendance(@RequestBody param :Map<String, String>) = attendanceService.save(param)

}