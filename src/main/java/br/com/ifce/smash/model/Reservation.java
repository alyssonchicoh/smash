package br.com.ifce.smash.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "reservation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private Long id;

    @Column(name = "reservation_request_date")
    private Date requestDate;

    @Column(name = "reservation_date")
    private Date date;

    @Column(name = "reservation_payment_status")
    private String paymentStatus;

    @Column(name = "reservation_note")
    private String note;

    private Court court;

    private Person requester;

    @Column(name = "reservation_number")
    private String number;

    private Set<Person> persons;

}
