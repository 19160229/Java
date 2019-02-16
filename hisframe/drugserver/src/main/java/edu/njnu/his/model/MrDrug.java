package edu.njnu.his.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "mr_drug")
public class MrDrug {

    @Id
    @GeneratedValue(generator = "uuid_generator")
    @GenericGenerator(name = "uuid_generator", strategy = "uuid")
    private String id;
    //private String drugId;
    private String mrId;
    private Integer amount;

    @OneToOne
    @JoinColumn(name = "drugId",referencedColumnName = "id")
    private Drug drug;

}
