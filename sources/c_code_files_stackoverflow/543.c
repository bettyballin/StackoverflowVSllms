#include <stdio.h>

int getNextDay(int days_mask, int today) {
   if (!days_mask) return -1; // no days set
   days_mask |= days_mask << 7; // duplicate days into next week
   int mask = 1 << (today % 7); // keep track of the day
   while (!(mask & days_mask)) {
      mask <<= 1;
      ++today;
   }
   return today % 7;
}

int main() {
   // Example usage:
   int days_mask = 0x1F; // 00011111 in binary, representing Monday to Friday
   int today = 2; // Wednesday
   int next_day = getNextDay(days_mask, today);
   printf("Next day: %d\n", next_day);
   return 0;
}