package com.yourpackage;

import org.reflections.Reflections;
import java.util.Set;

public class ImplementationFinder {
    public static void main(String[] args) {
        // Create a new Reflections instance targeting your package
        Reflections reflections = new Reflections("com.yourpackage");

        // Specify the interface you are interested in
        Set<Class<? extends SomeInterface>> subTypes = 
            reflections.getSubTypesOf(SomeInterface.class);

        for (Class<?> cls : subTypes) {
            System.out.println(cls.getName());
        }
    }
}

interface SomeInterface {
    // Empty interface
}