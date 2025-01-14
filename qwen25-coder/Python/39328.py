import struct\nimport binascii\n\n# Example binary data\nbinary_data = b'\x00\x10\x20\x30'\n\n# Using struct to interpret binary data as integers\nunpacked_data = struct.unpack('>4B', binary_data)  # Unpack as big-endian bytes\nprint("Unpacked bytes:", unpacked_data)\n\n# Convert to hex for presentation\nhex_representation = binascii.hexlify(binary_data)\nprint("Hex representation:", hex_representation.decode())\n\n# Using bitstring for more complex manipulation\nimport bitstring\n\nbit_string = bitstring.BitArray(bytes=binary_data)\nprint("Binary string:", bit_string.bin)\n\n# Modify endianess (example: reverse bits in each byte)\nreversed_bytes = [byte[::-1] for byte in bit_string.cut(8)]\nreversed_bit_string = ''.join(reversed_bytes)\nprint("Endianness reversed binary string per byte:", reversed_bit_string)