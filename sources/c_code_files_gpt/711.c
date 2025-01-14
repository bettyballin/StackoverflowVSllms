#include <stdio.h>
#include <conio.h>

int main() {
    int ch = getch();  // Wait for user input
    if (ch == 'q') {
        // Handle 'q' key press
        printf("You pressed 'q'\n");
    }
    return 0;
}