-- SQL command to create a new user and grant necessary privileges\nCREATE USER SCHEMA_NAME IDENTIFIED BY password;\nGRANT CONNECT, RESOURCE, DBA TO SCHEMA_NAME;