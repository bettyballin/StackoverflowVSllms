// Example to set memory protection\n   DWORD oldProtect;\n   VirtualProtect(address, size, PAGE_READONLY, &oldProtect);