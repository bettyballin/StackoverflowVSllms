gcc -pg -o my_program my_program.c -lpthread\n./my_program\ngprof my_program gmon.out > analysis.txt