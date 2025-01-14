#include <stdio.h>

typedef struct {
    int field1;
    int field2;
    int field3;
} Param;

int detect_prm(Param prm) {
    int prm_arr[3];

    prm_arr[0] = prm.field1;
    prm_arr[1] = prm.field2;
    prm_arr[2] = prm.field3;

    return 0;
}

int main() {
    Param prm;
    prm.field1 = 1;
    prm.field2 = 2;
    prm.field3 = 3;

    int result = detect_prm(prm);

    return 0;
}