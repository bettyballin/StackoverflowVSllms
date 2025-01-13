CREATE PROCEDURE YourStoredProcedure\n    @param INT\nAS\nBEGIN\n    IF @param IS NOT NULL\n    BEGIN\n        SELECT name \n        FROM Table1 \n        WHERE EXISTS (\n            SELECT 1 \n            FROM Table2 \n            WHERE param = @param \n              AND ... /* other conditions */\n        )\n        AND ... /* other conditions */\n    END\n    ELSE\n    BEGIN\n        SELECT name \n        FROM Table1 \n        WHERE ... /* other conditions */\n    END\nEND