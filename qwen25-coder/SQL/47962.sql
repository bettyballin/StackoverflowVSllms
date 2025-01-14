DECLARE @UserName sysname\nSET @UserName = 'your_user_name_here' -- Replace with the specific user name\n\nCREATE TABLE #Permissions (\n    TableName sysname,\n    SELECT_Permission varchar(3),\n    DELETE_Permission varchar(3),\n    UPDATE_Permission varchar(3),\n    INSERT_Permission varchar(3),\n    ALTER_Permission varchar(3)\n)\n\nINSERT INTO #Permissions (TableName, SELECT_Permission, DELETE_Permission, UPDATE_Permission, INSERT_Permission, ALTER_Permission)\nSELECT \n    o.name AS TableName,\n    CASE WHEN p1.protecttype = 205 AND p1.action = 193 OR p2.actadd &= 1 THEN 'Yes' ELSE 'No' END AS SELECT_Permission,\n    CASE WHEN p1.protecttype = 205 AND p1.action = 197 OR p2.actadd &= 4 THEN 'Yes' ELSE 'No' END AS DELETE_Permission,\n    CASE WHEN p1.protecttype = 205 AND p1.action = 196 OR p2.actadd &= 2 THEN 'Yes' ELSE 'No' END AS UPDATE_Permission,\n    CASE WHEN p1.protecttype = 205 AND p1.action = 195 OR p2.actadd &= 8 THEN 'Yes' ELSE 'No' END AS INSERT_Permission,\n    CASE WHEN p1.protecttype = 205 AND p1.action = 26 ALTER OR p2.actadd &= 32 THEN 'Yes' ELSE 'No' END AS ALTER_Permission\nFROM sysobjects o\nLEFT JOIN sysprotects p1 ON o.id = p1.id \n    AND p1.grantee = (SELECT uid FROM syslogins WHERE loginame = @UserName) \n    AND p1.action IN (193, 195, 196, 197, 26)\nLEFT JOIN (\n    SELECT id, SUM(perm) AS actadd \n    FROM sysprotects \n    WHERE grantee = (SELECT uid FROM syslogins WHERE loginame = @UserName) \n        AND action IN (193, 195, 196, 197, 26)\n    GROUP BY id\n) p2 ON o.id = p2.id\nWHERE xtype = 'U'\n\n-- Replace spaces with NUL characters to display correctly in some environments\nSELECT TableName,\n       REPLACE(SELECT_Permission, ' ', '') AS SELECT_Permission,\n       REPLACE(DELETE_Permission, ' ', '') AS DELETE_Permission,\n       REPLACE(UPDATE_Permission, ' ', '') AS UPDATE_Permission,\n       REPLACE(INSERT_Permission, ' ', '') AS INSERT_Permission,\n       REPLACE(ALTER_Permission, ' ', '') AS ALTER_Permission\nFROM #Permissions\n\nDROP TABLE #Permissions