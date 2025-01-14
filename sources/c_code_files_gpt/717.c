#include <Judy.h>
#include <stdio.h>

int main() {
    Pvoid_t judyArray = (Pvoid_t)NULL; // Initialize Judy array pointer
    Word_t index;
    int Rc_int;

    // Add elements to the Judy array
    index = 0x12345678;
    J1S(Rc_int, judyArray, index);

    index = 0x87654321;
    J1S(Rc_int, judyArray, index);

    // Check for membership
    index = 0x12345678;
    J1T(Rc_int, judyArray, index);
    if (Rc_int) {
        printf("0x12345678 is in the set\n");
    } else {
        printf("0x12345678 is not in the set\n");
    }

    // Remove an element
    index = 0x12345678;
    J1U(Rc_int, judyArray, index);

    // Free the Judy array
    Word_t bytes_freed;
    J1FA(bytes_freed, judyArray);

    return 0;
}