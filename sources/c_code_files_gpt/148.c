void main() {
    asm volatile(
        "pushl   %%ebp\n"
        "movl    %%esp, %%ebp\n"
        "subl    $8, %%esp\n"
        "andl    $-16, %%esp\n"
        ::: "memory"
    );
}