SELECT \n    s.id,\n    split.pn,\n    split.s\nFROM \n    Stuff s\nCROSS APPLY \n    dbo.Split(',', s.myColumn) AS split\nWHERE \n    ISNULL(split.s, '') <> '';