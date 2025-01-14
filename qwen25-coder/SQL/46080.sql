-- Creating a new SQL Server Audit for successful login attempts\n   CREATE SERVER AUDIT [SecurityAudit]\n   TO FILE (FILEPATH = N'C:\SQLServerLogs\');\n   \n   CREATE SERVER AUDIT SPECIFICATION [SecurityAuditSpecification]\n   FOR SERVER AUDIT [SecurityAudit]\n   ADD (SUCCESSFUL_LOGIN_GROUP);\n   \n   ALTER SERVER AUDIT SPECIFICATION [SecurityAuditSpecification] WITH (STATE = ON);\n   ALTER SERVER AUDIT [SecurityAudit] WITH (STATE = ON);