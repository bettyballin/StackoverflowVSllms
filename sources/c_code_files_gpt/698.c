#include <stdio.h>
#include <stdlib.h>

int check_ppp_link() {
    int status = system("ip link show ppp0 | grep 'state UP' > /dev/null 2>&1");
    return (status == 0);
}

int main() {
    int link_status = check_ppp_link();
    printf("PPPoE link status: %s\n", link_status ? "UP" : "DOWN");
    return 0;
}