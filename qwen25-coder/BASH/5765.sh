# Backup\n     couchbackup --url http://localhost:5984/your_database > backup.txt\n     \n     # Restore\n     cat backup.txt | couchload --url http://localhost:5984/your_database