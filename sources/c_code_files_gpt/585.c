#include <stdio.h>

#ifdef MYAPP_CORE_DATA_BUILD
// New CoreData related code
void coreDataFunction() {
    printf("Using CoreData related code\n");
}
#else
// Old SQLitePersistentObject related code
void sqliteFunction() {
    printf("Using SQLitePersistentObject related code\n");
}
#endif

int main() {
    #ifdef MYAPP_CORE_DATA_BUILD
    coreDataFunction();
    #else
    sqliteFunction();
    #endif
    return 0;
}