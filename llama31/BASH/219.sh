awk -F ": " '{a[$1]=$2} END {for (i in a) printf "%s,", i; print ""; for (i in a) printf "%s,", a[i]; print ""}' | sed 's/,$//'