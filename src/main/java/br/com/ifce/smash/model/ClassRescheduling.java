package br.com.ifce.smash.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "class_rescheduling")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClassRescheduling {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_rescheduling_id")
    private Long id;

    private Lesson lesson;

    private Court court;

    private Student student;
}
