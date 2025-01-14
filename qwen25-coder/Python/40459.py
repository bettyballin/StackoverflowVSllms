import pythoncom\nfrom comtypes.client import CreateObject\n\n# Path to your OLE Compound Document\nfile_path = r"C:\path\to\your\file.doc"\n\n# Flags for StgOpenStorage\nflags = pythoncom.STGM_READ | pythoncom.STGM_SHARE_DENY_WRITE\n\n# Open the storage in read-only mode without blocking other readers\nstorage = CreateObject("StructuredStorage.Storage", interface=pythoncom.IStorage)\nstorage.OpenStorage(file_path, None, flags, None, 0)\n\n# Now you can work with the storage object to read data