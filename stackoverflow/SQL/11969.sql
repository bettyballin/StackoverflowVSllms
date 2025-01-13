SELECT table_name, LEFT(column_names , LEN(column_names )-1) AS column_names\nFROM information_schema.columns AS extern\nCROSS APPLY\n(\n    SELECT column_name + ','\n    FROM information_schema.columns AS intern\n    WHERE extern.table_name = intern.table_name\n    FOR XML PATH('')\n) pre_trimmed (column_names)\nGROUP BY table_name, column_names;