DECLARE @x XML\nSET @x = '<root><a>123</a></root>'\n\n-- Check if the text content of the XML can be cast to an integer\nSELECT @x.value('(/root/a)[1]', 'varchar(max)') AS TextContent,\n       CASE WHEN ISNUMERIC(@x.value('(/root/a)[1]', 'varchar(max)')) = 1 AND @x.value('(/root/a)[1]', 'varchar(max)') NOT LIKE '%.%' THEN 1 ELSE 0 END AS IsInteger