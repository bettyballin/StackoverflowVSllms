-- Create a table to store the scripts\nCREATE TABLE #ObjectScripts (\n    ObjectName NVARCHAR(255),\n    ObjectType NVARCHAR(255),\n    ScriptText NVARCHAR(MAX)\n);\n\n-- Insert the scripts of all stored procedures and functions into the table\nINSERT INTO #ObjectScripts (ObjectName, ObjectType, ScriptText)\nSELECT \n    o.name AS ObjectName,\n    o.type_desc AS ObjectType,\n    sm.definition AS ScriptText\nFROM \n    sys.sql_modules sm\nINNER JOIN \n    sys.objects o ON sm.object_id = o.object_id\nWHERE \n    o.type IN ('P', 'FN', 'IF', 'TF') -- P = Procedure, FN = Scalar Function, IF = Inline Table-Valued Function, TF = Table-Valued Function\n\n-- Select the scripts from the table\nSELECT \n    ObjectName,\n    ObjectType,\n    ScriptText\nFROM \n    #ObjectScripts;\n\n-- Drop the temporary table\nDROP TABLE #ObjectScripts;