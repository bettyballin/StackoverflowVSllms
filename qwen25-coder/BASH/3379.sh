#!/bin/bash\n\nLOCKFILE="/var/run/my_cron_job.lock"\n\n# If the lockfile exists, exit\nif [[ -f $LOCKFILE ]]; then\n    echo "Job is already running."\n    exit 1\nfi\n\n# Create the lockfile\ntouch $LOCKFILE\n\n# Your job commands here\necho "Running my job..."\nsleep 600  # Simulate a long-running task\n\n# Delete the lockfile before exiting\nrm -f $LOCKFILE\n\nexit 0