#include <Windows.h>\n#include <Wbemidl.h>\n\nint main()\n{\n    // Initialize COM\n    CoInitialize(NULL);\n    // Connect to the WMI namespace\n    IWbemServices* pSvc = NULL;\n    IWbemLevel1Login* pLogin = NULL;\n    HRESULT hres = CoCreateInstance(CLSID_WbemAdmin, NULL, CLSCTX_INPROC_SERVER, IID_IWbemLevel1Login, (LPVOID*)&pLogin);\n    if (SUCCEEDED(hres))\n    {\n        hres = pLogin->Login(L"root\\cimv2", NULL, NULL, 0, NULL, 0, NULL, &pSvc);\n        if (SUCCEEDED(hres))\n        {\n            // Create a query to monitor process creation\n            IEnumWbemClassObject* pEnum = NULL;\n            hres = pSvc->ExecQuery(L"WQL", L"SELECT * FROM Win32_ProcessStartTrace", WBEM_FLAG_FORWARD_ONLY | WBEM_FLAG_NO_ERROR, NULL, &pEnum);\n            if (SUCCEEDED(hres))\n            {\n                // Iterate over the results\n                IWbemClassObject* pObject = NULL;\n                while (pEnum->Next(WBEM_INFINITE, 1, &pObject, NULL) == S_OK)\n                {\n                    // Get the process name\n                    VARIANT vName;\n                    hres = pObject->Get(L"ProcessName", 0, &vName, 0, 0);\n                    if (SUCCEEDED(hres) && vName.vt == VT_BSTR && !lstrcmpi(vName.bstrVal, L"xyz.exe"))\n                    {\n                        // Show a message box when xyz.exe starts\n                        MessageBox(NULL, L"xyz.exe has started", L"Process Monitor", MB_OK);\n                    }\n                    SysFreeString(vName.bstrVal);\n                    pObject->Release();\n                }\n                pEnum->Release();\n            }\n            pSvc->Release();\n        }\n        pLogin->Release();\n    }\n    CoUninitialize();\n    return 0;\n}