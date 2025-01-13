#!/bin/bash\n\n# Get current time in seconds since epoch\nnow=$(date +%s)\n\nfor pid in $(ps -e -o pid=) ; do\n    # Check if the process can access file descriptors\n    fslastaccess=$(lsof -p $pid -F at | tail -n 1 | cut -c3-)\n    if [ -n "$fslastaccess" ]; then\n        # Get the last access time in seconds since epoch\n        last_access_time=$(stat -c %Y /proc/$pid/fd/* 2>/dev/null | sort -nr | head -n 1)\n        # Calculate elapsed time\n        elapsed=$((now - last_access_time))\n        # Check if process was inactive for more than 30 minutes (1800 seconds)\n        if [ "$elapsed" -gt 1800 ]; then\n            ps -o pid,etime,cmd= $pid\n        fi\n    fi\ndone