// Using a function from a DLL in C\n  #include <windows.h>\n  typedef void (*FunctionType)();\n  \n  int main() {\n      HINSTANCE hInst = LoadLibrary("mydll.dll");\n      if (hInst != NULL) {\n          FunctionType myFunction = (FunctionType)GetProcAddress(hInst, "MyFunction");\n          if (myFunction != NULL) {\n              myFunction();\n          }\n          FreeLibrary(hInst);\n      }\n      return 0;\n  }