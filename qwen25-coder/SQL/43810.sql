SELECT \n    IIF(IsNull([Column1]), "NULL_VALUE", [Column1]) AS Column1,\n    IIF(IsNull([Column2]), "NULL_VALUE", [Column2]) AS Column2,\n    -- Add more fields as necessary...\nFROM [qry vaBaseQuery-S2]\nUNION ALL\nSELECT \n    IIF(IsNull([Column1]), "NULL_VALUE", [Column1]) AS Column1,\n    IIF(IsNull([Column2]), "NULL_VALUE", [Column2]) AS Column2,\n    -- Add more fields as necessary...\nFROM [qry BaseQuery];