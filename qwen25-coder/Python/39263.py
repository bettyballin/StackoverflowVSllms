# Recommended way to open and close a file using 'with'\nwith open('somefile.txt', 'w') as f:\n    f.write('Hello, world!')\n# The file is automatically closed when exiting the block