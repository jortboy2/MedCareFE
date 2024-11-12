package fpt.aptech.projectapi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "Appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id", nullable = false)
    private Integer id;

    @ManyToOne(targetEntity = Patient.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne(targetEntity = Doctor.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @Column(name = "\"date\"")
    private LocalDate date;

    @Column(name = "\"time\"")
    private LocalTime time;

    @Size(max = 50)
    @Column(name = "type", length = 50)
    private String type;

    @Size(max = 20)
    @Column(name = "status", length = 20)
    private String status;

    @Column(name = "amount", precision = 15, scale = 2)
    private BigDecimal amount;

}