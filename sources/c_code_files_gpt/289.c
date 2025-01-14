#include <stdint.h>
#include <stdio.h>
#include <string.h>

// Define the data structure for table format
typedef struct {
    uint8_t table_id;
    char column_names[4][20];
    uint8_t column_types[4]; // 0: int, 1: float
} table_format_t;

// Example table formats
table_format_t tables[2] = {
    {1, {"sensor", "time", "temperature", "moisture"}, {0, 0, 0, 1}},
    {2, {"user_id", "timestamp", "activity", "duration"}, {0, 0, 0, 0}}
};

// Send table format to client
void send_table_format(int table_index) {
    table_format_t *table = &tables[table_index];
    // Send table data over RS232 (simulated with printf)
    printf("Table ID: %u\n", table->table_id);
    for (int i = 0; i < 4; i++) {
        printf("Column %d: %s\n", i, table->column_names[i]);
    }
    printf("Column types: ");
    for (int i = 0; i < 4; i++) {
        printf("%u ", table->column_types[i]);
    }
    printf("\n");
}

int main() {
    send_table_format(0);
    send_table_format(1);
    return 0;
}