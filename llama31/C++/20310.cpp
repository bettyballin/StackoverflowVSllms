#ifndef DLLHEADER_H\n#define DLLHEADER_H\n\ntypedef void (*MAIN_FUNC_PTR)();\n\nextern "C" __declspec(dllexport) int WinMain(HINSTANCE hInstance, HINSTANCE hPrevInstance, LPSTR lpCmdLine, int nCmdShow);\n\nvoid setMainFunc(MAIN_FUNC_PTR mainFunc);\n\n#endif // DLLHEADER_H