function perlmodver {\n    perl -M$1 -e 'print "Version " . $ARGV[0]->VERSION . " of " . $ARGV[0] . "\nis installed.\n"' $1\n}