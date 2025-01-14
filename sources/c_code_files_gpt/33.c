#define PROJ_SZ 6
#define REF_SZ  9
#define DESC_SZ 22
#define TRAN_AMT_MAX  9999999999e0
#define BATCH_AMT_MAX 9999999999e0
#define BATCH_JV_CSH_MAX 99999999999e0
#define BATCH_CNT_MAX 99999

#include <stdio.h>

int main() {
    printf("Project size: %d\n", PROJ_SZ);
    printf("Reference size: %d\n", REF_SZ);
    printf("Description size: %d\n", DESC_SZ);
    printf("Transaction amount max: %f\n", TRAN_AMT_MAX);
    printf("Batch amount max: %f\n", BATCH_AMT_MAX);
    printf("Batch JV cash max: %f\n", BATCH_JV_CSH_MAX);
    printf("Batch count max: %d\n", BATCH_CNT_MAX);
    return 0;
}