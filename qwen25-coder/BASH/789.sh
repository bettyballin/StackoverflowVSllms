#!/bin/bash\n\nLOCKFILE="/tmp/my_script.lock"\n\nif [ -f "$LOCKFILE" ]; then\n    echo "Already running!"\n    exit 1\nfi\n\n# Create the lockfile\ntouch $LOCKFILE\n\n# Your script logic here\necho "Running script..."\n\n# Remove the lock file when done\ntrap 'rm -f "$LOCKFILE"; exit $?' SIGINT SIGTERM EXIT\n\n# Simulate some work with a sleep command\nsleep 50\n\n# End of script