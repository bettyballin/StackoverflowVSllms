USE [YourDatabaseName]\nGO\n\nSELECT \n    m.name AS MemberName,\n    r.name AS RoleName\nFROM \n    sysusers r\nJOIN \n    sysmembers rm ON r.uid = rm.groupuid\nJOIN \n    sysusers m ON rm.memberuid = m.uid\nWHERE \n    r.name = 'YourRoleName'\nGO