# Writer script\nFIFO="/tmp/fifo"\n(\n    flock -x 200\n    echo "Your message here" > "$FIFO"\n) 200>/var/lock/myfifo.lock