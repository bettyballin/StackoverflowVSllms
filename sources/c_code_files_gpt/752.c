#include <stdio.h>
#include <string.h>

// Declare the functions
void player1();
void player2();

// Define a struct to map function names to function pointers
typedef struct {
    char *name;
    void (*func)();
} FunctionMap;

// Define the functions
void player1() {
    printf("Player 1's function called.\n");
}

void player2() {
    printf("Player 2's function called.\n");
}

// Create an array of FunctionMap
FunctionMap function_map[] = {
    {"player1", player1},
    {"player2", player2},
    {NULL, NULL} // Sentinel to mark the end of the array
};

// Function to call a function by name
void call_function_by_name(const char *name) {
    for (int i = 0; function_map[i].name != NULL; i++) {
        if (strcmp(function_map[i].name, name) == 0) {
            function_map[i].func();
            return;
        }
    }
    printf("Function %s not found.\n", name);
}

int main() {
    char player1_name[100], player2_name[100];

    printf("Enter the name of the first player's function: ");
    scanf("%99s", player1_name);
    printf("Enter the name of the second player's function: ");
    scanf("%99s", player2_name);

    printf("Calling functions...\n");
    call_function_by_name(player1_name);
    call_function_by_name(player2_name);

    return 0;
}