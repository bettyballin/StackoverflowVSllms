// ProcessWorkerThread.h\nclass CProcessWorkerThread : public CWinThread {\npublic:\n    static CProcessWorkerThread* CreateInstance(LPCTSTR lpAppName, LPCTSTR szCmdLineBuffer);\n\nprotected:\n    virtual BOOL InitInstance();\n    virtual int ExitInstance();\n\nprivate:\n    CString m_strAppName;\n    CString m_strCmdLineBuffer;\n\n    CProcessWorkerThread(LPCTSTR lpAppName, LPCTSTR szCmdLineBuffer);\n};\n\n// ProcessWorkerThread.cpp\n#include "stdafx.h"\n#include "YourProjectNameHere.h"\n#include "ProcessWorkerThread.h"\n\nBEGIN_MESSAGE_MAP(CProcessWorkerThread, CWinThread)\nEND_MESSAGE_MAP()\n\nCProcessWorkerThread* CProcessWorkerThread::CreateInstance(LPCTSTR lpAppName, LPCTSTR szCmdLineBuffer) {\n    return (CProcessWorkerThread*) AfxBeginThread(RUNTIME_CLASS(CProcessWorkerThread), NULL, THREAD_PRIORITY_NORMAL,\n                                                 0, CREATE_SUSPENDED, NULL, NULL);\n}\n\nCProcessWorkerThread::CProcessWorkerThread(LPCTSTR lpAppName, LPCTSTR szCmdLineBuffer)\n: m_strAppName(lpAppName),\n  m_strCmdLineBuffer(szCmdLineBuffer) {\n}\n\nBOOL CProcessWorkerThread::InitInstance() {\n    SECURITY_ATTRIBUTES sa;\n    ZeroMemory(&sa, sizeof(sa));\n    sa.nLength = sizeof(sa);\n    sa.bInheritHandle = TRUE;\n\n    STARTUPINFO si;\n    PROCESS_INFORMATION pi;\n    ZeroMemory(&si, sizeof(si));\n    si.cb = sizeof(si);\n    ZeroMemory(&pi, sizeof(pi));\n\n    if (!::CreateProcess(m_strAppName, const_cast<LPWSTR>(m_strCmdLineBuffer.GetBuffer()), NULL, NULL, FALSE,\n                         CREATE_NEW_CONSOLE, NULL, NULL, &si, &pi)) {\n        TRACE0("Failed to create process\n");\n        return CWinThread::InitInstance();\n    }\n\n    ::WaitForSingleObject(pi.hProcess, INFINITE);\n    ::CloseHandle(pi.hProcess);\n    ::CloseHandle(pi.hThread);\n\n    PostMessage(WM_QUIT); // Signal the main thread we're done\n    return CWinThread::InitInstance();\n}\n\nint CProcessWorkerThread::ExitInstance() {\n    return CWinThread::ExitInstance();\n}\n\n// In your application code to launch the process\nvoid LaunchExternalApp(LPCTSTR lpAppName, LPCTSTR szCmdLineBuffer) {\n    // Create and start the worker thread\n    CProcessWorkerThread* pThread = CProcessWorkerThread::CreateInstance(lpAppName, szCmdLineBuffer);\n    if (pThread != nullptr) {\n        pThread->ResumeThread(); // Start execution on a separate thread\n    }\n}