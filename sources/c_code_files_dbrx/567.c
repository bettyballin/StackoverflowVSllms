#include <windows.h>
#include <io.h>
#include <fcntl.h>

int main() {
    // Open the file
    int hfile = _open("test.txt", _O_RDWR | _O_CREAT, _S_IREAD | _S_IWRITE);
    if (hfile == -1) {
        /* Handle error */
        return 1;
    }

    // Convert file descriptor to HANDLE
    HANDLE hhandle = (HANDLE)_get_osfhandle(hfile);
    if (hhandle == INVALID_HANDLE_VALUE) {
        /* Handle error */
        _close(hfile);
        return 1;
    }

    // Use the handle
    if (!SetEndOfFile(hhandle)) {
        /* Handle error */
        CloseHandle(hhandle);
        _close(hfile);
        return 1;
    }

    // Clean up
    CloseHandle(hhandle);
    _close(hfile);

    return 0;
}