#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
    const char* arg = "728499.93,437.0,2032,32767,1132932560,588,1,False,2009-05-24 19:52:08.000,90,60003760,10000002,30000142,0";
    char* line = strdup(arg); // Duplicate the input string to avoid modifying the original
    double price;
    double volume_remaining;
    unsigned int type_id, range, order_id, volume_entered, minimum_volume, duration, station_id, region_id, solar_system_id, jumps;
    char issued[25];  // Allocate enough space for the expected date-time string
    char bid[6];      // Allocate enough space for "True\0" or "False\0"
    
    printf("I got %s\n", line);
    
    int res = sscanf(line, "%lf,%lf,%u,%u,%u,%u,%u,%5s,%24s,%u,%u,%u,%u,%u",
                     &price, &volume_remaining, &type_id, &range, &order_id, &volume_entered, &minimum_volume, 
                     bid, issued, &duration, &station_id, &region_id, &solar_system_id, &jumps);
    
    printf("I matched %d values\n", res);
    printf("I have price %f, vol_rem %f, type_id %d, range %d, order_id %d, vol_ent %d, min_vol %d, issued %s, bid %s, duration %d, station_id %d, region_id %d, solar_system_id %d, jumps %d\n",
           price, volume_remaining, type_id, range, order_id, volume_entered, minimum_volume, issued, bid, duration, station_id, region_id, solar_system_id, jumps);
    
    free(line); // Free the duplicated string
    return 0;
}