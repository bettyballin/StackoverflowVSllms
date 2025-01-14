#include <stdio.h>
#include <stdlib.h>
#include <errno.h>
#include <netinet/in.h>
#include <arpa/nameser.h>
#include <arpa/ns_compat.h>
#include <resolv.h>

int main() {
    struct __res_state res;
    union {
        HEADER hdr;
        unsigned char buf[4096];
    } responseBuf = {};
    int responseLength;
    const u_char *answerRR;

    if (res_ninit(&res) == -1) {
        fprintf(stderr, "res_ninit failed: %d\n", errno);
        exit(EXIT_FAILURE);
    }

    if (res.retrans < 2) {
        fprintf(stderr, "res.retrans < 2\n");
        exit(EXIT_FAILURE);
    }

    // Note: ns_o_msg and T_MX usage might need adjustment based on actual implementation
    responseLength = res_nquery(&res, "8.8.8.8", ns_o_msg(NS_C_IN, NS_C_ANY), "example.com", T_MX,
                                sizeof(responseBuf), &answerRR);

    if (responseLength > (int)sizeof(responseBuf)) {
        fprintf(stderr, "Response truncated.\n");
    } else if ((size_t)responseLength <= HEADERSIZE) {
        fprintf(stderr, "No answer in the response.\n");
    } else {
        // Parse responseBuf here
        printf("Response received successfully.\n");
        // Add parsing logic here
    }

    res_nclose(&res);

    return 0;
}