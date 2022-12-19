package br.com.ifce.smash.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student extends Person{

    @Column(name = "student_registration")
    private String registration;

    @Column(name = "student_paid_tuition")
    private boolean paidTuition;

    private Class studentClass;

}
