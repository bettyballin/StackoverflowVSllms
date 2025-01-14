package com.example;

import java.lang.String;

public class AscDirectionSetter {
    public static void main(String[] args) {
        Request request = new Request();
        request.setAttribute("ascDirection", Direction.ASC);
    }
}

class Request {
    public void setAttribute(String name, Object value) {
        // dummy implementation
    }
}

class Direction {
    public static final Direction ASC = new Direction();
    // other code
}