#include <comdef.h>\n#include <windows.h>\n\nvoid exampleBSTR() {\n    BSTR bstr = SysAllocString(L"Hello, World!");\n    // Use the BSTR...\n    wprintf(L"%s\n", bstr);\n    // Free the BSTR when done.\n    SysFreeString(bstr);\n}