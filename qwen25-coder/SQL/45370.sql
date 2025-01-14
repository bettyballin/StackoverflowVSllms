CREATE FUNCTION dbo.myFunction(\n    @areas VARCHAR(MAX)\n)\nRETURNS VARCHAR(8000)\nAS\nBEGIN\n    DECLARE @Result TABLE (Value VARCHAR(100))\n\n    -- Use the split function to separate values into a table\n    INSERT INTO @Result\n    SELECT Value FROM dbo.fn_Split(@areas, ',')\n\n    -- Example logic using IN with results from the split function\n    IF EXISTS(\n        SELECT 1 \n        FROM someothertable \n        WHERE othercolumn IN (SELECT Value FROM @Result)\n    )\n    BEGIN\n        RETURN 'Found'\n    END\n\n    RETURN 'Not Found'\nEND