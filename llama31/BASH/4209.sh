# Run the program and generate a coredump\n./myprogram\n\n# Open the coredump in gdb\ngdb -c myprogram.core\n\n# Print the backtrace\n(gdb) bt