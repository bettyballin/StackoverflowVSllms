#!/bin/bash\n\n# Set the server and base directory\nSERVER="your_server_ip"\nBASE_DIR="/path/to/base/directory"\n\n# Get the subdirectory from the command line argument\nSUBDIR=$1\n\n# SSH to the server and run the svn update command\nssh $SERVER "cd $BASE_DIR/$SUBDIR && svn update"