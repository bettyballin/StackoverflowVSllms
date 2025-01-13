#!/bin/bash\n\nIP=xxx.xxx.xxx.xx\nREMOTE_EXEC="ssh -o 'StrictHostKeyChecking=no' $IP -l root"\n\n# Launch vmstat in the background on the remote machine and get its PID\nPID=$($REMOTE_EXEC "nohup vmstat 1 1000 > vmstat.log & echo \$!")\n\n# Launch apache benchmark\nab -n 10 http://$IP/\n\n# Kill the remote process\n$REMOTE_EXEC "kill $PID"