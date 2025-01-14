#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>

// Define BATCH_JV_CSH_MAX for demonstration
#define BATCH_JV_CSH_MAX 1000000.0

// Define FALSE for demonstration
#define FALSE 0

// Define a structure for in_batch_sum
typedef struct {
    char batch_debit_amt[12]; // Enough to hold "011.0f" format + null terminator
} batch_sum_t;

batch_sum_t in_batch_sum;

// Mock function for get_tot_amt1
double get_tot_amt1() {
    // Example return value
    return 1000001.0;
}

int main() {
    if (fabs(get_tot_amt1()) > BATCH_JV_CSH_MAX) {
        fprintf(stderr, "*** Error: Transaction debit amount overflow\n");
        fprintf(stderr, "***        Maximum expected: %.0f\n", BATCH_JV_CSH_MAX);
        return FALSE;
    }

    sprintf(in_batch_sum.batch_debit_amt, "%011.0f", get_tot_amt1());

    // Print the result to verify
    printf("Batch Debit Amount: %s\n", in_batch_sum.batch_debit_amt);

    return 0; // Successful execution
}