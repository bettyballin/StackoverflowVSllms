// Declare the SetConsoleCtrlHandler function\n// as external and receiving a delegate.\n[DllImport("Kernel32")]\npublic static extern bool SetConsoleCtrlHandler(HandlerRoutine Handler, bool Add);\n\n// A delegate type to be used as the handler routine\n// for SetConsoleCtrlHandler.\npublic delegate bool HandlerRoutine(CtrlTypes CtrlType);\n\n// An enumerated type for the control messages\n// sent to the handler routine.\npublic enum CtrlTypes\n{\n    CTRL_C_EVENT = 0,\n    CTRL_BREAK_EVENT,\n    CTRL_CLOSE_EVENT,\n    CTRL_LOGOFF_EVENT = 5,\n    CTRL_SHUTDOWN_EVENT\n}\n\nprivate static bool ConsoleCtrlCheck(CtrlTypes ctrlType)\n{\n    // Put your own handler here\n    return true;\n}\n\n...\n\nSetConsoleCtrlHandler(new HandlerRoutine(ConsoleCtrlCheck), true);