// shmhelper.c
#include <sys/ipc.h>
#include <sys/shm.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>

int create_shared_memory(size_t size) {
    int shm_id = shmget(IPC_PRIVATE, size, IPC_CREAT | 0666);
    if (shm_id < 0) {
        perror("shmget");
        exit(1);
    }
    return shm_id;
}

void* attach_shared_memory(int shm_id) {
    void* shm_addr = shmat(shm_id, NULL, 0);
    if (shm_addr == (void*) -1) {
        perror("shmat");
        exit(1);
    }
    return shm_addr;
}

void detach_shared_memory(void* shm_addr) {
    if (shmdt(shm_addr) < 0) {
        perror("shmdt");
        exit(1);
    }
}

void destroy_shared_memory(int shm_id) {
    if (shmctl(shm_id, IPC_RMID, NULL) < 0) {
        perror("shmctl");
        exit(1);
    }
}

int main() {
    // Example usage:
    size_t shm_size = 1024; // 1KB shared memory
    int shm_id = create_shared_memory(shm_size);
    void* shm_addr = attach_shared_memory(shm_id);

    // Use the shared memory...
    char* msg = "Hello, world!";
    strcpy((char*)shm_addr, msg);
    printf("Shared memory contains: %s\n", (char*)shm_addr);

    detach_shared_memory(shm_addr);
    destroy_shared_memory(shm_id);

    return 0;
}