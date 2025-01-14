#include <stdio.h>

// Version 1 of the struct
struct MyStructV1 {
    int field1;
    double field2;
};

// Version 2 of the struct
struct MyStructV2 {
    int field1;
    double field2;
    char extraField[256];  // new member added in version 2
};

// Union to handle different versions
union MyStruct {
    struct MyStructV1 v1;
    struct MyStructV2 v2;
};

// Function to handle different versions
void processStruct(union MyStruct* data, int version) {
    if (version == 1) {
        // Process using MyStructV1
        printf("Version 1: field1 = %d, field2 = %f\n", data->v1.field1, data->v1.field2);
    } else if (version == 2) {
        // Process using MyStructV2
        printf("Version 2: field1 = %d, field2 = %f, extraField = %s\n", data->v2.field1, data->v2.field2, data->v2.extraField);
    } else {
        // Handle unknown version
        printf("Unknown version\n");
    }
}

int main() {
    union MyStruct data;
    data.v1.field1 = 10;
    data.v1.field2 = 20.5;
    processStruct(&data, 1);

    data.v2.field1 = 30;
    data.v2.field2 = 40.5;
    strcpy(data.v2.extraField, "Hello, World!");
    processStruct(&data, 2);

    return 0;
}