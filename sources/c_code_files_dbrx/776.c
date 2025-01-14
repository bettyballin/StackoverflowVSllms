#include <setjmp.h>
#include <stdlib.h>

typedef struct Continuation {
    jmp_buf buf;
} Continuation;

Continuation *new_continuation(void) {
    Continuation *con = malloc(sizeof(Continuation));
    if (!setjmp(con->buf)) {
        return con;
    } else {
        // Free the continuation when it's no longer needed
        free(con);
        return NULL;
    }
}

void jump_to(Continuation *con) {
    longjmp(con->buf, 1);
}

int main() {
    Continuation *con = new_continuation();
    if (con) {
        jump_to(con);
    }
    return 0;
}