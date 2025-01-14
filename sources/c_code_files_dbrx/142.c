#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
   char *home;
	char filename[1024];

   /* Retrieve the home directory path */
   home = getenv("HOMEPATH");
   sprintf(filename, "C:\\Users\\%s\\Desktop\\hello.txt", home);

   FILE *fp;
   fp = fopen (filename, "w");
   if(fp == NULL) {
      printf("Could not open file %s\n", filename);
      return 1;
   }

   // Rest of your code to write into file goes here...
   fclose(fp);

  return(0);
}