#!/bin/bash\n\n   # Define the allowed upload directory based on the SSH key\n   case "$SSH_ORIGINAL_COMMAND" in\n       "scp -t /allowed/directory1/*")\n           exec /usr/bin/scp -t /allowed/directory1\n           ;;\n       "scp -t /allowed/directory2/*")\n           exec /usr/bin/scp -t /allowed/directory2\n           ;;\n       *)\n           echo "This action is restricted."\n           exit 1\n           ;;\n   esac