import os.path\n\nfilename = "A 180 mb large file.data"\nsize = os.path.getsize(filename)\n\n# Open the file in binary read mode\nwith open(filename, "rb") as f:\n    contents = f.read()\nprint("The real filesize is", size)\nprint("The read filesize is", len(contents))\n\n# Read the file in chunks of 4 bytes in binary mode\nwith open(filename, "rb") as f:\n    size = 0\n    while True:\n        contents = f.read(4)\n        if not contents: \n            break\n        size += len(contents)\n\nprint("this time it's", size)