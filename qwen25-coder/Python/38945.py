import struct\n\ndef read_ccf_header(file_path):\n    with open(file_path, 'rb') as file:\n        # Example header format: 2 bytes for version. Modify according to actual format.\n        magic = file.read(4)  # Read magic number or identifier (example size)\n        if magic != b'CVCV':  # Hypothetical magic number; replace with the actual one\n            raise ValueError("Invalid CCF file")\n        version = struct.unpack('<H', file.read(2))[0]  # Little-endian short for version\n        \n    return {\n        'magic': magic,\n        'version': version\n    }\n\n# Usage example:\ntry:\n    header_info = read_ccf_header('example.ccf')\n    print(header_info)\nexcept Exception as e:\n    print(e)