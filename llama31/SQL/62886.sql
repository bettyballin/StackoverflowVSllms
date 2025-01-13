CREATE PROCEDURE PagedSearch\n    @SearchCriteria nvarchar(100),\n    @PageSize int,\n    @PageNumber int,\n    @ReturnCountOnly bit = 0\nAS\nBEGIN\n    DECLARE @Results TABLE (Id int, Column1 nvarchar(100), Column2 nvarchar(100));\n\n    WITH SearchResults AS (\n        SELECT Id, Column1, Column2\n        FROM YourTable\n        WHERE Column1 LIKE '%' + @SearchCriteria + '%'\n        OR Column2 LIKE '%' + @SearchCriteria + '%'\n    )\n    INSERT INTO @Results\n    SELECT TOP (@PageSize * @PageNumber) *\n    FROM SearchResults;\n\n    IF @ReturnCountOnly = 1\n    BEGIN\n        SELECT COUNT(*) FROM @Results;\n    END\n    ELSE\n    BEGIN\n        SELECT TOP (@PageSize) *\n        FROM @Results\n        ORDER BY Id\n        OFFSET (@PageSize * (@PageNumber - 1)) ROWS;\n    END\nEND