# Original C Compiler:\n# CC=gcc\n\n# For AmigaOS:\nCC=m68k-amigaos-gcc\n\n# Include paths for standard libraries and headers:\nCFLAGS += -I/path/to/amigasdk/include \\n          -nostdlib \n\n# Linker flags pointing to system libraries:\nLDFLAGS += -L/path/to/amigasdk/lib/nix -lc -lm\n\n# Example target:\nprogram: source.c\n    $(CC) $(CFLAGS) -o program source.c $(LDFLAGS)