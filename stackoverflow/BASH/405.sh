awk 'BEGIN{ i=0; } \\n    {if (FNR<31) {print $0} \\n     else {i++; if (i%15) {print $0} else {printf "#%s\n",$0}}\\n    }' inputfile.txt > outputfile.txt