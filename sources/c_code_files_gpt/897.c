#include <stdint.h>

void hammer_memory(volatile uint64_t *addr1, volatile uint64_t *addr2) {
    for (int i = 0; i < 1000000; i++) {
        *addr1;
        *addr2;
    }
}

int main() {
    volatile uint64_t addr1 = 0;
    volatile uint64_t addr2 = 0;
    hammer_memory(&addr1, &addr2);
    return 0;
}