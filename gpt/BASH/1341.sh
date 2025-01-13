# Makefile\n\n# Default build type\nBUILD_TYPE ?= debug\n\nCFLAGS_DEBUG = -g -O0\nCFLAGS_RELEASE = -O2\n\nifeq ($(BUILD_TYPE), debug)\n    CFLAGS = $(CFLAGS_DEBUG)\nelse ifeq ($(BUILD_TYPE), release)\n    CFLAGS = $(CFLAGS_RELEASE)\nendif\n\n# Example targets\nall: my_program\n\nmy_program: main.o math.o\n    $(CC) $(CFLAGS) -o my_program main.o math.o\n\nmain.o: main.c\n    $(CC) $(CFLAGS) -c main.c\n\nmath.o: math.c\n    $(CC) $(CFLAGS) -c math.c\n\nclean:\n    rm -f *.o my_program