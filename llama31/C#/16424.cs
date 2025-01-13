private readonly SemaphoreSlim[] _slotLocks;\n\npublic RingBuffer(int slots)\n{\n    _slotLocks = new SemaphoreSlim[slots];\n    for (int i = 0; i < slots; i++)\n    {\n        _slotLocks[i] = new SemaphoreSlim(1, 1);\n    }\n}\n\npublic void WriteToSlot(int slot, Data data)\n{\n    _slotLocks[slot].Wait();\n    try\n    {\n        // Write data to slot\n    }\n    finally\n    {\n        _slotLocks[slot].Release();\n    }\n}\n\npublic void ReadFromSlot(int slot, out Data data)\n{\n    _slotLocks[slot].Wait();\n    try\n    {\n        // Read data from slot\n    }\n    finally\n    {\n        _slotLocks[slot].Release();\n    }\n}