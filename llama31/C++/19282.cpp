unsigned Counter = 0;\nHANDLE hExitEvent;\n\nvoid f()\n{\n    HANDLE hThread;\n    unsigned threadID;\n\n    // Create the exit event\n    hExitEvent = CreateEvent(NULL, FALSE, FALSE, NULL);\n\n    // Create the second thread.\n    hThread = (HANDLE)_beginthreadex(NULL, 0, DoSomething, NULL, 0, &threadID);\n\n    if (WAIT_TIMEOUT == WaitForSingleObject(hThread, 5000))\n    {\n        // Signal the thread to exit\n        SetEvent(hExitEvent);\n        WaitForSingleObject(hThread, INFINITE); // Wait for the thread to exit cleanly\n        wcout << L"Process is Timed Out";\n    }\n    else\n    {\n        wcout << L"Process is Ended OK";\n    }\n\n    CloseHandle(hThread);\n    CloseHandle(hExitEvent);\n\n    wcout << Counter;\n}\n\nunsigned int _stdcall DoSomething(void* /*dummy*/)\n{\n    while (1)\n    {\n        if (WaitForSingleObject(hExitEvent, 0) == WAIT_OBJECT_0)\n        {\n            // Exit the thread cleanly\n            break;\n        }\n        ++Counter;\n    }\n    _endthreadex(0);\n    return 0;\n}