gunzip -c /path/to/destination/database_dump.sql.gz | psql -U [username] -h [destination_host] [database_name]