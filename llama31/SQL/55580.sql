SELECT * \nFROM CONTAINSTABLE(Table, SearchField, 'c#', LANGUAGE N'NEUTRAL') AS ct\nINNER JOIN Table ON Table.PrimaryKey = ct.[KEY]