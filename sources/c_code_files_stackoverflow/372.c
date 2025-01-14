#include <stdio.h>
#include <time.h>

int main(int argc, const char* argv[]) {
    const int max = 1000000;
    const char* teststr = "example";

    int start = time(0);
    FILE* file = fopen("example1", "w");
    for (int i = 0; i < max; i++) {
        fprintf(file, "%s:%d\n", teststr, i);
    }
    fclose(file);
    int end = time(0);

    printf("C FILE: %ds\n", end - start);

    return 0;
}