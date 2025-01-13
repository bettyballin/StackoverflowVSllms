def get_first_16_bits(hex_num):\n    num = int(hex_num, 16)\n    return hex((num >> 16) & 0xFFFF)[2:]\n\n# Example usage:\nhex_num = "12345678"\nfirst_16_bits = get_first_16_bits(hex_num)\nprint(first_16_bits)  # Output: 1234