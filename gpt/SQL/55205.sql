SELECT \n    SplitResult.Item AS SplitValue, \n    t.ValueColumn1, \n    t.ValueColumn2\nFROM \n    MyTable t\nCROSS APPLY \n    dbo.Split(t.CommaColumn, ',') AS SplitResult