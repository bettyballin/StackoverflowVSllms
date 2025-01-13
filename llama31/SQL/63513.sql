WITH XMLNAMESPACES ('http://example.com/me' AS me)\nSELECT\n    Name AS 'name',\n    Age AS 'description',\n    XMLATTRIBUTES('me:age' AS 'xsi:type') AS 'description/@xsi:type',\n    Height AS 'description',\n    XMLATTRIBUTES('me:height' AS 'xsi:type') AS 'description/@xsi:type'\nFOR XML PATH('person')