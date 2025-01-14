#include <windows.h>
#include <stdio.h>

int main() {
    WIN32_FIND_DATA FileData;
    HANDLE hSearch;
    const wchar_t* dir = L"PATH TO YOUR DIRECTORY";

    hSearch = FindFirstFileW(dir, &FileData);
    if (hSearch == INVALID_HANDLE_VALUE) {
        // ERROR: Unable to search directory.
    } else {
        do {
            if (!(FileData.dwFileAttributes & FILE_ATTRIBUTE_DIRECTORY)) {
                wprintf(L"%s\n", FileData.cFileName);
            }
        } while (FindNextFileW(hSearch, &FileData));
        FindClose(hSearch); // Always close the handle when done!
    }
    return 0;
}