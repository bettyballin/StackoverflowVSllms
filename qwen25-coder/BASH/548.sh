for file in *.txt; do\n    sed -i.bak 's/Release: \([0-9]\+\)/Release: $((\1 + 1))/' "$file"\ndone