import struct\n\n# Example string\ns = "123"\n\n# Converting to integer types\nint8 = int(s) & 0xFF         # 8-bit signed\nuint8 = int(s) & 0xFF        # 8-bit unsigned\nint16 = int(s) & 0xFFFF      # 16-bit signed\nuint16 = int(s) & 0xFFFF     # 16-bit unsigned\nint32 = int(s) & 0xFFFFFFFF  # 32-bit signed\nuint32 = int(s) & 0xFFFFFFFF # 32-bit unsigned\nint64 = int(s)               # 64-bit signed (Python int is unbounded)\nuint64 = int(s)              # 64-bit unsigned (Python int is unbounded)\n\nprint(int8, uint8, int16, uint16, int32, uint32, int64, uint64)