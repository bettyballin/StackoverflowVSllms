#!/bin/bash\n\n# Replace these variables with your actual database connection details\nDB_USER="your_username"\nDB_PASSWORD="your_password"\nDATABASE_NAME="your_database"\n\n# List of SQL files to execute\nSQL_FILES=(\n    "createSP1.sql"\n    "createSP2.sql"\n    # Add more SQL files as needed\n)\n\n# Loop through each SQL file and run it against the database\nfor sql_file in "${SQL_FILES[@]}"; do\n  echo "Executing $sql_file..."\n  mysql -u $DB_USER -p$DB_PASSWORD $DATABASE_NAME < "$sql_file"\ndone\n\necho "All scripts executed."