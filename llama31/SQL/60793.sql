CREATE DATABASE LINK mssql_link CONNECT TO username IDENTIFIED BY password\nUSING '(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=mssql_server)(PORT=1433))(CONNECT_DATA=(SERVICE_NAME=mssql_database)))';