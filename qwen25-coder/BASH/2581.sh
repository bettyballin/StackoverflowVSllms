awk '{if (NR==32 || (NR-32) % 15 == 0) print "#" $0; else print}' inputfile.txt > outputfile.txt