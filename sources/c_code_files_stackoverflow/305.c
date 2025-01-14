#include <string.h>

void returnString(char myString[])
{
  const char *aString = "test string";
  memcpy(myString, aString, 12);
}

int main() {
    char buffer[12];
    returnString(buffer);
    return 0;
}