#include <windows.h>
#include <objidl.h>

int main() {
    LARGE_INTEGER liMove = { 0 };
    ULARGE_INTEGER uliSize;
    IStream *pStream;

    // Initialize pStream here, for example:
    // HRESULT hr = CreateStreamOnHGlobal(NULL, TRUE, &pStream);

    if (pStream != NULL) {
        HRESULT hr = pStream->lpVtbl->Seek(pStream, liMove, STREAM_SEEK_END, &uliSize);
        // Check the HRESULT value here
    }

    return 0;
}