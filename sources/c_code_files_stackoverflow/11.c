#include <string.h>

void checkRegistration(const char *registeredNames[], const char *name, int lastIndex) {
  for (int index = 0; index <= lastIndex; index++) {
    if (strcmp(registeredNames[index], name) == 0) {
      return; // Already registered
    }
  }
}