package edu.njnu.his.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Drug {

    private String id;
    private String drugCode;
    private Double price;
    private String drugName;
    private String unit;

}
