#include <windows.h>

int main() {
    char executable_name[MAX_PATH];
    GetModuleFileNameA(NULL, executable_name, MAX_PATH);

    // Your code to use the variable executable_name can go here
    printf("%s\n", executable_name);

    return 0;
}