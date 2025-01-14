#include <stdio.h>

// Define a structure for demonstration
typedef struct {
    int Item;
} GlobalStruct;

// Define the macros
#define STRUCTMEMBER(structName, memberName, value) do { \
    structName.memberName = value; \
} while(0)

#define STRUCTMEMBER_PTR(structPtr, memberName, value) do { \
    structPtr->memberName = value; \
} while(0)

int main() {
    GlobalStruct GlobalStructInstance;
    GlobalStruct *GlobalStructInstancePtr = &GlobalStructInstance;

    STRUCTMEMBER(GlobalStructInstance, Item, 1);
    STRUCTMEMBER_PTR(GlobalStructInstancePtr, Item, 2);

    printf("GlobalStructInstance.Item = %d\n", GlobalStructInstance.Item);
    printf("GlobalStructInstancePtr->Item = %d\n", GlobalStructInstancePtr->Item);

    return 0;
}