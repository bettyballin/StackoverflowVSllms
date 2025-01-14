#include <stdio.h>

void print(char* s) {
    printf("%s\n", s);
}

void walk(char* s, int i, int ndiff){
  char c = s[i];
  if (ndiff > 2) return;
  if (c == '\0'){
    if (ndiff > 0) print(s);
  }
  else {
    s[i] = '0'; walk(s, i+1, (s[i]==c ? ndiff : ndiff+1));
    s[i] = '1'; walk(s, i+1, (s[i]==c ? ndiff : ndiff+1));
    s[i] = '2'; walk(s, i+1, (s[i]==c ? ndiff : ndiff+1));
    s[i] = '3'; walk(s, i+1, (s[i]==c ? ndiff : ndiff+1));
    s[i] = c;
  }
}

char seed[] = "000";

int main(){
  walk(seed, 0, 0);
  return 0;
}