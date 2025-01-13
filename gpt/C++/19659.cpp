#include <windows.h>\n#include <iostream>\n\nint main() {\n    STARTUPINFO si;\n    PROCESS_INFORMATION pi;\n    ZeroMemory(&si, sizeof(si));\n    si.cb = sizeof(si);\n    ZeroMemory(&pi, sizeof(pi));\n\n    // Command line to execute\n    LPSTR cmdLine = "java -cp c:\\dir\\updates.jar;c:\\dir\\main.jar Main";\n    \n    // Set the working directory\n    LPCSTR workingDir = "c:\\dir";\n\n    // Create the process\n    if (!CreateProcess(NULL,   // No module name (use command line)\n                       cmdLine,        // Command line\n                       NULL,           // Process handle not inheritable\n                       NULL,           // Thread handle not inheritable\n                       FALSE,          // Set handle inheritance to FALSE\n                       0,              // No creation flags\n                       NULL,           // Use parent's environment block\n                       workingDir,     // Use specified working directory\n                       &si,            // Pointer to STARTUPINFO structure\n                       &pi)            // Pointer to PROCESS_INFORMATION structure\n    ) {\n        std::cerr << "CreateProcess failed (" << GetLastError() << ").\n";\n        return 1;\n    }\n\n    // Wait until child process exits.\n    WaitForSingleObject(pi.hProcess, INFINITE);\n\n    // Close process and thread handles.\n    CloseHandle(pi.hProcess);\n    CloseHandle(pi.hThread);\n\n    return 0;\n}