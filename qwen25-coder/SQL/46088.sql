DECLARE @SomeDate datetime = '2009-05-28 16:30:22'\nSELECT CONVERT(datetime, CONVERT(date, @SomeDate)) AS TruncatedDate\n\n-- Alternatively using CAST:\nSELECT CAST(CAST(@SomeDate AS date) AS datetime) AS TruncatedDate