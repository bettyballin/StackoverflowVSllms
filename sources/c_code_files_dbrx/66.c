#include <stdio.h>
#include <stdint.h>

// Assuming vxProfilerDefs.h contains the following definitions
#define VX_PROFILER_STATE_START 0x00000001
#define VX_PROFILER_NUMERIC     0x00000002

// Define a custom profiling function
void VX_PROFILE(vx_uint32 type, ...) {
    va_list args;
    va_start(args, type);

    if (type == VX_PROFILER_STATE_START) {
        const char* funcName = va_arg(args, const char*);
        printf("Entering function: %s\n", funcName);
    } else if (type == VX_PROFILER_NUMERIC) {
        // Assuming vx_profiler_var1 and var2 are numeric variables
        vx_uint32 var1 = va_arg(args, vx_uint32);
        vx_uint32 var2 = va_arg(args, vx_uint32);
        printf("Recording data points: %u, %u\n", var1, var2);
    }

    va_end(args);
}

typedef uint32_t vx_uint32;

int main() {
    /* Entry Event */
    vx_uint32 stateEntry = VX_PROFILER_STATE_START;
    VX_PROFILE(stateEntry, "myFunctionName");

    /* Exit event or to record other data points*/
    vx_uint32 vx_profiler_var1 = 10;
    vx_uint32 var2 = 20;
    VX_PROFILE(VX_PROFILER_NUMERIC, vx_profiler_var1, var2);

    return 0;
}