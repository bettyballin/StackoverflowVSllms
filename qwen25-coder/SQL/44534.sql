CREATE PROCEDURE GetOuterData\nAS\nBEGIN\n    -- Call the inner stored procedure\n    EXEC GetInnerData;\n\n    -- Directly select the data you need to return\n    SELECT Column1, Column2\n    FROM YourTable;\nEND;