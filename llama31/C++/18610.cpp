#include <Windows.h>\n#include <ole2.h>\n\nint main() {\n    // Initialize COM\n    CoInitialize(NULL);\n\n    // Create a laser object\n    IDispatch* pLaser = NULL;\n    HRESULT hr = CoCreateInstance(CLSID_NWLaserXControl, NULL, CLSCTX_INPROC_SERVER, IID_IDispatch, (void**)&pLaser);\n    if (FAILED(hr)) {\n        // Handle error\n        CoUninitialize();\n        return 1;\n    }\n\n    // Initialize the laser\n    VARIANT_BOOL bInitialized;\n    hr = pLaser->Invoke(0x60010001, IID_NULL, LOCALE_USER_DEFAULT, DISPATCH_METHOD, NULL, &bInitialized, NULL, NULL);\n    if (FAILED(hr) || !bInitialized) {\n        // Handle error\n        pLaser->Release();\n        CoUninitialize();\n        return 1;\n    }\n\n    // Set rep rate to 10Hz\n    VARIANT vRepRate;\n    vRepRate.vt = VT_I4;\n    vRepRate.lVal = 10;\n    hr = pLaser->Invoke(0x60010002, IID_NULL, LOCALE_USER_DEFAULT, DISPATCH_PROPERTYPUT, &vRepRate, NULL, NULL, NULL);\n    if (FAILED(hr)) {\n        // Handle error\n        pLaser->Release();\n        CoUninitialize();\n        return 1;\n    }\n\n    // Turn on laser power supply\n    VARIANT_BOOL bEnabled;\n    bEnabled = VARIANT_TRUE;\n    hr = pLaser->Invoke(0x60010003, IID_NULL, LOCALE_USER_DEFAULT, DISPATCH_PROPERTYPUT, &bEnabled, NULL, NULL, NULL);\n    if (FAILED(hr)) {\n        // Handle error\n        pLaser->Release();\n        CoUninitialize();\n        return 1;\n    }\n\n    // Clean up\n    pLaser->Release();\n    CoUninitialize();\n    return 0;\n}