awk "/^-- Table structure for table \`your_table_name\`/,/^-- Table structure for table/" your_dump_file.sql | mysql -u your_username -p your_database_name