#include <Windows.h>\n\nextern "C" __declspec(dllexport) HBITMAP LoadBitmapResource(int resourceId)\n{\n    HBITMAP hBitmap = LoadBitmap(GetModuleHandle(NULL), MAKEINTRESOURCE(resourceId));\n    return hBitmap;\n}