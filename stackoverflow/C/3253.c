BOOL UpdateDll(LPCTSTR dll_name, WHATEVER whatever) {\n  int tries = 150;\n  while (tries--) {\n    if (TryUpdateDll(dll_name, whatever))\n      return TRUE;\n    Sleep(200);\n  }\n  return FALSE;\n}