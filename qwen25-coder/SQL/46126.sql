-- Example of converting nvarchar(10) to datetime, assuming 'MM/DD/YYYY' format\nUPDATE YourTableName\nSET BusinessDate = CONVERT(datetime, BusinessDate, 101);