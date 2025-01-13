ALTER TRIGGER [dandb_raw_searchNames]\n    ON [dandb_raw]\n    FOR INSERT, UPDATE\n    AS\nBEGIN\n    SET NOCOUNT ON\n\n    DECLARE @dunsId INT, @name VARCHAR(255)\n\n    DECLARE cur CURSOR FOR\n        SELECT dunsId, name FROM inserted\n\n    OPEN cur\n\n    FETCH NEXT FROM cur INTO @dunsId, @name\n\n    WHILE @@FETCH_STATUS = 0\n    BEGIN\n        UPDATE dandb\n            SET dandb.searchName = company_generateSearchName(dandb.name)\n            FROM dandb_raw dandb\n            WHERE dandb.dunsId = @dunsId\n\n        --Add new search matches\n        SELECT c.companyId, dandb.dunsId\n            INTO #newMatches\n            FROM dandb_raw dandb\n            INNER JOIN companies c\n                ON dandb.searchName = c.searchBrand\n                --avoid url matches that are potentially wrong\n                AND (lower(dandb.url) = lower(c.url)\n                    OR dandb.url = ''\n                    OR c.url = ''\n                    OR c.url is null)\n            WHERE dandb.dunsId = @dunsId\n\n        INSERT INTO #newMatches (companyId, dunsId)\n        SELECT c.companyId, max(dandb.dunsId) dunsId\n            FROM dandb_raw dandb\n            INNER JOIN\n                (\n                    select\n                    case when charindex('/',url) <> 0 then left(url, charindex('/',url)-1)\n                    else url\n                    end urlMatch, * from companies\n                ) c\n                ON dandb.url = c.urlMatch\n            where subsidiaryOf = 1 and isReported = 1 and dandb.url <> ''\n                and c.companyId not in (select companyId from #newMatches)\n            group by companyId\n            having count(dandb.dunsId) = 1\n\n        UPDATE cd\n            SET cd.dunsId = nm.dunsId\n            FROM companies_dandb cd\n            INNER JOIN #newMatches nm\n                ON cd.companyId = nm.companyId\n\n        FETCH NEXT FROM cur INTO @dunsId, @name\n\n        DROP TABLE #newMatches\n    END\n\n    CLOSE cur\n    DEALLOCATE cur\nEND\nGO