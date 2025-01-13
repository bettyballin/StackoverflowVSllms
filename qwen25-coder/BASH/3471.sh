#!/bin/bash\n\n   # Define your local and remote paths\n   LOCAL_PATH="/path/to/your/local/code"\n   REMOTE_USER="username"\n   REMOTE_HOST="remotehost.com"\n   REMOTE_PATH="/path/to/your/remote/code"\n\n   fswatch -0 "$LOCAL_PATH" | while read -d "" event; do\n       rsync -avz --delete $LOCAL_PATH/$event $REMOTE_USER@$REMOTE_HOST:$REMOTE_PATH/\n   done