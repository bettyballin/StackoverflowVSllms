#include <Windows.h>
#include <stdio.h>

int main() {
    HKEY hk;
    long n = RegOpenKeyEx(HKEY_LOCAL_MACHINE, TEXT("SOFTWARE"), 0, KEY_QUERY_VALUE, &hk);
    if (n == ERROR_SUCCESS) {
        printf("Key opened successfully.\n");
        RegCloseKey(hk);
    } else {
        printf("Failed to open key: %ld\n", n);
    }
    return 0;
}