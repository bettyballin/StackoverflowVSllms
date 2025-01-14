#include <stdio.h>

// Define a structure to represent a name
typedef struct {
    char LastName[100];
    char FirstName[100];
} Name;

int compareNames(Name n1, Name n2)
{
    if (strcmp(n1.LastName, n2.LastName) < 0) {
        return -1;
    } else if (strcmp(n1.LastName, n2.LastName) > 0) {
        return 1;
    } else if (strcmp(n1.FirstName, n2.FirstName) < 0) {
        return -1;
    } else if (strcmp(n1.FirstName, n2.FirstName) > 0) {
        return 1;
    } else {
        return 0;
    }
}

int main() {
    Name name1 = {"Doe", "John"};
    Name name2 = {"Doe", "Jane"};

    int result = compareNames(name1, name2);
    printf("Comparison result: %d\n", result);

    return 0;
}