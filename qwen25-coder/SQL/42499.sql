-- This hash should be pre-computed before running this SQL statement\nCREATE USER 'selectuser'@'localhost' \nIDENTIFIED WITH mysql_native_password BY 'your-precomputed-hash-here';\n\nGRANT SELECT ON myDB.* TO 'selectuser'@'localhost';