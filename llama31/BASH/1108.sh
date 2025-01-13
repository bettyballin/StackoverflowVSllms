@echo off\n\nset PATH=C:\MinGW\bin;%PATH%\n\necho Now compiling, assembling, and linking the core:\n\nnasm -f aout -o start.o start.asm\n\ngcc -Wall -O -I./include -c -o consoleio.o consoleio.c\ngcc -Wall -O -I./include -c -o core.o core.c\ngcc -Wall -O -I./include -c -o system.o system.c\n\nld -T link.ld -o core.bin start.o core.o system.o consoleio.o\n\necho Done!\n\nconcat.py\n\npause