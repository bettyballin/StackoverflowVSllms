int foo(char *c) {
    // function implementation
}

int main() {
    int (*thud)(void *);

    thud = (int (*)(void *))(foo);
}