package com.example.myapp;
import java.lang.String;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "someRootElement")
public class SomeRootElement {

    // Element in default namespace (urn:my:ns1)
    private SomeElement element;
    
    // Element in namespace urn:my:ns2
    @XmlElement(name = "someElement", namespace = "urn:my:ns2")
    private SomeElement aElement;

    // Element in namespace urn:my:ns3
    @XmlElement(name = "someElement", namespace = "urn:my:ns3")
    private SomeElement bElement;
    
    // Getters and setters...
}

@XmlType(namespace = "urn:my:ns1") // Default namespace
class SomeElement {
    // Element fields, getters, and setters...

    public static void main(String[] args) {
    }
}