#include <stdio.h>

#define MAX_STRING_LENGTH 100 // Adjust this value based on the maximum expected length of your strings

int main() {
    char line[MAX_STRING_LENGTH]; // assuming line is a string with the format specified in sscanf
    double price, volume_remaining;
    unsigned int type_id, range, order_id, volume_entered, minimum_volume, duration, station_id, region_id, solar_system_id, jumps;
    char bid[MAX_STRING_LENGTH];
    char issued[MAX_STRING_LENGTH];
    int res = sscanf(line, "%lf,%lf,%u,%u,%u,%u,%u,%s,%s,%u,%u,%u,%u,%u", &price, &volume_remaining, &type_id, &range, &order_id, &volume_entered, &minimum_volume, bid, issued, &duration, &station_id, &region_id, &solar_system_id, &jumps);
    printf("I have price %f, vol_rem %f, type_id %d, range %d, order_id %d, vol_ent %d, min_vol %d, issued %s, bid %s, duration %d, station_id %d, region_id %d, solar_system_id %d, jump %d\n", price, volume_remaining, type_id, range, order_id, volume_entered, minimum_volume, issued, bid, duration, station_id, region_id, solar_system_id, jumps);
    return 0;
}