#include <stdarg.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void update(char* field_name, int value, ...) {
  va_list args;
  va_start(args, value);

  // validate inputs and manage memory here for each field_name in va_list
  while (field_name != NULL) {
    printf("Field name: %s, Value: %d\n", field_name, value);
    // Add your validation and memory management code here

    field_name = va_arg(args, char*);
    if (field_name != NULL) {
      value = va_arg(args, int);
    }
  }

  va_end(args);
}

int main() {
  update("Name", 10, "Age", 25, NULL);
  return 0;
}