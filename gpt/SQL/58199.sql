EXEC sp_executesql N'\n    -- Your synchronization script here\n    -- Example:\n    IF EXISTS (SELECT * FROM sys.objects WHERE type = ''P'' AND name = ''usp_MyProcedure'')\n    BEGIN\n        DROP PROCEDURE usp_MyProcedure;\n    END\n    GO\n\n    CREATE PROCEDURE usp_MyProcedure\n    AS\n    BEGIN\n        -- Procedure logic here\n        SELECT ''Hello, World!'';\n    END\n    GO\n';