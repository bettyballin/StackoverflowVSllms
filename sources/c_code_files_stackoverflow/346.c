#include <windows.h>
#include <objbase.h>

int main() {
    // if (CoInitialize(0) == S_OK)
    {
        IUnknown* pMyPtr = NULL;

        CLSID clsid = IID_NULL;
        CLSIDFromProgID(L"NWLaserXControl.NWLaserX", &clsid);

        if (CoCreateInstance(clsid, NULL, CLSCTX_INPROC_SERVER, IID_PPV_ARGS(&pMyPtr)) == S_OK)
        {
            INWLaserX* pLaserX = (INWLaserX*)pMyPtr;
            pLaserX->put_RepRate(10);
            pLaserX->put_LaserEnabled(TRUE);
            pLaserX->Release();
        }

        // CoUninitialize();
    }
    return 0;
}