import chardet\n\ndef detect_encoding(file_path):\n    with open(file_path, 'rb') as file:\n        raw_data = file.read()\n        result = chardet.detect(raw_data)\n        encoding = result['encoding']\n        confidence = result['confidence']\n        return encoding, confidence\n\nfile_path = 'path/to/your/file.txt'\nencoding, confidence = detect_encoding(file_path)\n\nprint(f"Detected encoding: {encoding} with confidence: {confidence}")