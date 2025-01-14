#include <stdbool.h>

bool test_and_set(bool *target) {
    bool originalValue = *target;
    *target = true; // Set the value to 'true', regardless of what it was before
    return originalValue;  // Return the value that was there before we set it.
}

int main() {
    bool target = false;
    bool result = test_and_set(&target);
    return 0;
}