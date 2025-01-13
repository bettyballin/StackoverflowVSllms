#include <windows.h>\n#include <objbase.h>\n#include <iostream>\n\nIGlobalInterfaceTable* pGIT = nullptr;\nDWORD dwCookie = 0;\n\n// Example interface (replace with your actual interface)\nIUnknown* pYourInterface = nullptr;\n\nvoid RegisterInterfaceInGIT() {\n    HRESULT hr = CoCreateInstance(CLSID_StdGlobalInterfaceTable, nullptr, CLSCTX_INPROC_SERVER, IID_IGlobalInterfaceTable, (void**)&pGIT);\n    if (SUCCEEDED(hr)) {\n        hr = pGIT->RegisterInterfaceInGlobal(pYourInterface, IID_IUnknown, &dwCookie);\n        if (SUCCEEDED(hr)) {\n            std::cout << "Interface registered in GIT with cookie: " << dwCookie << std::endl;\n        } else {\n            std::cerr << "Failed to register interface in GIT." << std::endl;\n        }\n    } else {\n        std::cerr << "Failed to create GIT instance." << std::endl;\n    }\n}\n\nDWORD WINAPI WorkerThread(LPVOID lpParam) {\n    HRESULT hr = CoInitializeEx(nullptr, COINIT_MULTITHREADED);\n    if (SUCCEEDED(hr)) {\n        IUnknown* pInterface = nullptr;\n        hr = pGIT->GetInterfaceFromGlobal(dwCookie, IID_IUnknown, (void**)&pInterface);\n        if (SUCCEEDED(hr)) {\n            // Use pInterface\n            pInterface->Release();\n        } else {\n            std::cerr << "Failed to get interface from GIT." << std::endl;\n        }\n        CoUninitialize();\n    } else {\n        std::cerr << "Failed to initialize COM in worker thread." << std::endl;\n    }\n    return 0;\n}\n\nint main() {\n    HRESULT hr = CoInitializeEx(nullptr, COINIT_MULTITHREADED);\n    if (SUCCEEDED(hr)) {\n        // Assume pYourInterface is already created and initialized.\n        RegisterInterfaceInGIT();\n\n        // Create worker threads\n        HANDLE hThreads[2];\n        for (int i = 0; i < 2; ++i) {\n            hThreads[i] = CreateThread(nullptr, 0, WorkerThread, nullptr, 0, nullptr);\n        }\n\n        // Wait for threads to finish\n        WaitForMultipleObjects(2, hThreads, TRUE, INFINITE);\n\n        // Clean up\n        for (int i = 0; i < 2; ++i) {\n            CloseHandle(hThreads[i]);\n        }\n\n        pGIT->RevokeInterfaceFromGlobal(dwCookie);\n        pGIT->Release();\n        CoUninitialize();\n    } else {\n        std::cerr << "Failed to initialize COM in main thread." << std::endl;\n    }\n    return 0;\n}