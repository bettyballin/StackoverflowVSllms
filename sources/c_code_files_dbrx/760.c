#include <stdio.h>
#include <stdlib.h>

#define RANDOM_DEVICE "/dev/random"

int create_shared_secret(char *secret, int size) {
   FILE *file = NULL;
   int RetVal;

   file = fopen(RANDOM_DEVICE, "r");
   if (!file) {
     printf("Unable to open random device %s\n", RANDOM_DEVICE);
     exit(-1);
   }
   RetVal = fread(secret, 1, size, file);
   if (RetVal != size) {
     printf("Problem getting seed value\n");
     exit(-1);
   }

   if (file) fclose(file);
   return 0;
}

int main() {
   char secret[1024];
   int size = 1024;
   create_shared_secret(secret, size);
   return 0;
}