SELECT M.ID, R.ID AS RelatedTableID,....\nFROM MyTable M INNER JOIN MyRelated Table R ON R.myTableId = M.Id\nUNION\nSELECT M.ID, R.ID AS RelatedTableID,....\nFROM MyTable M, MyRelatedTable R\nWHERE R.RelatedAll = 1