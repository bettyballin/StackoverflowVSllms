# Define paths for compiler and flags\nCC=gcc\nCFLAGS=-Wall -g\n\n# Targets\ntarget: main.o utils.o\n	$(CC) $(CFLAGS) -o myprogram main.o utils.o\n\nmain.o: main.c\n	$(CC) $(CFLAGS) -c main.c\n\nutils.o: utils.c\n	$(CC) $(CFLAGS) -c utils.c\n\nclean:\n	rm -f *.o myprogram