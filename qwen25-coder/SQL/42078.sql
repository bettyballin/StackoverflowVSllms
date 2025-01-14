CREATE PROCEDURE CalculateMonthlyVariance\n    @OfficeId INT,\n    @FieldToCompare VARCHAR(255),\n    @CurrentMonth DATE,\n    @PreviousMonth DATE\nAS\nBEGIN\n    DECLARE @Query NVARCHAR(MAX);\n\n    SET @Query = N'\n        SELECT \n            OfficeID,\n            ' + QUOTENAME(@FieldToCompare) + N' AS CurrentValue,\n            LAG(' + QUOTENAME(@FieldToCompare) + ') OVER (PARTITION BY OfficeID ORDER BY SnapshotDate) AS PreviousValue,\n            (' + QUOTENAME(@FieldToCompare) + N' - LAG(' + QUOTENAME(@FieldToCompare) + ') OVER (PARTITION BY OfficeID ORDER BY SnapshotDate)) AS Variance\n        FROM \n            YourViewName\n        WHERE OfficelD = @OfficeId AND SnapshotDate IN (@CurrentMonth, @PreviousMonth);';\n\n    EXEC sp_executesql @Query,\n                       N'@OfficeId INT, @CurrentMonth DATE, @PreviousMonth DATE',\n                       @OfficeId=@OfficeId, @CurrentMonth=@CurrentMonth, @PreviousMonth=@PreviousMonth;\nEND