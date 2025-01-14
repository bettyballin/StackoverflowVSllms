#include <windows.h>

int main() {
    ShellExecute(NULL, "open", "c:\\x.txt", NULL, NULL, SW_SHOW);
    return 0;
}