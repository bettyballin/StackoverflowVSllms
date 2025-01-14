#include <stdio.h>

int main() {
    int uDay = 0x7F;  // Assuming a bitmask of all weekdays (Monday to Sunday)
    int today = 1;    // Assuming today is Sunday

    int daysOfWeek = uDay; 
    int nextDay = (today % 7) + 1; 

    while ((daysOfWeek & (1 << (nextDay - 1))) == 0 && (nextDay != today)) {
        if(nextDay==7){
            nextDay = 1; 
        }else{
            nextDay++;
        }
    }

    printf("Next available day: %d\n", nextDay);

    return 0;
}