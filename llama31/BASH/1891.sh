`perl -c script.pl 1>stdoutfile 2>stderrfile`;\nif ($?) {\n    print "Compilation failed\n";\n} else {\n    print "Compilation successful\n";\n}