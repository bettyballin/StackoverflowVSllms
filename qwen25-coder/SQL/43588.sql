INSERT INTO @search_temp_table\nSELECT * \nFROM (\n    SELECT d.DataId, (SELECT [Name] FROM Category WHERE CategoryId = d.CategoryId) AS 'Category', \n           d.Description, d.CompanyName, d.City, d.CategoryId,\n           d.CreatedOn, d.Rank, d.voteCount, d.commentCount, d.viewCount\n    FROM Data d \n    INNER JOIN Keyword k ON d.DataId = k.DataId\n    WHERE FREETEXT(k.Keyword, @SearchQ) \n      AND (d.CategoryId IN (1, 2, 3) OR @CategoryId IS NULL)\n      AND (@CategoryId IS NULL OR d.CategoryId = @CategoryId)\n      AND d.IsSearch=1 AND d.IsApproved=1 \n) AS Search_Data