#!/bin/bash\n\n# Function to handle cleanup on exit\ncleanup() {\n  echo "Interrupt received, killing remote process..."\n  ssh -n -x root@db-host 'pkill -f "mysqldump db"'\n  exit 1\n}\n\n# Set trap to catch Ctrl+C (SIGINT) and call cleanup function\ntrap cleanup SIGINT\n\n# Execute the remote command\nssh -n -x root@db-host 'mysqldump db' -r file.sql