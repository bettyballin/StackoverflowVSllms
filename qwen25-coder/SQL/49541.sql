UPDATE YourTable\nSET Column1 = OriginalValues.Column1,\n    Column2 = OriginalValues.Column2\nFROM YourTable\nJOIN OriginalValueTable AS OriginalValues\nON YourTable.PrimaryKey = OriginalValues.PrimaryKey;