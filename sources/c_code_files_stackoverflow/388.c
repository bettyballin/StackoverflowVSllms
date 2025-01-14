#include <time.h>

void runwait(int seconds) {
   clock_t endwait;
   endwait = clock() + seconds * CLOCKS_PER_SEC;
   while (clock() < endwait) {
      /* Do stuff while waiting */
   }
}

int main() {
   runwait(5);  // Example usage
   return 0;
}