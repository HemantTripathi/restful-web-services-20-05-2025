package com.springboot.mangodb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data //Generates getters, setters, toString(), equals(), and hashCode()
@NoArgsConstructor //Generates a no-argument constructor
@AllArgsConstructor //Generates a constructor with all fields
@Document(collection  = "students")
public class Student {
    private int id;
    private String name;
    private String city;
    private String college;
    /*
     * We have used projectlombok in order to eliminate unnecessary extra codings for getter setter etc.
     */

}
