DECLARE @bob AS VARCHAR(50);\nSET @bob = 'SweetDB';\n\n-- Use dynamic SQL to execute the USE statement with a variable\nEXEC ('USE ' + QUOTENAME(@bob) + ';');