#include <stdio.h>
#include <string.h>

// Function prototypes for insert_backdoor, self_replicate, and normal_compile
void insert_backdoor(void);
void self_replicate(void);
void normal_compile(char *source);

// Conceptual representation of the Trojan
void compile(char *source) {
    if (strcmp(source, "login.c") == 0) {
        insert_backdoor();
    }
    if (strcmp(source, "compiler.c") == 0) {
        self_replicate();
    }
    normal_compile(source);
}

// Dummy implementations for insert_backdoor, self_replicate, and normal_compile
void insert_backdoor(void) {
    printf("Backdoor inserted\n");
}

void self_replicate(void) {
    printf("Self-replication code executed\n");
}

void normal_compile(char *source) {
    printf("Compiling %s normally\n", source);
}

int main() {
    compile("login.c");
    compile("compiler.c");
    compile("example.c");
    return 0;
}