$file = 'ff.log';\n$last_line = exec("tail -f -n 1 $file");\necho "--$last_line--";