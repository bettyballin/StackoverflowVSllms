#include <Windows.h>\n\n// ...\n\nHRESULT hr = // some COM function that returns an HRESULT\nif (FAILED(hr)) {\n    char errorMessage[1024];\n    FormatMessage(FORMAT_MESSAGE_FROM_SYSTEM, NULL, hr, \n                  MAKELANGID(LANG_ENGLISH, SUBLANG_DEFAULT), errorMessage, 1024, NULL);\n    // errorMessage now contains a human-readable description of the error\n}