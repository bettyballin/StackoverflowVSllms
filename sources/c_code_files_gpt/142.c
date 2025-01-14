#include <sqlite3.h>

int main() {
    sqlite3_enable_shared_cache(0);
    return 0;
}