#!/bin/bash\n\nURL="http://127.0.0.1/server-status?auto"\n\n# Curl the stats, filter out Total Accesses & Uptime, then do math.\nwhile true; do\n    accesses=$(curl -s $URL | grep "Total Accesses" | awk '{print $3}')\n    uptime=$(curl -s $URL | grep "Uptime" | awk '{print $2}')\n\n    rps=$(echo "$accesses / $uptime" | bc -l)\n    \n    echo "Requests per second: $rps"\n    sleep 60\ndone