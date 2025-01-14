SELECT TimeGenerated, SourceName, Message \n   FROM System \n   WHERE Type = 1 AND TimeGenerated >= SUB(SYSTEM_TIMESTAMP(), TIMESTAMP('00:00:24'))\n   ORDER BY TimeGenerated DESC;