CREATE FUNCTION dbo.SplitStrings_XML\n(\n    @List NVARCHAR(MAX),\n    @Delimiter CHAR(1)\n) RETURNS TABLE\nAS\nRETURN \n(  \n    SELECT LTRIM(RTRIM(Split.a.value('.', 'NVARCHAR(MAX)'))) AS Keyword\n    FROM (SELECT CAST ('<M>' + REPLACE(@List,@Delimiter,'</M><M>')+'</M>' AS XML) AS String) AS A \n    CROSS APPLY String.nodes ('/M') AS Split(a)\n);\nGO