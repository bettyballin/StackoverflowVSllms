import filecmp\n\ndef are_files_equal(file1, file2):\n    return filecmp.cmp(file1, file2)\n\n# Example usage:\nfile1 = "path/to/file1.txt"\nfile2 = "path/to/file2.txt"\nif are_files_equal(file1, file2):\n    print("Files are equal")\nelse:\n    print("Files are not equal")