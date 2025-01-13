CREATE TYPE StringList AS TABLE (Value nvarchar(50));\nGO\n\nCREATE PROCEDURE GetProjects\n    @Keywords StringList READONLY\nAS\nBEGIN\n    SELECT *\n    FROM Projects\n    WHERE EXISTS (\n        SELECT 1\n        FROM @Keywords k\n        WHERE ProjectName LIKE '%' + k.Value + '%'\n    );\nEND\nGO\n\n-- Example usage:\nDECLARE @Keywords StringList;\nINSERT INTO @Keywords (Value) VALUES ('Oakland'), ('City'), ('Planning');\nEXEC GetProjects @Keywords;