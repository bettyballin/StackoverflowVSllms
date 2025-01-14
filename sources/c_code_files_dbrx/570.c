#include <stdio.h>
#include <string.h>
int main(int argc, char *argv[]) {
  FILE *file;
  char buffer[512]; // Change size as per your requirements
  int offset = -1; // Set this to the desired position in file where you want to stop reading
  if(argc > 1 && sscanf ( argv [ 1 ], "%d", &offset ) == EOF) {
    fprintf(stderr, "Invalid integer");
    return 1;
  }

  file = fopen("filename.txt","r"); // replace with desired filename
  if(!file){
     perror("Error opening file!");
     return -1;
  }

  while ((fread(buffer, sizeof buffer, 1 , file)) && (ftell(file) < offset)){//Continue as long the condition is true
      printf("%s",buffer); //You may change it to process based on your requirements.

      fseek(file, -sizeof buffer + ftell(file), SEEK_END);//Adjust the file pointer for next iteration;
  }
}