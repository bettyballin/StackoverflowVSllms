#include <stdio.h>

// config.h
#define NUMBER_OF_POTS  2
extern int pots[];

// config.c
int pots[NUMBER_OF_POTS] = {
    27,
    29
};

// adc.c
void CALL_MAKE_CSS(int pot); // forward declaration

void initialize_adc() {
    for (int i = 0; i < NUMBER_OF_POTS; i++) {
        CALL_MAKE_CSS(pots[i]);
    }
}

// Define a dummy implementation for CALL_MAKE_CSS
void CALL_MAKE_CSS(int pot) {
    printf("Initializing pot %d\n", pot);
}

int main() {
    initialize_adc();
    return 0;
}