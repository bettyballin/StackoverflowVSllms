SELECT t.*, ft.Rank\nFROM YourTable t\nINNER JOIN FREETEXTTABLE(YourTable, (Column1, Column2), 'your search terms') AS ft\nON t.ID = ft.[Key]\nORDER BY ft.Rank DESC;