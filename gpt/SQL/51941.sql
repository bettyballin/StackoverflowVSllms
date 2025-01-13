DECLARE @DatabaseName NVARCHAR(128);\n    DECLARE @SQL NVARCHAR(MAX);\n\n    -- Assign the appropriate database name based on the environment\n    SET @DatabaseName = CASE\n        WHEN @@SERVERNAME LIKE '%development%' THEN 'db1-development'\n        WHEN @@SERVERNAME LIKE '%production%' THEN 'db1-production'\n        ELSE 'db1-unknown'  -- Handle other environments if necessary\n    END;\n\n    -- Construct the query dynamically\n    SET @SQL = 'SELECT * FROM [' + @DatabaseName + '].[schema].[table]';\n\n    -- Execute the dynamically constructed query\n    EXEC sp_executesql @SQL;