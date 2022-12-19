package br.com.ifce.smash.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "lesson_student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LessonStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lesson_student_id")
    private Long id;

    private Lesson lesson;

    private Student student;

    private boolean present;
}
