#include <windows.h>
#include <tlhelp32.h>
#include <stdio.h>

int main() {
    DWORD myprocID = 1234; // your main process id

    PROCESSENTRY32 pe;

    memset(&pe, 0, sizeof(PROCESSENTRY32));
    pe.dwSize = sizeof(PROCESSENTRY32);

    HANDLE hSnap = CreateToolhelp32Snapshot(TH32CS_SNAPPROCESS, 0);

    if (Process32First(hSnap, &pe)) {
        BOOL bContinue = TRUE;

        // kill child processes
        while (bContinue) {
            // only kill child processes
            if (pe.th32ParentProcessID == myprocID) {
                HANDLE hChildProc = OpenProcess(PROCESS_ALL_ACCESS, FALSE, pe.th32ProcessID);

                if (hChildProc) {
                    TerminateProcess(hChildProc, 1);
                    CloseHandle(hChildProc);
                }               
            }

            bContinue = Process32Next(hSnap, &pe);
        }

        // kill the main process
        HANDLE hProc = OpenProcess(PROCESS_ALL_ACCESS, FALSE, myprocID);

        if (hProc) {
            TerminateProcess(hProc, 1);
            CloseHandle(hProc);
        }       
    }

    return 0;
}