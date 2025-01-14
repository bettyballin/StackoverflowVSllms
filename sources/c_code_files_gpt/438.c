#include <stdio.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/sem.h>

int main() {
    key_t key = ftok("path_to_some_file", 'A'); // Generate unique key
    int semid = semget(key, 1, 0666); // Get semaphore ID

    if (semid == -1) {
        perror("semget");
        return 1;
    }

    struct semid_ds buf;
    uid_t new_uid = getuid(); // Replace with the desired new owner user ID
    gid_t new_gid = getgid(); // Replace with the desired new owner group ID
    mode_t new_mode = 0666; // Replace with the desired new permissions

    buf.sem_perm.uid = new_uid; // Set new owner user ID
    buf.sem_perm.gid = new_gid; // Set new owner group ID
    buf.sem_perm.mode = new_mode; // Set new permissions

    if (semctl(semid, 0, IPC_SET, &buf) == -1) {
        perror("semctl");
        return 1;
    }

    printf("Semaphore ownership and permissions changed successfully.\n");
    return 0;
}