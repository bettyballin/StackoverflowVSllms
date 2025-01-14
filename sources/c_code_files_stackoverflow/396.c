#include <windows.h>
#include <objbase.h>
#include <iostream>

int main() {
    IGetTestPtr p = NULL;
    HRESULT hRes = CoCreateInstance(__uuidof(tester), NULL, CLSCTX_INPROC_SERVER, __uuidof(IGetTest), (LPVOID*)&p);
    bool bSuccess = SUCCEEDED(hRes);

    // Don't forget to release the interface pointer when you're done with it
    if (p != NULL) {
        p->Release();
    }

    return 0;
}