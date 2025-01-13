// main.cpp\n#include <iostream>\n#include <Windows.h>\n#include <metahost.h>\n#pragma comment(lib, "mscoree.lib")\n\nint main()\n{\n    ICLRMetaHost* pMetaHost = nullptr;\n    ICLRRuntimeInfo* pRuntimeInfo = nullptr;\n    ICLRRuntimeHost* pRuntimeHost = nullptr;\n\n    // Start the CLR\n    HRESULT hr = CLRCreateInstance(CLSID_CLRMetaHost, IID_PPV_ARGS(&pMetaHost));\n    if (FAILED(hr)) { std::cerr << "CLRCreateInstance failed" << std::endl; return -1; }\n\n    hr = pMetaHost->GetRuntime(L"v4.0.30319", IID_PPV_ARGS(&pRuntimeInfo));\n    if (FAILED(hr)) { std::cerr << "GetRuntime failed" << std::endl; return -1; }\n\n    hr = pRuntimeInfo->GetInterface(CLSID_CLRRuntimeHost, IID_PPV_ARGS(&pRuntimeHost));\n    if (FAILED(hr)) { std::cerr << "GetInterface failed" << std::endl; return -1; }\n\n    hr = pRuntimeHost->Start();\n    if (FAILED(hr)) { std::cerr << "CLR Start failed" << std::endl; return -1; }\n\n    // Call the C# method\n    DWORD dwRet = 0;\n    hr = pRuntimeHost->ExecuteInDefaultAppDomain(\n        L"MyLibrary.dll", L"MyLibrary.MyClass", L"MyMethod", L"", &dwRet);\n    if (FAILED(hr)) { std::cerr << "ExecuteInDefaultAppDomain failed" << std::endl; return -1; }\n\n    // Clean up\n    pRuntimeHost->Release();\n    pRuntimeInfo->Release();\n    pMetaHost->Release();\n\n    return 0;\n}