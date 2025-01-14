ALTER PROCEDURE [dbo].[SearchForums]\n(\n    @SearchText VARCHAR(200),\n    @GroupId INT = -1,\n    @ClientId INT,\n    @CurrentPage INT,\n    @PageSize INT,\n    @OutTotalRecCount INT OUTPUT\n)\nAS\nBEGIN\n    SET NOCOUNT ON;\n\n    -- Create a temp table to store search results with relevance\n    CREATE TABLE #SearchResults\n    (\n        Relevance INT,\n        ThreadID INT,\n        PostID INT,\n        [Description] VARCHAR(2000),\n        Author BIGINT\n    );\n\n    -- Create and populate table of all GroupID's this search will return from\n    CREATE TABLE #GroupsToSearch\n    (\n        GroupId INT\n    );\n\n    IF @GroupId = -1\n    BEGIN\n        INSERT INTO #GroupsToSearch\n        SELECT GroupID \n        FROM SNetwork_Groups \n        WHERE ClientId = @ClientId;\n    END\n    ELSE\n    BEGIN\n        INSERT INTO #GroupsToSearch (GroupId)\n        VALUES (@GroupId);\n    END\n\n    -- Get Thread Titles\n    INSERT INTO #SearchResults\n    SELECT \n        ft.RANK AS Relevance,\n        t.ThreadId,\n        NULL AS PostId,\n        t.[Description],\n        t.[OwnerUserId]\n    FROM \n        SNetwork_Threads t\n    INNER JOIN \n        SNetwork_Groups g ON g.GroupId = t.GroupId\n    INNER JOIN \n        CONTAINSTABLE(SNetwork_Threads, [Description], @SearchText) ft ON t.ThreadId = ft.[KEY]\n    WHERE \n        g.GroupID IN (SELECT GroupID FROM #GroupsToSearch)\n        AND g.ClientId = @ClientId;\n\n    -- Get Thread Descriptions\n    INSERT INTO #SearchResults\n    SELECT \n        ft.RANK AS Relevance,\n        t.ThreadId,\n        p.PostId,\n        p.[Description],\n        p.[OwnerUserId]\n    FROM \n        SNetwork_Posts p\n    INNER JOIN \n        SNetwork_Threads t ON t.ThreadId = p.ThreadId\n    INNER JOIN \n        SNetwork_Groups g ON g.GroupId = t.GroupId\n    INNER JOIN \n        CONTAINSTABLE(SNetwork_Posts, [Description], @SearchText) ft ON p.PostId = ft.[KEY]\n    WHERE \n        g.GroupID IN (SELECT GroupID FROM #GroupsToSearch)\n        AND g.ClientId = @ClientId;\n\n    -- Get total record count for pagination\n    SELECT @OutTotalRecCount = COUNT(*)\n    FROM #SearchResults;\n\n    -- Select paginated results\n    SELECT *\n    FROM #SearchResults\n    ORDER BY Relevance DESC\n    OFFSET (@CurrentPage - 1) * @PageSize ROWS\n    FETCH NEXT @PageSize ROWS ONLY;\n\n    -- Clean up\n    DROP TABLE #SearchResults;\n    DROP TABLE #GroupsToSearch;\n\n    SET NOCOUNT OFF;\nEND;