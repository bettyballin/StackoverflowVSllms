#include <Windows.h>\n#include <Wbemidl.h>\n\nint main() {\n    IWbemServices* pSvc = NULL;\n    IWbemClassObject* pClass = NULL;\n    IWbemClassObject* pInstance = NULL;\n\n    // Initialize WMI\n    CoInitialize(NULL);\n    CoCreateInstance(CLSID_WbemAdministrativeLocator, NULL, CLSCTX_INPROC_SERVER, IID_IWbemServices, (LPVOID*)&pSvc);\n\n    // Get the Win32_PCCard class\n    pSvc->CreateClassInstance(L"Win32_PCCard", 0, NULL, IID_IWbemClassObject, (LPVOID*)&pClass);\n\n    // Get the instances of the Win32_PCCard class\n    pSvc->CreateInstanceEnum(L"Win32_PCCard", 0, NULL, IID_IWbemClassObject, (LPVOID*)&pInstance);\n\n    // Loop through the instances and retrieve the serial number\n    while (pInstance) {\n        VARIANT var;\n        pInstance->Get(L"SerialNumber", 0, &var, NULL, NULL);\n        if (var.vt == VT_BSTR) {\n            printf("Serial Number: %ws\n", var.bstrVal);\n        }\n        VariantClear(&var);\n        pInstance->Release();\n        pSvc->Next(1, &pInstance, NULL);\n    }\n\n    // Cleanup\n    pSvc->Release();\n    pClass->Release();\n    CoUninitialize();\n    return 0;\n}