#include <windows.h>

int WINAPI WinMain(HINSTANCE hInstance, HINSTANCE hPrevInstance, LPSTR lpCmdLine, int nCmdShow){
   // Set the directory path where libxml2 dll is located...
   TCHAR szLibraryPath[MAX_PATH] = { 0 };
   GetModuleFileName(NULL, szLibraryPath , MAX_PATH);
   PathRemoveFileSpec(szLibraryPath);
#if defined(_DEBUG)
      lstrcat(szLibraryPath, TEXT("\\Debug")); // path for debug dll
#else
      lstrcat(szLibraryPath, TEXT("\\Release")); // path for release dll
#endif
   SetDllDirectory(szLibraryPath);
   return 0;
}