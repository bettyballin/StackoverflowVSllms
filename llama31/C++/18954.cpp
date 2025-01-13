#include <iphonesdk.h>\n\nIPhone* pPhone = NULL;\n\n// Initialize the phone interface\nHRESULT hr = CoCreateInstance(CLSID_Phone, NULL, CLSCTX_INPROC_SERVER, IID_IPhone, (LPVOID*)&pPhone);\n\nif (SUCCEEDED(hr))\n{\n    DWORD dwGPRSUsage = 0;\n    hr = pPhone->GetGPRSUsage(&dwGPRSUsage);\n\n    if (SUCCEEDED(hr))\n    {\n        // dwGPRSUsage contains the total GPRS usage in KBs\n    }\n\n    // Release the phone interface\n    pPhone->Release();\n}