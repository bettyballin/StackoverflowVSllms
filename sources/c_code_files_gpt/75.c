#include <stdio.h>
#include <windows.h>
#include <objbase.h>
#include <oleauto.h>

// Replace with the CLSID and IID of your COM object
DEFINE_GUID(CLSID_COMObject, 
0x00000000, 0x0000, 0x0000, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00);
DEFINE_GUID(IID_IDispatch, 
0x00020400, 0x0000, 0x0000, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x46);

int main() {
    HRESULT hr;
    IDispatch *pDisp = NULL;
    DISPPARAMS dpNoArgs = {NULL, NULL, 0, 0};
    VARIANT result;
    VariantInit(&result);

    // Initialize COM Library
    hr = CoInitialize(NULL);
    if (FAILED(hr)) {
        printf("Failed to initialize COM library. Error code = 0x%08X\n", hr);
        return -1;
    }

    // Create COM Object
    hr = CoCreateInstance(&CLSID_COMObject, NULL, CLSCTX_INPROC_SERVER, &IID_IDispatch, (void**)&pDisp);
    if (FAILED(hr)) {
        printf("Failed to create COM object. Error code = 0x%08X\n", hr);
        CoUninitialize();
        return -1;
    }

    // Invoke a method (assuming methodID corresponds to the method you want to call)
    DISPID methodID = 1;  // Replace with the actual DISPID
    hr = pDisp->lpVtbl->Invoke(pDisp, methodID, &IID_NULL, LOCALE_USER_DEFAULT, DISPATCH_METHOD, &dpNoArgs, &result, NULL, NULL);
    if (FAILED(hr)) {
        printf("Invoke failed. Error code = 0x%08X\n", hr);
    } else {
        // Handle result
        // For example, if the result is an integer:
        if (result.vt == VT_I4) {
            printf("Method returned: %d\n", result.lVal);
        }
    }

    // Cleanup
    VariantClear(&result);
    pDisp->lpVtbl->Release(pDisp);
    CoUninitialize();

    return 0;
}