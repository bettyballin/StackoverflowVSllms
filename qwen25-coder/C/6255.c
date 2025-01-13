NTSTATUS MyRegistryCheck(PDEVICE_OBJECT DeviceObject)\n{\n    NTSTATUS status;\n    HANDLE hKey;\n\n    status = ZwOpenKey(&hKey, KEY_READ | KEY_WRITE, &regPath);\n    if (status == STATUS_SUCCESS) {\n        // Registry key is available. Proceed with work.\n        ZwClose(hKey);\n\n        // Unregister the timer or cancel any delayed-work routine here\n        return STATUS_UNLOAD_DRIVER;\n    }\n\n    // If not successful, we need to retry.\n    KeSetTimerEx(&retryTimer, &dueTime, TIMER_PERIOD_MS, &registryCheckDpc);\n    return status;\n}\n\nVOID RegistryCheckDPCRoutine(PKDPC Dpc, PVOID DeferredContext,\n                             PVOID SystemArgument1, PVOID SystemArgument2)\n{\n    MyRegistryCheck(DeviceObject);\n}