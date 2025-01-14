#include <windows.h>

// Assuming TryUpdateDll is defined elsewhere in the code
BOOL TryUpdateDll(LPCTSTR dll_name, LPVOID whatever);

BOOL UpdateDll(LPCTSTR dll_name, LPVOID whatever) {
  int tries = 150;
  while (tries--) {
    if (TryUpdateDll(dll_name, whatever))
      return TRUE;
    Sleep(200);
  }
  return FALSE;
}