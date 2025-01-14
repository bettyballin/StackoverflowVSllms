import codecs\nfrom charset_normalizer import from_bytes\n\ndef detect_encoding(file_path):\n    with open(file_path, 'rb') as file:\n        raw_data = file.read()\n        result = from_bytes(raw_data).best()\n        if result:\n            return result.encoding\n        else:\n            return None\n\nfile_path = 'your_file.txt'\nencoding = detect_encoding(file_path)\nprint(f"Detected encoding: {encoding}")