def crc_remainder(data_bits, divisor):\n    # Append zeros equal to the degree of the divisor - 1\n    padded_data = data_bits + '0' * (len(divisor) - 1)\n    \n    while len(padded_data) >= len(divisor):  # Check if we can still divide\n        shifted_divisor_len = len(divisor)\n        shifted_divisor = padded_data[:shifted_divisor_len]\n        \n        xor_result = ''.join('1' if d != i else '0'\n                             for d, i in zip(shifted_divisor, divisor))\n        \n        # Calculate the new data after finding the remainder\n        padded_data = xor_result + padded_data[shifted_divisor_len:]\n        # Remove leading zeros except one because that's not what we want to remove.\n        padded_data = padded_data.lstrip('0') or '0'\n    \n    return padded_data\n\ndata_bits = "101101000"\ndivisor = "1010"\n\nremainder = crc_remainder(data_bits, divisor)\nprint(f"CRC remainder: {remainder.zfill(len(divisor) - 1)}")