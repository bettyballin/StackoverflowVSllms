void Printer::Queue(const PrintJob& job)\n{\n    // Validate the state in both release and debug builds.\n    // Break into the debugger in debug builds.\n    // Never proceed with the queuing in a bad state.\n    // This object will likely never again succeed in queuing anything.\n    if(!IsValidState())\n    {\n        DebugBreak();\n        return;\n    }\n\n    // Continue with queuing.\n    // Internal state is guaranteed to be good.\n}