#include <windows.h>

// Declare & initialize
SRWLOCK myLock = SRWLOCK_INIT;

void readFunc() {
    AcquireSRWLockShared(&myLock); // Lock for reading. Concurrent readers can enter the lock, but writers will be blocked.
                                      // Once a writer enters, no new readers are allowed till writer leaves.

    // read data...

    ReleaseSRWLockShared(&myLock); // Release reader lock at end of scope
}

void writeFunc() {
    AcquireSRWLockExclusive(&myLock); // Lock for writing. Both other writers & concurrent readers will be blocked until this operation completes.

    // alter data...

    ReleaseSRWLockExclusive(&myLock); // Release writer lock at end of scope
}

int main() {
    readFunc();
    writeFunc();
    return 0;
}