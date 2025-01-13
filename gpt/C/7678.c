HANDLE hEvent = CreateEvent(NULL, FALSE, FALSE, TEXT("testevt"));\nif (hEvent == NULL) {\n    // handle error\n}\n\n// Log thread ID and event creation\nprintf("Thread #%d created event 'testevt'.\n", GetCurrentThreadId());\n\n// Signal the event\nSetEvent(hEvent);\n\n// Log thread ID and event signaling\nprintf("Thread #%d signaled event 'testevt'.\n", GetCurrentThreadId());