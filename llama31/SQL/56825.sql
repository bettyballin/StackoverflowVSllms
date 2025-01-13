CREATE SERVER AUDIT [MyAudit] TO FILE = 'C:\AuditLogs\MyAudit.log'\nWITH (FORMAT = XML, MAXSIZE = 10MB, MAX_FILES = 10);\n\nCREATE SERVER AUDIT SPECIFICATION [MyAuditSpec]\nFOR SERVER AUDIT [MyAudit]\nADD (DATABASE_OBJECT_ACCESS_GROUP)\nWITH (STATE = ON);