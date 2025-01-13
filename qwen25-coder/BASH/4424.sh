# Using awk\nawk '{print $3}' in.txt | sort -u > unique_col3.txt\n\n# Using cut and sort\ncut -d' ' -f3 in.txt | sort -u > unique_col3.txt\n\n# Using perl\nperl -lane 'print $F[2] unless $seen{$F[2]}++' in.txt | sort -u > unique_col3.txt\n\n# Using sed and sort\nsed 's/.*\s\(\S\+\)$/\1/' in.txt | sort -u > unique_col3.txt