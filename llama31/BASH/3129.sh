tail -n +$((lines_to_delete + 1)) log.txt > log.txt.tmp\nmv log.txt.tmp log.txt