sftp -oBatchMode=no user@remote_host:/destination/path <<EOF\n   put /path/to/compressed/database.zip\n   EOF