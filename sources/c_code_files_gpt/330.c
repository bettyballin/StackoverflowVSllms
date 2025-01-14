#include <nids.h>
#include <stdio.h>
#include <stdlib.h>

void tcp_callback(struct tcp_stream *a_tcp, void **args) {
    if (a_tcp->nids_state == NIDS_JUST_EST) {
        nids_discard(a_tcp, 0);
    } else if (a_tcp->nids_state == NIDS_DATA) {
        if (a_tcp->client.count_new) {
            printf("Data from client: %.*s\n", a_tcp->client.count_new, a_tcp->client.data);
        }
        if (a_tcp->server.count_new) {
            printf("Data from server: %.*s\n", a_tcp->server.count_new, a_tcp->server.data);
        }
    }
}

int main() {
    nids_params.device = "eth0";
    if (!nids_init()) {
        fprintf(stderr, "Error initializing libnids: %s\n", nids_errbuf);
        return 1;
    }

    nids_register_tcp(tcp_callback);
    nids_run();
    return 0;
}