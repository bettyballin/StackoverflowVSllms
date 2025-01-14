DECLARE @sql NVARCHAR(MAX);\nDECLARE @PersonID INT = 1; -- Replace with actual person ID logic\n\nSELECT @sql = N'SELECT P.name, ' +\n              CASE \n                  WHEN wantsSportscar = 1 THEN ', (select count(*) from cars C where C.type = ''sports'') AS sportscars'\n                  ELSE ''\n              END + \n              CASE \n                  WHEN wantsFamilycar = 1 THEN ', (select count(*) from cars C where C.type = ''family'') AS familycars'\n                  ELSE ''\n              END +\n              CASE \n                  WHEN wantsBusinesscar = 1 THEN ', (select count(*) from cars C where C.type = ''business'') AS businesscars'\n                  ELSE ''\n              END\nFROM people P\nWHERE P.id = @PersonID;\n\nSET @sql = @sql + N' FROM people WHERE ID = ' + CAST(@PersonID AS NVARCHAR);\n\nEXEC sp_executesql @sql;