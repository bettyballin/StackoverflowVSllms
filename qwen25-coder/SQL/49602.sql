DECLARE @Day INT = 12;\nDECLARE @Month INT = 1;\nDECLARE @Year INT = 2007;\n\n-- Ensure two-digit month and day\nDECLARE @FormattedDate NVARCHAR(10) = RIGHT('0' + CAST(@Month AS VARCHAR(2)), 2) \n                                   + '/' + RIGHT('0' + CAST(@Day AS VARCHAR(2)), 2) \n                                   + '/' + CAST(@Year AS VARCHAR(4));\n\n-- Convert the string to datetime\nSELECT CONVERT(DATETIME, @FormattedDate, 103) AS ConvertedDateTime;