#!/bin/bash\nDEVICE=$1\nMOUNT_POINT="/mnt/backup"\nmkdir -p $MOUNT_POINT\nmount /dev/$DEVICE $MOUNT_POINT\ncp /path/to/source/files $MOUNT_POINT\numount $MOUNT_POINT