#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <stdint.h>
#include <bits/stdc++.h>

// Assuming you are in a GNU/Linux system where __initstate_r and __random_r are accessible
// Otherwise, these functions might need to be replaced with standard C functions

char *
strfry (char *string)
{
  static int init;
  static struct random_data rdata;
  size_t len, i;

  if (!init)
    {
      static int state[8] = { 1, 2, 3, 4, 5, 6, 7, 8 };
      rdata.state = NULL;
      __initstate_r (time ((time_t *) NULL), state, 8, &rdata);
      init = 1;
    }

  len = strlen (string);
  for (i = 0; i < len; ++i)
    {
      int32_t j;
      char c;

      __random_r (&rdata, &j);
      j %= len;

      c = string[i];
      string[i] = string[j];
      string[j] = c;
    }

  return string;
}

int main() {
    char str[] = "Hello, World!";
    printf("Original: %s\n", str);
    printf("After strfry: %s\n", strfry(str));
    return 0;
}