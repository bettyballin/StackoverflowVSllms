awk '/foo/ {sub(/foo/, "&_" sprintf("%02d",++c))} 1' infile