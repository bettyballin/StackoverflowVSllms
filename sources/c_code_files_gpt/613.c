#include <stdio.h>

void arryprnt(int arr[], char *msg, int size) {
    printf("%s", msg);
    for (int i = 0; i < size; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}

int main() {
    int jimmy[15]; // Initialize the array as needed
    for (int i = 0; i < 15; i++) {
        jimmy[i] = i; // Example initialization
    }
    arryprnt(jimmy, "PSEUDOJIMMY: ", 15);
    return 0;
}