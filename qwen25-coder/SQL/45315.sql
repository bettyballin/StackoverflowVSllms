CREATE FUNCTION dbo.SplitStringToTable (@string NVARCHAR(MAX), @delimiter CHAR(1))\nRETURNS TABLE \nAS \nRETURN \n(\n    WITH Split(str, xmlContent) AS (\n        SELECT @string, CAST('<root><item>' + REPLACE(@string, @delimiter, '</item><item>') + '</item></root>' AS XML)\n    )\n    SELECT item.value('.', 'NVARCHAR(1024)') as SplitVal\n    FROM Split \n    CROSS APPLY xmlContent.nodes('/root/item') AS x(item)\n);