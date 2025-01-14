-- Check version which can give hints about the database type\nSELECT * FROM v$version;\n\n-- Use a specific schema (or view all accessible tables)\n-- List all tables in current user's schema\nSELECT table_name FROM USER_TABLES;\n-- Or list all accessible tables\nSELECT table_name FROM all_tables;\n\n-- Describe table structure\nDESCRIBE <table_name>;