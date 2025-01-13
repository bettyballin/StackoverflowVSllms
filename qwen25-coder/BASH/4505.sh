#!/bin/bash\n   # Change ownership of the file\n   OUTFILE_PATH="/var/lib/mysql-files/output_file_name.txt"\n   NEW_OWNER="your_user"\n\n   if [ -f "$OUTFILE_PATH" ]; then\n       sudo chown $NEW_OWNER:$NEW_OWNER "$OUTFILE_PATH"\n   fi