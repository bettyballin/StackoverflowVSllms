#include <windows.h>
#include <stdio.h>

int main() {
    FILETIME ft; // This is obtained through FindFirstFile/FindNextFile.
    SYSTEMTIME st = {0};
    // Initialize ft for demonstration purposes
    ft.dwHighDateTime = 0;
    ft.dwLowDateTime = 0;

    if (!FileTimeToSystemTime(&ft, &st)) {
        printf("Error occurred while converting FILETIME to SYSTEMTIME\n");
    } else {
        printf("Resulting SYSTEMTIME in UTC: %d-%d-%d %d:%d:%d\n", 
               st.wYear, st.wMonth, st.wDay, st.wHour, st.wMinute, st.wSecond);
    }

    return 0;
}