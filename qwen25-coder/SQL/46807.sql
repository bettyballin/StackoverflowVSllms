SELECT TOP 2 *\nFROM (\n    SELECT YourFields\n    FROM YourTable\n    WHERE LinkField = Forms!YourMainFormName!LinkControlName\n) AS SubQuery\nORDER BY SomeField;  -- You need to specify the field by which you want to determine "top" records