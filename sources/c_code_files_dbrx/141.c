#include <stdio.h>

#define CHANNEL(x) printf("%d\n", x)

#define POT_CHANNELS \
    CHANNEL(27)      \
    CHANNEL(29)

int main() {
    POT_CHANNELS
    return 0;
}