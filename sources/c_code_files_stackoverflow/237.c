#include <stdio.h>

struct Header
{
    int type;
    int payloadLength;
    char  status;
};

int main() {
    // You can add some code here to test the struct
    struct Header header;
    header.type = 1;
    header.payloadLength = 10;
    header.status = 'A';
    printf("%d %d %c\n", header.type, header.payloadLength, header.status);
    return 0;
}