HRESULT hr = CoInitializeEx(NULL, COINIT_MULTITHREADED);\nif (SUCCEEDED(hr)) {\n    // Call into the DLL\n    CoUninitialize();\n} else {\n    // Handle the error\n}