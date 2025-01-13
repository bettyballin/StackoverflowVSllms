#include <windows.h>\n#include <objbase.h> // For CoMarshalInterThreadInterfaceInStream\n\n// Assuming Range is defined in some way\n\nstruct ThreadParameters {\n    SOCKET sock;\n    LPSTREAM pStm;\n};\n\nDWORD WINAPI ThreadProc(LPVOID lpParam) {\n    ThreadParameters* params = static_cast<ThreadParameters*>(lpParam);\n\n    // Unmarshal the IRange pointer from the stream\n    RangePtr pRange;\n    HRESULT hr = CoGetInterfaceAndReleaseStream(params->pStm, IID_PPV_ARGS(&pRange));\n\n    if (SUCCEEDED(hr)) {\n        // Use pRange and params->sock\n    }\n\n    delete params; // Clean up allocated memory\n\n    return 0;\n}\n\nvoid CreateMyThread(SOCKET sock, RangePtr pRange) {\n    // Marshal the IRange pointer to a stream\n    LPSTREAM pStm = nullptr;\n    HRESULT hr = CoMarshalInterThreadInterfaceInStream(IID_PPV_ARGS(&pStm), pRange);\n    \n    if (FAILED(hr)) {\n        // Handle error\n        return;\n    }\n\n    ThreadParameters* params = new ThreadParameters{ sock, pStm };\n\n    HANDLE hThread = CreateThread(\n        NULL,                   // default security attributes\n        0,                      // use default stack size  \n        ThreadProc,             // thread function name\n        params,                 // argument to thread function \n        0,                      // use default creation flags \n        NULL                    // returns the thread identifier \n    );\n\n    if (hThread == NULL) {\n        CoTaskMemFree(pStm); // Free stream memory if thread creation fails\n        delete params;       // Clean up allocated memory\n        // Handle error\n    }\n}