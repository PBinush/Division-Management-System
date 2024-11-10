package edu.e_g.dto;

import edu.e_g.util.GenderType;
import edu.e_g.util.RelationshipType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person {
    private String id;
    private String firstName;
    private String lastName;
    private String address;
    private GenderType gender;
    private RelationshipType relationship;
    private String email;
    private String phoneNumber;
    private Date dob;
    private String occupation;
    private Double salary;
    private String familyId;
}
