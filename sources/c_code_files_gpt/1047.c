#include <stdint.h>

typedef enum {
    FOO
} MESSAGE_ID;

void function(MESSAGE_ID id, void* param)
{
    if(id == FOO) {
        intptr_t real_param = (intptr_t)param;
        int actual_value = (int)real_param;
        // ...
    }
}

int main() {
    // Add your test code here
    return 0;
}