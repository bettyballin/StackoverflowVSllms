#include <stdio.h>\n#include <stdlib.h>\n#include <unistd.h>\n#include <sys/mman.h>\n#include <fcntl.h>\n#include <sys/wait.h>\n\n#define SHM_SIZE 4096\n\nint main() {\n    // Create a shared memory object\n    int shm_fd = shm_open("/myshm", O_CREAT | O_RDWR, 0666);\n    if (shm_fd == -1) {\n        perror("shm_open");\n        exit(EXIT_FAILURE);\n    }\n\n    // Configure the size of the shared memory object\n    if (ftruncate(shm_fd, SHM_SIZE) == -1) {\n        perror("ftruncate");\n        exit(EXIT_FAILURE);\n    }\n\n    // Map the shared memory object\n    void *shm_ptr = mmap(0, SHM_SIZE, PROT_READ | PROT_WRITE, MAP_SHARED, shm_fd, 0);\n    if (shm_ptr == MAP_FAILED) {\n        perror("mmap");\n        exit(EXIT_FAILURE);\n    }\n\n    // Write some data to the shared memory\n    sprintf((char *)shm_ptr, "Hello from parent process!");\n\n    pid_t pid = fork();\n    if (pid == -1) {\n        perror("fork");\n        exit(EXIT_FAILURE);\n    } else if (pid == 0) {\n        // Child process\n        execlp("./child_program", "./child_program", NULL);\n        perror("execlp");\n        exit(EXIT_FAILURE);\n    } else {\n        // Parent process\n        wait(NULL);  // Wait for child process to finish\n        printf("Child process finished\n");\n\n        // Clean up shared memory\n        if (munmap(shm_ptr, SHM_SIZE) == -1) {\n            perror("munmap");\n        }\n        if (shm_unlink("/myshm") == -1) {\n            perror("shm_unlink");\n        }\n    }\n\n    return 0;\n}