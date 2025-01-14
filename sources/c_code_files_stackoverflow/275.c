#include <stdio.h>

void foo(float f[static 4])
{
    printf("Inside foo function\n");
    for (int i = 0; i < 4; i++) {
        printf("%f ", f[i]);
    }
    printf("\n");
}

int main(void)
{
    foo((float[4]){1.0f, 2.0f, 3.0f, 4.0f});  // OK
    foo((float[5]){1.0f, 2.0f, 3.0f, 4.0f, 5.0f});  // also OK, fifth element is ignored
    // foo((float[3]){1.0f, 2.0f, 3.0f});  // error, although the GCC doesn't complain
    return 0;
}