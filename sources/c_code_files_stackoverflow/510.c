#include <stdio.h>

volatile unsigned int stop_now = 0;

// Provide a simple definition for bar_function()
void bar_function(void) {
    printf("Bar function called\n");
}

int main(void)
{
  while (1) {
     bar_function();
     stop_now = 1;
  }
  return 0;
}