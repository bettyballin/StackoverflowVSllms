#include <stdio.h>

int main() {
    int condition = 1;  // Initialize condition to true
    while (condition) {
        // You should update the condition here to avoid an infinite loop
        condition = 0;  // Set condition to false to exit the loop
    }
    return 0;
}