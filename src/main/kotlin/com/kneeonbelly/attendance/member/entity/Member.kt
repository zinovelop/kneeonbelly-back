package com.kneeonbelly.attendance.member.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
class Member(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    val name: String,
    val number: String,
    var phoneNumber: String,
    var belt: String,
    var grau: Int,
    var description: String

    // 단방향관계
    // 멤버객체에서 굳이 출석 객체를 불러 올 필요가 없다..?
    // 필요할때 추가하기
//    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
//    @JsonIgnore
//    var attendance: List<Attendance>?
)

//enum class Grade {
//    WHITE,
//    BLUE,
//    PURPLE,
//    BROWN,
//    BLACK
//}