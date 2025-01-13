# queue_runner.sh\nLOCK_FILE=/var/lock/my_script.lock\nSCRIPT=my_script.sh\n\nif flock -n -x 200; then\n    # Acquired lock, run the script\n    $SCRIPT\n    # Release lock\n    flock -u 200\nelse\n    # Lock is held by another process, exit\n    exit 0\nfi