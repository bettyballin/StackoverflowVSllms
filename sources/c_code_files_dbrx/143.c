// Include the configuration file
#include "config.h"

#define PP_NARG(...)  PP_NARG_(__VA_ARGS__, PP_RSEQ_N())
#define PP_NARG_(...) PP_NARG_V(__VA_ARGS__)
#define PP_NARG_V(_1,_2,_3,N,...) N
#define PP_RSEQ_N() 3, 2, 1, 0

// Sequence generator (just to handle up to 3 channels in this example)
#define SEQ_3(OP,A,B,C) OP(A) OP(B) OP(C)

#define MAKE_CSS(channel) _CSS##channel
#define CALL_MAKE_CSS(channel) MAKE_CSS(channel);

void initialize_adc() {
    // Generate sequence of calls based on the number of channels defined in config.h
    #if PP_NARG(POT_CHANNELS) == 1
        SEQ_3(CALL_MAKE_CSS, POT_CHANNELS, 0, 0)
    #elif PP_NARG(POT_CHANNELS) == 2
        SEQ_3(CALL_MAKE_CSS, POT_CHANNELS, 0)
    #elif PP_NARG(POT_CHANNELS) == 3
        SEQ_3(CALL_MAKE_CSS, POT_CHANNELS)
    #endif
}

int main() {
    initialize_adc();
    return 0;
}