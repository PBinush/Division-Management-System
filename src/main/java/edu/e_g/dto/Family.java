package edu.e_g.dto;

import edu.e_g.util.IncomeType;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Family {
    private Long familyId;
    private Integer numberOfMembers;
    private IncomeType incomeType;
}
