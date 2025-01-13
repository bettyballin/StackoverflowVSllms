CREATE FUNCTION CheckDateOverlap (@UserId INT, @DateFrom DATETIME, @DateTo DATETIME)\nRETURNS BIT\nAS\nBEGIN\n    IF EXISTS (\n        SELECT 1\n        FROM YourTable\n        WHERE UserId = @UserId\n          AND (@DateFrom BETWEEN DateFrom AND DateTo OR @DateTo BETWEEN DateFrom AND DateTo OR (@DateFrom <= DateFrom AND @DateTo >= DateTo))\n    )\n    BEGIN\n        RETURN 0; -- overlap found\n    END\n    RETURN 1; -- no overlap found\nEND\nGO\n\nALTER TABLE YourTable\nADD CONSTRAINT CHK_NoDateOverlap CHECK (dbo.CheckDateOverlap(UserId, DateFrom, DateTo) = 1)