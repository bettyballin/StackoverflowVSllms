#!/bin/bash\n\n# Set the SVN repository URL and the production server FTP details\nSVN_REPO="https://your-svn-repo.com/repo"\nFTP_HOST="ftp.your-production-server.com"\nFTP_USER="your-ftp-username"\nFTP_PASSWORD="your-ftp-password"\nFTP_DIR="/path/to/your/site"\n\n# Get the list of changed files using svn status\nCHANGED_FILES=$(svn status --no-ignore | grep '^M' | awk '{print $2}')\n\n# Use lftp to upload the changed files\nlftp -u $FTP_USER,$FTP_PASSWORD $FTP_HOST << EOF\ncd $FTP_DIR\n$mput $CHANGED_FILES\nEOF