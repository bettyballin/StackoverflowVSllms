cat /proc/stat | grep cpu | awk '{print $4}'