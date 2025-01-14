package com.example.model;

import java.lang.String;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class Employee_2 {
    private Long empId;
    private String name;
    private BigDecimal salary;

    // Getters and Setters...

    public static void main(String[] args) {
    }
}