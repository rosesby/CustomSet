package com.mcc.model;

import java.awt.font.GraphicAttribute;
import java.time.LocalDate;

public class Teacher extends Person{

    private Grade grade;
    private String ControlNumber;
    public Teacher(String firstName, String lastName, Sex sex, LocalDate birthDate, int controlNumber, Grade grade) {
        super(firstName, lastName, sex, birthDate);
        ControlNumber = "M" + controlNumber;
        this.grade = grade;
    }
}
