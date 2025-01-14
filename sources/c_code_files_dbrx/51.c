#include <stdio.h>

typedef struct tagSQLDateTime
{
    unsigned short wYear;   /* year           */
    unsigned char  bMonth;  /* month          */
    unsigned char  bDay;    /* day            */
    unsigned char  bHour;   /* hour (24hr)       */
    unsigned char  bMinute;  /* minute         */
    unsigned char  bSecond;  /* second         */
    unsigned char  bMilliseconds;/* millisecond     */
} SQLDateTime;

int main() {
    SQLDateTime dt;
    dt.wYear = 2022;
    dt.bMonth = 12;
    dt.bDay = 25;
    dt.bHour = 12;
    dt.bMinute = 30;
    dt.bSecond = 0;
    dt.bMilliseconds = 0;

    printf("Date: %04hu-%02hhu-%02hhu %02hhu:%02hhu:%02hhu.%03hhu\n",
           dt.wYear, dt.bMonth, dt.bDay, dt.bHour, dt.bMinute, dt.bSecond, dt.bMilliseconds);

    return 0;
}