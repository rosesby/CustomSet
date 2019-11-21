package com.mcc.model;

import java.time.LocalDate;

public class Student extends Person{

    private String ControlNumber;
    public Student(String firstName, String lastName, Sex sex, LocalDate birthDate, int controlNumber) {
        super(firstName, lastName, sex, birthDate);
        ControlNumber = "S" + controlNumber;
    }
}
