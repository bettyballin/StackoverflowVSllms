-- Turn on login auditing via server properties or sp_configure\n  EXEC xp_instance_regwrite N'HKEY_LOCAL_MACHINE', \n       N'Software\Microsoft\MSSQLServer\MSSQLServer',\n       N'AuditLevel', REG_DWORD, 3; -- Audit successful and failed logins.