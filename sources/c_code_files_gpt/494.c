#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef enum {
    FIELD_NAME1,
    FIELD_NAME2,
    FIELD_NAME3,
    FIELD_COUNT // Keep this last to count number of fields
} FieldName;

typedef struct {
    FieldName field;
    int value;
} KeyValuePair;

typedef struct {
    KeyValuePair *pairs;
    size_t count;
} UpdateData;

void update(UpdateData *data) {
    for (size_t i = 0; i < data->count; ++i) {
        switch (data->pairs[i].field) {
            case FIELD_NAME1:
                // Update FIELD_NAME1 with data->pairs[i].value
                printf("Updating FIELD_NAME1 with value %d\n", data->pairs[i].value);
                break;
            case FIELD_NAME2:
                // Update FIELD_NAME2 with data->pairs[i].value
                printf("Updating FIELD_NAME2 with value %d\n", data->pairs[i].value);
                break;
            case FIELD_NAME3:
                // Update FIELD_NAME3 with data->pairs[i].value
                printf("Updating FIELD_NAME3 with value %d\n", data->pairs[i].value);
                break;
            default:
                fprintf(stderr, "Unknown field: %d\n", data->pairs[i].field);
                break;
        }
    }
}

int main() {
    KeyValuePair fields[] = {
        {FIELD_NAME1, 10},
        {FIELD_NAME2, 20},
        {FIELD_NAME3, 30}
    };
    
    UpdateData data = {fields, sizeof(fields) / sizeof(fields[0])};
    update(&data);
    
    return 0;
}