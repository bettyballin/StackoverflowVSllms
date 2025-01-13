[DllImport("rpcrt4.dll", SetLastError = true)]\nstatic extern int UuidCreateSequential(out Guid guid);\n\npublic static Guid SequentialGuid()\n{\n    const int RPC_S_OK = 0;\n    Guid g;\n    if (UuidCreateSequential(out g) != RPC_S_OK)\n        return Guid.NewGuid();\n    else\n        return g;\n}