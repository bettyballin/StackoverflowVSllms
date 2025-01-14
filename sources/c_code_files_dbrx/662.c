#include <sys/sem.h> // for semget(), semop() and semctl()
#include <stdio.h>  // printf() for display purposes
#include <errno.h>  // for perror()

union semun {
    int val; // value when used in SETVAL operation(setval, getval)
    struct semid_ds *buf; /* buffer to pass info on a single set */
    unsigned short *array; // the array of values when used in GETALL/SETALL operations. Used with other arguments, this is interpreted as an element identifier (0 based index).
};

int main() {
    int SEMID = semget(IPC_PRIVATE, 1, IPC_CREAT | IPC_EXCL | 0644); // get a valid semaphore id or exit with failure; can use a specific Key here instead. e.g semget(<key>, <numsems>, <permissions>)
    if (SEMID == -1) {
        perror("semget");
        return 1;
    }

    union semun sargs; /* for setting up semaphores */
    unsigned short initial[1] = {1}; // initial value of the arrays to SetAll operation on all values/permissions of the set at once. Here just 1 element, but can be more e.g [MAX_SEMAPHS] for large numbers if desired; this is just a quick example case..
    sargs.array = initial;

    // Change ownership permissions: semctl(<semid>, <index>, IPC_SET, arg) ...
    int oldPermissions = 0755; // these would typically be passed in as variables from command line or config file for actual use but hardcoded here for brevity.
    if (semctl(SEMID, 0, IPC_SET, &oldPermissions) != -1) { // note that 'index' is the index of value to set; could be any number up to #elements in set. Useful with more than one element in array above..!
        /* Success: SEMID was a valid sem ID and permissions changed successfully */
        printf("Changed ownership & permissions for Semaphore Id: %d\n", SEMID);
    } else { // Something failed; check return values
        perror("semctl");
    }

    // Note: Always clean up IPC resources when done!  SEMID is a valid example here since the program only needs it once; typically you would keep until finished with actual system use, after which:
    if (semctl(SEMID, 0, IPC_RMID) != -1) { /* Successfully removed */
        printf("Removed semaphore id from IPC namespace\n");
    } else {
        perror("semctl");
    }

    return 0;
}