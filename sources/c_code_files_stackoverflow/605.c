#include <stdio.h>
#include <string.h>

// Function to get the day of the year (1-366)
int getDayOfYear(char *date) {
    // Assuming date is in the format "MM/DD/YYYY"
    int month, day, year;
    sscanf(date, "%d/%d/%d", &month, &day, &year);
    int days[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int julian = 0;
    for (int i = 0; i < month - 1; i++) {
        julian += days[i];
    }
    julian += day;
    return julian;
}

// Function to get the day of the week (0-6)
int getDayOfWeek(char *date) {
    // Assuming date is in the format "MM/DD/YYYY"
    int month, day, year;
    sscanf(date, "%d/%d/%d", &month, &day, &year);
    int t = (14 - month) / 12;
    int y = year - t;
    int m = month + 12 * t - 2;
    int d = (day + y + y/4 - y/100 + y/400 + (31*m)/12) % 7;
    return d;
}

// Function to calculate the week number
int getWeekNumber(char *date) {
    char myDate[11];
    strcpy(myDate, date);
    int julian = getDayOfYear(myDate);
    int dow = getDayOfWeek(myDate);
    int thisYear;
    sscanf(myDate, "%*d/%*d/%d", &thisYear);
    char jan1Date[11];
    sprintf(jan1Date, "01/01/%d", thisYear);
    int dowJan1 = getDayOfWeek(jan1Date);
    int weekNum = ((julian + 6) / 7);
    if (dow < dowJan1) {
        ++weekNum;
    }
    return weekNum;
}

int main() {
    char date[] = "02/28/2022";
    int weekNumber = getWeekNumber(date);
    printf("Week Number: %d\n", weekNumber);
    return 0;
}