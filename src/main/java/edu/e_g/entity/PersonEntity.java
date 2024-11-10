package edu.e_g.entity;

import edu.e_g.util.GenderType;
import edu.e_g.util.IsActiveType;
import edu.e_g.util.RelationshipType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="people")
public class PersonEntity {
    @Id
    private String nic;
    private String firstName;
    private String lastName;
    private String address;

    @Enumerated(EnumType.STRING)
    private GenderType gender;

    @Enumerated(EnumType.STRING)
    private RelationshipType relationship;

    private String email;
    private String phoneNumber;
    private Date dob;
    private String occupation;
    private Double salary;
    private String familyId;
    private IsActiveType isActive;
}

