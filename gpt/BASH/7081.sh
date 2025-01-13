#!/bin/bash\n\n# Iterate over each argument and execute the command\nfor cmd in "$@"; do\n  eval "$cmd" &\ndone\n\n# Wait for all background processes to finish\nwait