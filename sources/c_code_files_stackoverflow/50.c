#include <stdio.h>
#include <stdlib.h>

struct Person {
    char* name;
    int age;
    int heightInInches;
};

int main() {
    // Create a new Person
    struct Person person;

    // Initialize fields
    person.name = "John Doe";
    person.age = 30;
    person.heightInInches = 72;

    // Print out the information
    printf("Name: %s\n", person.name);
    printf("Age: %d years\n", person.age);
    printf("Height: %d inches\n", person.heightInInches);

    return 0;
}