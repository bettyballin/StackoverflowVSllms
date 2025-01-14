DECLARE @html NVARCHAR(MAX) = N'<html>\n  <head>\n    <title>Bar</title>\n  </head>\n  <body>\n   <p>\n     this content my be found\n   </p>\n  </body>\n</html>';\n\n-- Example regex pattern to find 'this content my be found'\nDECLARE @pattern NVARCHAR(250) = N'this content my be found';\nDECLARE @escapedPattern NVARCHAR(MAX);\n\n-- Escape the search string for use in a regex pattern\nSET @escapedPattern = REPLACE(REPLACE(@pattern, '[', '[[]'), ']', '[]]');\n\nIF PATINDEX('%' + @escapedPattern + '%', CAST('[' + REPLACE(SUBSTRING(@html, CHARINDEX('<p>', @html) + 3, \n    LEN(@html) - CHARINDEX('</p>', REVERSE(@html)) - 4), ']', ']]') AS NVARCHAR(MAX))) > 0\nBEGIN\n    PRINT N'Text found.';\nEND\nELSE\nBEGIN\n    PRINT N'Text not found.';\nEND;