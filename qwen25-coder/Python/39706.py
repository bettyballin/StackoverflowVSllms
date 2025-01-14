import zlib\nimport os\n\ndef calculate_crc(file_path):\n    """Calculate the CRC-32 hash for a file."""\n    with open(file_path, 'rb') as file:\n        crc_value = 0\n        while chunk := file.read(8192):  # Read in chunks to avoid memory issues\n            crc_value = zlib.crc32(chunk, crc_value)\n        return crc_value & 0xFFFFFFFF\n\ndef store_crcs(file_paths, output_file):\n    """Store CRC-32 values for a list of files."""\n    with open(output_file, 'w') as f:\n        for file_path in file_paths:\n            if os.path.isfile(file_path):\n                crc = calculate_crc(file_path)\n                f.write(f'{file_path}: {crc}\n')\n\n# Example usage\nfiles_to_check = ['file1.txt', 'image.png']\nstore_crcs(files_to_check, 'crc_values.txt')