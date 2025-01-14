#include <stdio.h>
#include <stdlib.h>

// Define a structure to simulate a base class
typedef struct Base {
    void (*B)(void); // Function pointer to mimic a method
} Base;

// A simple implementation for the Base "class" method B
void baseMethodB() {
    printf("Base method B called\n");
}

// Function to create a new Base object
Base* newBase() {
    Base* base = malloc(sizeof(Base));
    base->B = baseMethodB; // Assign the method to the function pointer
    return base;
}

// Define a structure for a derived class
typedef struct Derived {
    Base base; // Composition to simulate inheritance
    // Additional fields or methods specific to Derived can be added here
} Derived;

// Function to create a new Derived object
Derived* newDerived() {
    Derived* derived = malloc(sizeof(Derived));
    // Initialize the Base part of Derived
    derived->base = *newBase();
    return derived;
}

// Simulate the getTheDerived function
Base* getTheDerived() {
    Derived* derived = newDerived();
    // Cast Derived to Base
    return (Base*)derived;
}

int main() {
    Base* b = getTheDerived();
    b->B(); // Call the method on the base class
    free(b); // Don't forget to free the memory to prevent leaks
    return 0;
}