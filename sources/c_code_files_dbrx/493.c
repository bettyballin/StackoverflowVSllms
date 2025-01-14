#include <windows.h>
#include <stdbool.h>

BOOL APIENTRY DllMain(HMODULE hModule, DWORD ul_reason_for_call, LPVOID lpReserved) {
   switch (ul_reason_for_call) {
      case DLL_PROCESS_ATTACH:
         // DLL is being loaded. Return true on success.
         break;
      case DLL_THREAD_ATTACH:
         // A new thread in the process is using this dll. Do anything necessary for this case.
         break;
      case DLL_THREAD_DETACH:
         // Thread terminating use of this dll. Clean up stuff as needed.
         break;
      case DLL_PROCESS_DETACH:
         // Process detaching from the dll. This occurs when a process is terminated or FreeLibrary() is called on your dll.
         break;
   }
   return TRUE;  // Return true if dll successfully attached, failed to attach otherwise.
}