#!/bin/bash\n\nLOCK_FILE=/path/to/lock/file.lock\n\nflock -n "$LOCK_FILE" || exit 1\n\n# your code here