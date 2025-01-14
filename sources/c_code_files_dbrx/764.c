#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

#define READ 0
#define WRITE 1

int main(void) {
  pid_t pid;
  int fd[2];
  const char data[] = "Sample Data!";

  pipe(fd);

  /* Parent process will write */
  if ((pid = fork()) == -1) { 
    perror("fork error"); 
    exit(1); 
  }
  else if (pid > 0) { // in parent
    close(fd[READ]);
    if (write(fd[WRITE], data, sizeof data) != sizeof data)
      perror("write failed");
  }
  /* Child process will read */
  else { // child
    close(fd[WRITE]);
    char buf[1024];
    ssize_t bytes;
    if ((bytes = read(fd[READ], buf, sizeof buf)) != -1) {
      buf[bytes]='\0'; // null terminate the string
      printf("Received: %s\n",buf);
    }
    else {
      perror ("read failed"); 
      exit (2);
    }
  }
  return 0;
}