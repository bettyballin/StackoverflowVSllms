import os.path\n\nfilename = "A 180 mb large file.data"\nsize = os.path.getsize(filename)\n\nf = open(filename, "rb")\ncontents = f.read()\nf.close()\n\nprint("The real filesize is", size)\nprint("The read filesize is", len(contents))\n\nf = open(filename, "rb")\nsize = 0\n\nwhile True:\n    contents = f.read(4)\n    if not contents:\n        break\n    size += len(contents)\n\nf.close()\n\nprint("this time it's", size)