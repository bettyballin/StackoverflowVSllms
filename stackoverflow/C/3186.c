DWORD myprocID = 1234; // your main process id\n\nPROCESSENTRY32 pe;\n\nmemset(&pe, 0, sizeof(PROCESSENTRY32));\npe.dwSize = sizeof(PROCESSENTRY32);\n\nHANDLE hSnap = :: CreateToolhelp32Snapshot(TH32CS_SNAPPROCESS, 0);\n\nif (::Process32First(hSnap, &pe))\n{\n    BOOL bContinue = TRUE;\n\n    // kill child processes\n    while (bContinue)\n    {\n        // only kill child processes\n        if (pe.th32ParentProcessID == myprocID)\n        {\n            HANDLE hChildProc = ::OpenProcess(PROCESS_ALL_ACCESS, FALSE, pe.th32ProcessID);\n\n            if (hChildProc)\n            {\n                ::TerminateProcess(hChildProc, 1);\n                ::CloseHandle(hChildProc);\n            }               \n        }\n\n        bContinue = ::Process32Next(hSnap, &pe);\n    }\n\n    // kill the main process\n    HANDLE hProc = ::OpenProcess(PROCESS_ALL_ACCESS, FALSE, myprocID);\n\n    if (hProc)\n    {\n        ::TerminateProcess(hProc, 1);\n        ::CloseHandle(hProc);\n    }       \n}