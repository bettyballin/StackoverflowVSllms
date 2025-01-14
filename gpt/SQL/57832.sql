DECLARE @BackupDirectory NVARCHAR(256);\nEXEC xp_instance_regread \n    N'HKEY_LOCAL_MACHINE', \n    N'Software\Microsoft\MSSQLServer\MSSQLServer', \n    N'BackupDirectory', \n    @BackupDirectory OUTPUT;\n\nSELECT @BackupDirectory AS [Default Backup Directory];