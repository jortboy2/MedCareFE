package fpt.aptech.projectapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "descriptions", length = 250)
    private String descriptions;
    @ManyToOne(cascade = CascadeType.ALL,targetEntity = Account.class)
    @JoinColumn(name = "account_id")
    private Account account;
    @ManyToOne(cascade = CascadeType.ALL,targetEntity = Doctor.class)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

}