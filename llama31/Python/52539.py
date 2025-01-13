import portalocker\n\ndef open_exclusive(path, mode):\n    with portalocker.Lock(path, mode, timeout=1) as lock:\n        return open(path, mode)\n\n# Example usage:\npath = "example.txt"\n\n# Open for reading, but only if not already opened for writing\ntry:\n    with open_exclusive(path, "r") as file:\n        print(file.read())\nexcept portalocker.LockException:\n    print("File is already opened for writing")\n\n# Open for writing, but only if not already opened for reading or writing\ntry:\n    with open_exclusive(path, "w") as file:\n        file.write("Hello, world!")\nexcept portalocker.LockException:\n    print("File is already opened for reading or writing")