SELECT ID, XML\nFROM YourTableName\nWHERE \n    ID <> CAST(\n        SUBSTRING(XML, \n                  CHARINDEX('ID="', XML) + 4,\n                  CHARINDEX('"', XML, CHARINDEX('ID="', XML) + 5) - (CHARINDEX('ID="', XML) + 4)\n               ) AS INT\n        )