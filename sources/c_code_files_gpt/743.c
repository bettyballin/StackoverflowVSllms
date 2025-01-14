#include <libserialport.h>
#include <stdio.h>

int main() {
    struct sp_port *port;
    sp_get_port_by_name("/dev/ttyUSB0", &port);
    if (sp_open(port, SP_MODE_READ_WRITE) != SP_OK) {
        fprintf(stderr, "Failed to open port\n");
        return 1;
    }
    if (sp_set_baudrate(port, 9600) != SP_OK) {
        fprintf(stderr, "Failed to set baudrate\n");
        sp_close(port);
        sp_free_port(port);
        return 1;
    }

    const char *data = "Hello, World!";
    if (sp_nonblocking_write(port, data, strlen(data)) != SP_OK) {
        fprintf(stderr, "Failed to write data\n");
    }

    char buffer[32];
    int bytes_read = sp_nonblocking_read(port, buffer, sizeof(buffer));
    if (bytes_read < 0) {
        fprintf(stderr, "Failed to read data\n");
    } else {
        buffer[bytes_read] = '\0';
        printf("Received: %s\n", buffer);
    }

    sp_close(port);
    sp_free_port(port);

    return 0;
}