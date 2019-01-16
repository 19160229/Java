package edu.njnu.helloboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String id; //主键
    private String username;
    private String password;
    private String gender;
    private Integer age;

}
