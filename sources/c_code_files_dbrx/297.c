#include <unistd.h>

int main(void) {
    char *args[] = { "echo", "hello, world!", NULL }; // the last one must be a null pointer
   execvp("echo", args);  // replace this process with echo program and pass "hello, world!" as arg
}