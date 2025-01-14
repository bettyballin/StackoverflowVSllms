#include <iostream>

class ClassA {
public:
    ClassA() {}
};

class ClassB {
public:
    ClassB() {}
};

void assignObject(ClassA*& pa, ClassB*& pb)
{
    pa = new ClassA;
    pb = new ClassB;
}

int main() {
    ClassA* pa = NULL;
    ClassB* pb = NULL;
    assignObject(pa, pb); // both will be assigned as expected.

    // Don't forget to delete dynamically allocated memory
    delete pa;
    delete pb;

    return 0;
}