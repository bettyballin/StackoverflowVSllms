#include <stdio.h>
#include <stdlib.h>

typedef struct {
    char* data;
    int len;
} psd_t;

int main() {
    psd_t* psd = malloc(sizeof(psd_t));
    psd->data = "Hello, World!";
    psd->len = 13;

    char* ret = psd->data + psd->len;

    printf("%p\n", ret);

    free(psd);

    return 0;
}