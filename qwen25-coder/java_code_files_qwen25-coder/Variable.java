package com.example.model;

public class Variable {
    private String name;
    private Object value;

    public Variable(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    // Getters and other methods...
    public String getName() { return name; }
    public Object getValue() { return value; }

    public static void main(String[] args) {
    }
}