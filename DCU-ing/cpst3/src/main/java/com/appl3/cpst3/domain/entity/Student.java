package com.appl3.cpst3.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //아이디
    private String studentCode; // 학생 코드 (PK, FK)
    private String passwd; //패스워드
    private String name; // 학생 이름
    private String major; // 주전공
    private String doubleMajor; // 이중 전공
    private int grade; // 학년
    private int term; // 학기
    private int numCourses; // 수강한 과목 수
    private boolean preGradu; // 졸업 전 현황
    private boolean excellent; // 성적우수
    private int DCUcoin;
   

    // 생성자, 게터, 세터 등
}
