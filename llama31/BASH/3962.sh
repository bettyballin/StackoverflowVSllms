gcc -g -o example example.c\nobjdump -dS example | grep -A10 "if (cond)"