#!/bin/bash\n\n# Configuration variables\nDB_USER="your_db_user"\nDB_PASSWORD="your_db_password"\nEMAIL_SUCCESS="success@example.com"\nEMAIL_FAILURE="failure@example.com"\nSMTP_RELAY_HOST="smtp.gmail.com"\nSMTP_PORT=587\nSMTP_USERNAME="your_google_apps_email@gmail.com"\nSMTP_PASSWORD="your_google_apps_password"\n\n# Paths and files\nBACKUP_DIR="/path/to/backup"\nLOG_FILE="$BACKUP_DIR/backup.log"\nDATE=$(date +%F)\nERROR_FLAG=false\n\n# Function to send email\nsend_email() {\n  local subject=$1\n  local message=$2\n  local recipient=$3\n  \n  echo "$message" | mutt -s "$subject" \\n    --smtp-url="smtp://$SMTP_USERNAME:$SMTP_PASSWORD@$SMTP_RELAY_HOST:$SMTP_PORT/" \\n    --smtp-auth=login \\n    --smtp-starttls $recipient\n}\n\n# Function to handle backup of each database and errors\nbackup_database() {\n  local db_name=$1\n  local dump_file="$BACKUP_DIR/$db_name-$DATE.sql"\n  local zip_file="$dump_file.gz"\n\n  # Dump the MySQL database\n  mysqldump -u"$DB_USER" -p"$DB_PASSWORD" "$db_name" > "$dump_file"\n\n  # Check if dump was successful\n  if [ $? -ne 0 ]; then\n    echo "Failed to dump $db_name on $(date)" >> "$LOG_FILE"\n    ERROR_FLAG=true\n    return\n  fi\n\n  # Compress the dump file\n  gzip "$dump_file"\n\n  # Email the compressed file\n  send_email "[Backup Success] $db_name" "Attached is the backup for $db_name." -a "$zip_file" "$EMAIL_SUCCESS"\n  \n  if [ $? -ne 0 ]; then\n    echo "Failed to email $db_name on $(date)" >> "$LOG_FILE"\n    ERROR_FLAG=true\n  fi\n\n  # Remove the original dump file\n  rm -f "$dump_file"\n}\n\n# Get list of databases and backup each one\nfor db in $(mysql -u"$DB_USER" -p"$DB_PASSWORD" -e "SHOW DATABASES;" | grep -Ev "(Database|information_schema|performance_schema|sys)")\ndo\n  backup_database "$db"\ndone\n\n# Final error notification if any database failed to back up\nif [ "$ERROR_FLAG" = true ]; then\n  send_email "[Backup Error] Database Backup Failed" "There was a problem backing up one or more databases. Check $LOG_FILE for details." "$EMAIL_FAILURE"\nfi