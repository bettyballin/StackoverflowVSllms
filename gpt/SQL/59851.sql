DECLARE @sampleString NVARCHAR(100)\nSET @sampleString = 'Hello World'\n\n-- Get the ASCII value of the first character\nSELECT ASCII(@sampleString) AS ASCII_Value\n\n-- Convert ASCII value to character\nSELECT CHAR(72) AS Character_Value\n\n-- Find the position of a substring\nSELECT CHARINDEX('World', @sampleString) AS Position\n\n-- Extract a substring\nSELECT SUBSTRING(@sampleString, 7, 5) AS Substring\n\n-- Replace a substring\nSELECT REPLACE(@sampleString, 'World', 'SQL') AS ReplacedString\n\n-- Convert to upper case\nSELECT UPPER(@sampleString) AS UpperCaseString\n\n-- Reverse the string\nSELECT REVERSE(@sampleString) AS ReversedString