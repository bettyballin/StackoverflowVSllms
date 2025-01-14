#include <stdint.h>
#include <stddef.h>

// Define the data structure for sensor table data
typedef struct {
    uint8_t sensor;
    uint16_t time;
    int8_t temperature;
    float moisture;
} sensors_table_data_t;

// Calculate checksum
uint8_t calculate_checksum(void *data, size_t length) {
    uint8_t checksum = 0;
    uint8_t *bytes = (uint8_t *)data;
    for (size_t i = 0; i < length; i++) {
        checksum ^= bytes[i];
    }
    return checksum;
}

// Send data row
void send_data_row(uint8_t table_id, void *data, size_t data_length) {
    uint8_t checksum = calculate_checksum(data, data_length);
    // Assuming rs232_send is a function to send data over RS232
    // You need to implement this function or replace it with your own
    // For demonstration purposes, it's commented out
    // rs232_send(&table_id, sizeof(table_id));
    // rs232_send(data, data_length);
    // rs232_send(&checksum, sizeof(checksum));
}

// Send table format (handshake)
void send_table_format(uint8_t table_id) {
    // You need to implement this function or replace it with your own
    // For demonstration purposes, it's empty
}

int main() {
    // Example data
    sensors_table_data_t sensor_data[] = {
        {1, 3012, 20, 0.5},
        {2, 3024, 22, 0.9}
    };

    // Send the table format (handshake)
    send_table_format(0);

    // Send data rows
    for (size_t i = 0; i < sizeof(sensor_data) / sizeof(sensor_data[0]); i++) {
        send_data_row(1, &sensor_data[i], sizeof(sensor_data[i]));
    }

    return 0;
}