#include <stdint.h>

struct FooBar {
    uint32_t field_1;
    uint32_t field_2;
    //...
};

struct FooBar foobar __attribute__((section(".my_foobar")));

int main() {
    // Example usage of the foobar struct
    foobar.field_1 = 1;
    foobar.field_2 = 2;
    return 0;
}