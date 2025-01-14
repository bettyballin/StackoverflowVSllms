#include <stdlib.h>
#include <string.h>

int main(){
  char hex_str[16] = "0xefffffff"; // your string here, in this case 0xefffffff
  int hex_num;
  char *p;  /* Used to check conversion end place */

  hex_num = strtol(hex_str, &p, 16);
}