RPC_STATUS status;\nRPC_IF_HANDLE ifHandle;\n\n// Register the RPC interface\nstatus = RpcServerRegisterEpEx(\n    ifHandle, // RPC interface handle\n    NULL, // Binding handle\n    NULL, // UUID vector\n    RPC_IF_ALLOW_LOCAL_ONLY, // Flags\n    NULL // Reserved\n);\n\nif (status != RPC_S_OK) {\n    // Handle error\n}