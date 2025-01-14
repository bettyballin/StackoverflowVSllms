import struct\n\nwith open("hi.bmp", "rb") as fin:\n    # Read the BMP file signature\n    firm = fin.read(2)\n    \n    if firm != b'BM':\n        raise ValueError("Not a valid BMP file")\n    \n    # Read the file size (4 bytes) and unpack it as an integer\n    file_size_bytes = fin.read(4)\n    file_size = struct.unpack('<I', file_size_bytes)[0]\n\nprint(f"Firm: {firm}, File Size: {file_size}")