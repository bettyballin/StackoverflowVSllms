import tarfile\nfrom io import BytesIO\n\n# Create a TarInfo object\ntar_info = tarfile.TarInfo('string.txt')\ntar_info.size = len(b'Hello, World!')\n\n# Create a file-like object for the string\nstring_io = BytesIO(b'Hello, World!')\n\n# Open the tarfile\nwith tarfile.open('output.tar', 'w') as tar:\n    # Add the string to the tarfile\n    tar.addfile(tar_info, string_io)