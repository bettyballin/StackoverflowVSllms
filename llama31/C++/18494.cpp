#include <Windows.h>\n#include <objbase.h>\n\nint main() {\n    // Initialize COM for single-threaded apartment\n    HRESULT hr = CoInitialize(NULL);\n    if (FAILED(hr)) {\n        // Handle failure\n        return 1;\n    }