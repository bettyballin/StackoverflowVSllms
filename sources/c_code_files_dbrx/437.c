#include <stdint.h>
#include <stdlib.h>

// Assuming EBU_R128 library is included
#include "ebur128.h"

int main() {
    /* Initializations to run once before processing. */
    int32_t ret = 0;
    EBU_R128_Init(&ret); /* EBU R128 library initialization error code will be stored here */
    struct ebur128 state;
    float peak_rms = 0.f, loudness_range = 0.f;
    const float *pPeakLoudness = NULL, *PProgramLoudness = NULL;
    int64_t pnum_samples       = 0LLU; /* total number of samples */

    // Assuming audioBuffer and sampleRate are defined elsewhere
    float* audioBuffer = (float*) malloc(sampleRate * sizeof(float));
    int sampleRate = 44100;

    state = EBU_R128_Calc(audioBuffer, sampleRate);           /* Calculate loudness */
    loudness_range             = EBU_R128_loudness_range(&state);   /* Loudness range calculated from analysis*/
    peak_rms                    = state->true_peak;  /* Max peak amplitude */
    EBU_R128_Done(&ret);       /* Must call EBU_R128_End at the end to free resources. */

    free(audioBuffer);
    return 0;
}