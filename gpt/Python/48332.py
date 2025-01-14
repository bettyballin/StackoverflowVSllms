import rarfile\n\ndef extract_rar(file_path, extract_path):\n    with rarfile.RarFile(file_path) as rf:\n        rf.extractall(path=extract_path)\n\n# Example usage\nextract_rar('example.rar', 'extracted_files')