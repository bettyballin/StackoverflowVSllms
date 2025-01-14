#include <sys/socket.h>
#include <netinet/in.h>

int main() {
    int s, proto = 0; // replace 0 with the desired protocol
    s = socket(PF_INET, SOCK_STREAM, proto);
    return 0;
}