SELECT \n    -- ... (rest of your columns)\n    dbo.Fileimagepath(Table2.column21, Table2.column22) AS path\nFROM \n    -- ... (rest of your joins)\nWHERE \n    Envelope.column21 = 8\nFOR XML PATH('Table2'), ROOT('root')