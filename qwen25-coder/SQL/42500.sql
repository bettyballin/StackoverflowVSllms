CREATE USER 'selectuser'@'localhost' \nIDENTIFIED WITH caching_sha2_password BY 'your-plain-password-here';\n\nGRANT SELECT ON myDB.* TO 'selectuser'@'localhost';