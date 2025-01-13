#include <stdatomic.h>\n\ntypedef struct spinlock {\n    atomic_flag flag = ATOMIC_FLAG_INIT;\n} spinlock;\n\nvoid spinlock_lock(spinlock *lock) {\n    while (atomic_flag_test_and_set(&lock->flag))\n        ; // spin\n}\n\nvoid spinlock_unlock(spinlock *lock) {\n    atomic_flag_clear(&lock->flag);\n}