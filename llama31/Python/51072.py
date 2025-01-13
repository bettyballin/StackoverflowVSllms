import struct\n\ndef decode_darwin_descriptor(descriptor):\n    # Unpack the binary data\n    unpacked = struct.unpack('IHH', descriptor[:8])\n    # Extract the flags, clsid, and dll name\n    flags, clsid, dll_name_len = unpacked\n    dll_name = descriptor[8:8+dll_name_len].decode('utf-16le')\n    return flags, clsid, dll_name\n\n# Example usage:\ndescriptor = b'\x01\x02\x03\x04\x05\x06\x07\x08\x09\x0a\x0b\x0c'\nflags, clsid, dll_name = decode_darwin_descriptor(descriptor)\nprint(f'Flags: {flags}, CLSID: {clsid}, DLL Name: {dll_name}')