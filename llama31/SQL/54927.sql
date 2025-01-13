ALTER FUNCTION udf_CappedDate\n(\n    @DateTimeIn datetime\n)\nRETURNS datetime\nWITH SCHEMABINDING\nAS\nBEGIN\n    DECLARE @MinDate datetime = CONVERT(datetime, '19000101', 112)\n    DECLARE @MaxDate datetime = CONVERT(datetime, '21000101', 112)\n\n    IF @DateTimeIn < @MinDate\n        RETURN @MinDate\n    ELSE IF @DateTimeIn > @MaxDate\n        RETURN @MaxDate\n\n    RETURN @DateTimeIn\nEND