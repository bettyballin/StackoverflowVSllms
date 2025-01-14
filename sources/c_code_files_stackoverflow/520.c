pp
#include <Windows.h>
#include <comutil.h>
#include <comdef.h>

// Assuming you have the necessary definitions for the used COM interfaces
// The definition of RETURN_ON_FAIL remains as is
#define RETURN_ON_FAIL(expression) \
    result = (expression);         \
    if (FAILED(result))            \
        return false;              \
    else                           \
        (void)0; // To prevent dangling else condition

HRESULT result;
CLSID clsid;
CComPtr<IUnknown> punk = NULL;

int main() {
    CoInitialize(NULL); // Initialize COM

    CComPtr<EnvDTE::_DTE> dte = NULL;
    RETURN_ON_FAIL(::CLSIDFromProgID(L"VisualStudio.DTE", &clsid));
    RETURN_ON_FAIL(::CoCreateInstance(clsid, NULL, CLSCTX_LOCAL_SERVER, EnvDTE::IID__DTE, (LPVOID*)&punk));
    dte = punk;
    if (dte) {
        dte->put_UserControl(TRUE);
    }

    CoUninitialize(); // Uninitialize COM
    return 0;
}