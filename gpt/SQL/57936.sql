DECLARE @x XML\nSET @x = '<root><a>123</a></root>'\n\n-- This query will return 1 if the content is an integer, otherwise 0\nSELECT @x.exist('/root[a castable as xs:int]')