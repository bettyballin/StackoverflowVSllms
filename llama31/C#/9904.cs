private static bool ConsoleCtrlCheck(CtrlTypes ctrlType)\n{\n    if (ctrlType == CtrlTypes.CTRL_CLOSE_EVENT)\n    {\n        while (true)\n        {\n            // Do something to delay the termination, e.g., sleep for a second\n            Thread.Sleep(1000);\n        }\n    }\n    return true;\n}