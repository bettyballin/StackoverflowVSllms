#include <stdio.h>
#include <stdint.h>
#include <time.h>

// structure to hold packet data and timestamps
typedef struct {
    uint32_t data; // sample data for the sake of this example
    time_t ts_sent; // timestamp when sent
    time_t ts_received; // timestamp when received
} Packet;

Packet send_packet(uint32_t data) {
    Packet packet = { .data = data, .ts_sent = time(NULL) };
    return packet;
}

// calculate IPDV between two packets with NTP-style clock offset compensation
float ipdv(Packet *p1, Packet *p2, float last_offset) {
    // get difference in timestamps (ms) and data values for both packets to receiver
    int64_t dt1 = ((int64_t)(p1->ts_sent - p1->ts_received)) * 1000;
    int64_t dt2 = ((int64_t)(p2->ts_sent - p2->ts_received)) * 1000;
    uint32_t dd = (uint32_t)abs(p2->data - p1->data);

    // calculate clock offset at the receiver for this packet pair: (dt*N + dd)/(D-N) => N in [0,1]
    float n_estimate = (((float)dd / (float)dt2 * 1.0f)) / (last_offset > 0 ? (last_offset - 1) : (-last_offset + 1));
    // correct for this offset by scaling dt to compensate: scale both delays so the estimated round-trip time = the observed one
    int64_t ctd1 = dt1 * n_estimate;
    float ctd2 = (float)dt2 / n_estimate; // convert back to delay rather than clock offset for comparison below, but leave as a floating-point number to maintain precision across different orders of magnitude
    if ((ctd2 > 0 && ctd1 > 0) || (ctd2 < 0 && ctd1 < 0)) {
        // both delays have the same sign; return difference in milliseconds, scaled by an arbitrary constant to maintain precision
        return n_estimate * ((float)(abs(dt1 - dt2)));
    } else if (ctd1 > 0 && ctd2 == 0) {
        // only one delay is positive; use the positive delay as is and scale it by an arbitrary constant to maintain precision
        return n_estimate * ((float)(abs(dt1)));
    } else {
        // both delays are negative or indeterminate (zero); return a small number signifying zero-ish behavior in practice, scaled by an arbitrary constant to maintain precision
        return 0.001f;
    }
}

int main() {
    Packet p1 = send_packet(10);
    p1.ts_received = time(NULL); // simulate receiving the packet
    Packet p2 = send_packet(20);
    p2.ts_received = time(NULL); // simulate receiving the packet
    float last_offset = 0.0f;
    float ipdv_value = ipdv(&p1, &p2, last_offset);
    printf("IPDV value: %f\n", ipdv_value);
    return 0;
}