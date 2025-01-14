#include <stdio.h>
#include <stdlib.h>
#include <resolv.h>
#include <netinet/in.h>
#include <arpa/nameser.h>
#include <string.h>

void query_mx_records(const char *domain) {
    unsigned char response[NS_PACKETSZ];
    ns_msg handle;
    ns_rr rr;
    int response_length;

    // Query for MX records
    response_length = res_query(domain, ns_c_in, ns_t_mx, response, sizeof(response));

    if (response_length < 0) {
        perror("res_query");
        return;
    }

    if (ns_initparse(response, response_length, &handle) < 0) {
        perror("ns_initparse");
        return;
    }

    // Loop through the answer section
    int count = ns_msg_count(handle, ns_s_an);
    for (int i = 0; i < count; ++i) {
        if (ns_parserr(&handle, ns_s_an, i, &rr) < 0) {
            perror("ns_parserr");
            return;
        }

        // Check if this is an MX record
        if (ns_rr_type(rr) == ns_t_mx) {
            const unsigned char *rdata = ns_rr_rdata(rr);
            uint16_t preference = ntohs(*(uint16_t *)rdata);
            char exchange[NS_MAXDNAME];
            if (dn_expand(response, response + response_length, rdata + 2, exchange, sizeof(exchange)) < 0) {
                perror("dn_expand");
                return;
            }
            printf("MX Record: Preference = %d, Exchange = %s\n", preference, exchange);
        }
    }
}

int main(int argc, char *argv[]) {
    if (argc != 2) {
        fprintf(stderr, "Usage: %s <domain>\n", argv[0]);
        return EXIT_FAILURE;
    }

    // Initialize resolver
    if (res_init() < 0) {
        perror("res_init");
        return EXIT_FAILURE;
    }

    query_mx_records(argv[1]);

    return EXIT_SUCCESS;
}