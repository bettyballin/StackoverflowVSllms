#include "stdafx.h"\n#include "YourDialog.h"\n\nint CALLBACK WinMain(HINSTANCE hInstance, HINSTANCE hPrevInstance, LPSTR lpCmdLine, int nCmdShow)\n{\n    // Initialize COM\n    CoInitialize(NULL);\n\n    // Create a COM instance of your UserControl\n    IDotNetControl* pDotNetControl = NULL;\n    HRESULT hr = CoCreateInstance(CLSID_dontnetcontrolClass, NULL, CLSCTX_INPROC_SERVER, IID_IDotNetControl, (void**)&pDotNetControl);\n    if (SUCCEEDED(hr))\n    {\n        // Create a CDialog instance\n        CYourDialog dlg;\n        dlg.DoModal();\n\n        // Add the UserControl to the CDialog\n        CRect rect(10, 10, 200, 200);\n        pDotNetControl->CreateControl(rect, &dlg, 100);\n    }\n\n    // Clean up\n    CoUninitialize();\n    return 0;\n}