pp
#include <cassert>
#include <iostream>
#include <ole2.h>
#include <dshow.h>

#pragma comment(lib, "ole32.lib")
#pragma comment(lib, "strmiids.lib")

HRESULT extractFriendlyName(IMoniker* pMk, std::wstring& str)
{
    // ... (unchanged)
}

HRESULT enumerateDShowFilterList(const CLSID& category)
{
    // ... (unchanged)
}

int main()
{
    CoInitialize(NULL);

    CLSID category = CLSID_VideoInputDeviceCategory; // for example
    HRESULT hr = enumerateDShowFilterList(category);

    if (FAILED(hr))
    {
        std::cerr << "Error: " << hr << std::endl;
        return 1;
    }

    CoUninitialize();
    return 0;
}