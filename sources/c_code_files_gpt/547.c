#include <stdio.h>
#include <locale.h>

void SetupConsole() {
    setlocale(LC_ALL, "");
}

int main() {
    SetupConsole();
    printf("%s\n", "test");
    return 0;
}