for file in file*.c; do\n  myprocess "$(gcc -E "$file")"\ndone