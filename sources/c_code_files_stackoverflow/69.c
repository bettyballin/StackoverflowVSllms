#include <stdio.h>

int main() {
    const char *sql = "SELECT COUNT(*) FROM tasks WHERE completed > ?";
    printf("%s\n", sql);
    return 0;
}