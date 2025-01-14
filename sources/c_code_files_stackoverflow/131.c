#include <iostream>

// This is actually C++ code, not C. It will not compile with a C compiler like gcc.
// However, it can be compiled with a C++ compiler like g++.

class Object {
public:
    virtual int compare(const Object& ) = 0;
    float volume;
};

class Animal : public Object { // Add 'public' access specifier
public:
    virtual int compare(const Object& );
    float age;
};

class Zebra  : public Animal { // Add 'public' access specifier
public:
    int compare(const Object& );
};

int Animal::compare(const Object& obj) { // Provide an implementation for the pure virtual function
    // Add your comparison logic here
    return 0;
}

int Zebra::compare(const Object& obj) { // Provide an implementation for the pure virtual function
    // Add your comparison logic here
    return 0;
}

int main() {
    // Create an instance of Zebra to test the code
    Zebra zebra;
    return 0;
}