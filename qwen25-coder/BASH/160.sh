#!/bin/bash\n\n# Define source and destination directories\nSOURCE_DIR="/path/to/source"\nDEST_DIR="user@remote:/path/to/destination"\n\n# Define time period (e.g., last 24 hours)\nDURATION=24H\n\n# Create a tar archive of recently modified files and pipe it to rsync\nfind "$SOURCE_DIR" -type f -mtime -$DURATION -exec tar cf - {} + | \\n    ssh "user@remote" "(cd /path/to/destination; tar xf -)"