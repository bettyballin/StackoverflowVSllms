import win32api\n\n# Copy a file\nsrc = 'C:\\path\\to\\source\\file.txt'\ndst = 'C:\\path\\to\\destination\\file.txt'\nwin32api.CopyFile(src, dst, 0)  # 0 means overwrite if exists