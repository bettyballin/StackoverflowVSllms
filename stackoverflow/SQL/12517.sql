SELECT      u.name + '.' + t.name AS [table],\n            td.value AS [table_desc],\n            c.name AS [column],\n            cd.value AS [column_desc]\nFROM        sysobjects t\nINNER JOIN  sysusers u\n    ON      u.uid = t.uid\nLEFT OUTER JOIN sys.extended_properties td\n    ON      td.major_id = t.id\n    AND     td.minor_id = 0\n    AND     td.name = 'MS_Description'\nINNER JOIN  syscolumns c\n    ON      c.id = t.id\nLEFT OUTER JOIN sys.extended_properties cd\n    ON      cd.major_id = c.id\n    AND     cd.minor_id = c.colid\n    AND     cd.name = 'MS_Description'\nWHERE t.type = 'u'\nORDER BY    t.name, c.colorder