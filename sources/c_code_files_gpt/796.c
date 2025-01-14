#include <stdio.h>

// Define the Param struct to hold the fields
typedef struct {
    int field1;
    int field2;
    int field3;
} Param;

int detect_prm(Param prm) {
    int prm_arr[3]; // Define the array with a fixed size
    prm_arr[0] = prm.field1; // Assign values to the array elements
    prm_arr[1] = prm.field2;
    prm_arr[2] = prm.field3;

    return 0;
}

int main() {
    // Create a Param object to test the detect_prm function
    Param test_prm;
    test_prm.field1 = 1;
    test_prm.field2 = 2;
    test_prm.field3 = 3;

    // Call the detect_prm function
    detect_prm(test_prm);

    return 0;
}