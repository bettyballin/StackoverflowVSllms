#include <stdio.h>

static void print_matrix() {
    // Function implementation
    printf("Matrix printed\n");
}

void public_function() {
    print_matrix(); // This is allowed because print_matrix is within the same file
}

int main() {
    public_function();
    return 0;
}