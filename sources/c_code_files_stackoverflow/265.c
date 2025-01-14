#include <stdio.h>

// Define the structure for prm
typedef struct {
    int field1;
    int field2;
    int field3;
} Prm;

int main() {
    // Declare an instance of Prm and initialize its fields
    Prm prm = {1, 2, 3}; // Example initialization
    
    // Declare the array
    int prm_arr[3];
    
    // Assign values from prm to prm_arr
    prm_arr[0] = prm.field1;
    prm_arr[1] = prm.field2;
    prm_arr[2] = prm.field3;
    
    // Optionally, print the values to verify
    printf("prm_arr[0] = %d\n", prm_arr[0]);
    printf("prm_arr[1] = %d\n", prm_arr[1]);
    printf("prm_arr[2] = %d\n", prm_arr[2]);
    
    return 0;
}