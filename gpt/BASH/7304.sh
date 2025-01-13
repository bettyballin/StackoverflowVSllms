#!/bin/bash\n\nIP=xxx.xxx.xxx.xx\nREMOTE_EXEC="ssh $IP -l root"\n\n# The following command launches vmstat in the background and captures its PID\nPID=$($REMOTE_EXEC 'vmstat 1 1000 > vmstat.log & echo $!')\n\n# Launch apache benchmark\nab -n 10 http://$IP/\n\n# Kill the remote job using the captured PID\n$REMOTE_EXEC "kill $PID"