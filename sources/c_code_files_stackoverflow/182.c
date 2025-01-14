#include <stdio.h>

// Define a struct to represent a row
typedef struct {
    int curr_readingColumn;
} Row;

// Define a function to check if curr_readingColumn is null
int Iscurr_readingColumnNull(Row row) {
    // Assuming null is represented as -1
    return row.curr_readingColumn == -1;
}

int main() {
    Row row;
    // Initialize row.curr_readingColumn to some value
    row.curr_readingColumn = 10;

    // Define a default value
    int default_value = 0;

    int curr_reading = (Iscurr_readingColumnNull(row)) ? 
                       default_value : row.curr_readingColumn;

    printf("Current reading: %d\n", curr_reading);

    return 0;
}