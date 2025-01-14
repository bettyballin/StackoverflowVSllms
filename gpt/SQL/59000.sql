CREATE PROCEDURE dbo.GetTags\n    @TagNames dbo.TagTableType READONLY\nAS\nBEGIN\n    SELECT * \n    FROM Tags \n    WHERE Name IN (SELECT Name FROM @TagNames)\n    ORDER BY Count DESC;\nEND