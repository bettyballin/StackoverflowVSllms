SELECT Action, \n       [VIEW], \n       [EDIT]\nFROM (\n    SELECT Action, Type\n    FROM Actions\n) AS SourceTable\nPIVOT (\n    MAX(Type) FOR Type IN ([VIEW], [EDIT])\n) AS PivotTable;