#include <linux/jiffies.h>

#define MAX_TIMESTAMPS 100
unsigned long timestamps[MAX_TIMESTAMPS];
int count = 0;

void log_timestamp(void) {
    if (count < MAX_TIMESTAMPS) {
        timestamps[count++] = jiffies;  // Use jiffies or another appropriate timer
    }
}

// Example usage in Kernel code
void some_kernel_stage_function(void) {
    log_timestamp();
    // ... existing code ...
}

// Add a main function to make it executable
int main() {
    some_kernel_stage_function();
    return 0;
}