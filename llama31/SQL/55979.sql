ALTER PROCEDURE dbo.spSelectBenchEvent\n(\n    @EVENT_DATE DATE\n)\nAS\nBEGIN\n    SET NOCOUNT ON;\n\n    SELECT ID, EID, BENCHID, PACCODE, START_TIME, END_TIME\n    FROM tbl_benchbook\n    WHERE DATEADD(dd, 0, DATEDIFF(dd, 0, START_TIME)) = @EVENT_DATE\n    ORDER BY START_TIME\nEND