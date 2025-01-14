#include <stdlib.h>
int main(){
  system("awk '{if ($1 == \"abc\") print $2}' testfile");
  return 0;
}