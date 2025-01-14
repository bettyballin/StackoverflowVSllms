# Example of opening and closing a file without using 'with'\nf = open('somefile.txt', 'w')\nf.write('Hello, world!')\ndel f  # The file object is now deleted\n\n# At this point, if there are no other references to the file,\n# the garbage collector will free it, and the file will be closed.