#include <stdio.h>

enum some_enum { NODE = 0, REAL };

typedef struct {
    // Add any other struct members here as needed
    int some_other_member; // Example member
    enum some_enum type;
} some_struct;

int main() {
    // Create an instance of some_struct
    some_struct my_struct;
    
    // Initialize or set values to struct members
    my_struct.some_other_member = 10;
    my_struct.type = REAL;
    
    // Example print to verify the values
    printf("some_other_member: %d\n", my_struct.some_other_member);
    printf("type: %d\n", my_struct.type);
    
    return 0;
}