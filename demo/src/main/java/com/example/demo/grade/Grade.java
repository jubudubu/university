package com.example.demo.grade;

import com.example.demo.course.Course;
import com.example.demo.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Grade {
    @Id
    private Long id;
    @OneToOne
    @JoinColumn(name = "courseId", referencedColumnName = "courseId")
    private Course course;
    @OneToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;

}
