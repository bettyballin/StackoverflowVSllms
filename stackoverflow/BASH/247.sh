awk 'f==1{print last}{last=$0;f=1}END{print "NEW WORD\n"$0}' file 