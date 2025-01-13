static _AtlModule _AtlModule;\n\nextern "C" INT APIENTRY _tWinMain(HINSTANCE hInstance, HINSTANCE /*hPrevInstance*/, LPTSTR lpCmdLine, int nShowCmd)\n{\n    HRESULT hRes = ::CoInitialize(NULL);\n    // Make sure ATL is initialized for this thread\n    ATLASSERT(SUCCEEDED(hRes));\n\n    AtlInitCommonControls(ICC_WIN95_CLASSES);\n\n    _AtlModule.Init(ObjectMap, hInstance, &LIBID_RTDSrvLib);\n    int nRet = _AtlModule.WinMain(nShowCmd);\n\n    _AtlModule.Term();\n\n    ::CoUninitialize();\n    return nRet;\n}