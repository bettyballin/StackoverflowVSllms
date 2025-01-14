#include <stdio.h>

typedef void (*fastcall_func)(int, int);

void __attribute__((regparm(2))) my_fastcall_function(int a, int b) {
    printf("a: %d, b: %d\n", a, b);
}

fastcall_func wrap_fastcall(void (*func)(int, int)) {
    asm volatile (
        "movl %0, %%ecx\n"
        "movl %1, %%edx\n"
        "call *%2\n"
        :
        : "r"(func), "r"(0), "r"(func)
        : "%ecx", "%edx"
    );
    return (fastcall_func)func;
}

int main() {
    fastcall_func my_func = wrap_fastcall(my_fastcall_function);
    my_func(10, 20);
    return 0;
}