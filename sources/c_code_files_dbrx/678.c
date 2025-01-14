#include <stdio.h>
#include <unistd.h> /* syscall read function */

int main(){
  char buf[50];

  // Using read
  int bytes_read = read(0, buf, sizeof(buf)); // 0 for standard input

  if (bytes_read > 0) {
    buf[bytes_read-1] = '\0'; // null terminate the string
    printf("Read using read : %s\n", buf);
  }

  // Using fread
  FILE *fp = fopen("/path/to/file", "r");
  if (fp != NULL) {
    size_t bytes_fread = fread(buf, sizeof(char), sizeof(buf) / sizeof(char), fp);
    if (bytes_fread > 0) {
      buf[bytes_fread-1] = '\0'; // null terminate the string
      printf("Read using fread : %s\n", buf);
    }
    fclose(fp);
  }

  return 0;
}