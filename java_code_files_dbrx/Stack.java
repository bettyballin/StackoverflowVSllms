package com.mycompany;

public final class Stack {
    // Public API surface.
    public void push(Object item) { /** ... */ }

    public Object pop() throws Exception { /* ... */ return null; }

    // Internal details, accessible to tests due to package-private modifier.
    int dataCursor;  // Just an example.
}