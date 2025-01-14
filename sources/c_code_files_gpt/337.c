// adc.c
#include <stdio.h>

// Assuming config.h contains the following definitions
#define POTS_CHANNELS {1, 2} // Replace with actual values

#define CONCATENATE(arg1, arg2)   arg1##arg2
#define MAKE_CSS(channel)         CONCATENATE(_CSS, channel)
#define CALL_MAKE_CSS(channel)    printf("Initializing CSS for channel %d...\n", channel)

// Helper macros to create sequence of calls
#define CALL_MAKE_CSS_1(pot)      CALL_MAKE_CSS(pot)
#define CALL_MAKE_CSS_2(pot1, pot2) CALL_MAKE_CSS(pot1); CALL_MAKE_CSS(pot2)
#define CALL_MAKE_CSS_3(pot1, pot2, pot3) CALL_MAKE_CSS(pot1); CALL_MAKE_CSS(pot2); CALL_MAKE_CSS(pot3)
// Add more if needed

// Select appropriate macro based on the number of pots
#define SELECT_CALL_MAKE_CSS(_1, _2, _3, NAME, ...) NAME
#define CALL_MAKE_CSS_FOR_POTS(...) SELECT_CALL_MAKE_CSS(__VA_ARGS__, CALL_MAKE_CSS_3, CALL_MAKE_CSS_2, CALL_MAKE_CSS_1)(__VA_ARGS__)

void initialize_adc() {
    int pots_channels[] = POTS_CHANNELS;
    CALL_MAKE_CSS_FOR_POTS(pots_channels[0], pots_channels[1]);
}

int main() {
    initialize_adc();
    return 0;
}