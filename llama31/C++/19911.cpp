int main()\n{\n    IMyComInterface* pServer;\n    HRESULT hr = CoCreateInstance(CLSID_MyComServer, NULL, CLSCTX_LOCAL_SERVER, IID_IMyComInterface, (LPVOID*)&pServer);\n    if (SUCCEEDED(hr))\n    {\n        pServer->MyMethod();\n        pServer->Release();\n    }\n    return 0;\n}