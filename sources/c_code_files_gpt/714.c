#include <stdio.h>

int main() {
    char filename[20];
    FILE *fp;
    for (int i = 1; i <= 77; ++i) {
        snprintf(filename, sizeof(filename), "file%d", i);
        fp = fopen(filename, "w");
        if (fp != NULL) {
            fputs(filename, fp);
            fclose(fp);
        }
    }
    return 0;
}