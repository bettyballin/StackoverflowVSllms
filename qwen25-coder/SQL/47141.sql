CREATE FUNCTION dbo.SingleQuotes (@input NVARCHAR(MAX))\nRETURNS NVARCHAR(MAX)\nAS\nBEGIN\n    RETURN ''' + @input + '''\nEND