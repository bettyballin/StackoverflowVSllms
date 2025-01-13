SELECT \n    SUM(i.Items) FILTER (WHERE it.GroupType = 'A') AS SumGroupA,\n    SUM(i.Items) FILTER (WHERE it.GroupType = 'B') AS SumGroupB\nFROM \n    ItemTable i\nLEFT OUTER JOIN \n    ItemType it ON i.ItemTypeID = it.ItemTypeID;