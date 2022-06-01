package com.nighthawk.SQL;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;
@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity

public class student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int studentID;
    private String name;
    private int grade;
    public student(int studentID, int grade, String name){
        this.studentID=studentID;
        this.grade=grade;
        this.name=name;
    }



}
