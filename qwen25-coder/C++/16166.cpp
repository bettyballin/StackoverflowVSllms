#include <atlcomcli.h>\nCComPtr<IMyInterface> spMyObject;\nhr = spMyObject.CoCreateInstance(CLSID_MyServer);\nif (FAILED(hr)) {\n    CoUninitialize();\n    return -1; // Failed to create server instance.\n}